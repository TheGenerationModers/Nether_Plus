package nether_plus.common.config;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import net.minecraftforge.common.config.Property;
import nether_plus.common.Nether_plus;

public class Version implements Runnable
{
	public static Version instance = new Version();
	
	public enum EnumUpdateState
	{
		CURRENT, OUTDATED, CONNECTION_ERROR
	}
	
	public static final String VERSION = "@VERSION@";
	public static final String BUILD_NUMBER = "@BUILD_NUMBER@";
	public static final String MC_VERSION = "@MC_VERSION@";
	private static final String REMOTE_VERSION_FILE = ""/*à changer*/;
	private static final String REMOTE_CHANGELOG_ROOT = ""/*à changer*/;
	public static EnumUpdateState currentVersion = EnumUpdateState.CURRENT;
	public static final int FORGE_VERSION_MAJOR = 4;
	public static final int FORGE_VERSION_MINOR = 0;
	public static final int FORGE_VERSION_PATCH = 0;
	private static String recommendedVersion;
	private static String[] cachedChangelog;
	
	public static String getVersion()
	{
		return VERSION + " (:" + BUILD_NUMBER + ")";
	}

	public static boolean isOutdated()
	{
		return currentVersion == EnumUpdateState.OUTDATED;
	}
	
	public static boolean needsUpdateNoticeAndMarkAsSeen()
	{
		if (!isOutdated())
			return false;

		Property property = Nether_plus.configFile.get("vars", "version.seen", VERSION);
		property.comment = "indicates the last version the user has been informed about and will suppress further notices on it.";
		String seenVersion = property.getString();

		if (recommendedVersion == null || recommendedVersion.equals(seenVersion))
			return false;

		property.set(recommendedVersion);
		Nether_plus.configFile.save();
		return true;
	}
	
	public static String getRecommendedVersion()
	{
		return recommendedVersion;
	}

	public static void versionCheck()
	{
		try
		{
			if ("0.0.0".equals(VERSION))
				return;

			String location = REMOTE_VERSION_FILE;
			HttpURLConnection conn = null;
			while (location != null && !location.isEmpty())
			{
				URL url = new URL(location);

				if (conn != null)
					conn.disconnect();

				conn = (HttpURLConnection) url.openConnection();
				conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.0; ru; rv:1.9.0.11) Gecko/2009060215 Firefox/3.0.11 (.NET CLR 3.5.30729)");
				conn.connect();
				location = conn.getHeaderField("Location");
			}

			if (conn == null)
				throw new NullPointerException();

			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String line;
			while ((line = reader.readLine()) != null)
			{
				String[] tokens = line.split(":");
				if (MC_VERSION.matches(tokens[0])) {
					if (NPProperties.mod.matches(tokens[1]))
					{
						if (VERSION.matches(tokens[2]))
						{
							recommendedVersion = tokens[2];
							Nether_plus.npLog.finer("Using the latest version [" + getVersion() + "] for Minecraft " + MC_VERSION);
							currentVersion = EnumUpdateState.CURRENT;
							return;
						}
					}
				}
			}

			Nether_plus.npLog.warning("Using outdated version [" + VERSION + " (build:" + BUILD_NUMBER + ")] for Minecraft " + MC_VERSION + ". Consider updating.");
			currentVersion = EnumUpdateState.OUTDATED;

			conn.disconnect();
			reader.close();
		} catch (Exception e)
		{
			Nether_plus.npLog.warning("Unable to read from remote version authority.");
			Nether_plus.npLog.warning(e.toString());
			currentVersion = EnumUpdateState.CONNECTION_ERROR;
		}
	}
	
	public static String[] getChangelog()
	{
		if (cachedChangelog == null)
		{
			cachedChangelog = grabChangelog(recommendedVersion);
		}
		return cachedChangelog;
	}

	public static String[] grabChangelog(String version)
	{

		try
		{
			String location = REMOTE_CHANGELOG_ROOT + version;
			HttpURLConnection conn = null;
			while (location != null && !location.isEmpty())
			{
				URL url = new URL(location);

				if (conn != null)
					conn.disconnect();

				conn = (HttpURLConnection) url.openConnection();
				conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.0; ru; rv:1.9.0.11) Gecko/2009060215 Firefox/3.0.11 (.NET CLR 3.5.30729)");
				conn.connect();
				location = conn.getHeaderField("Location");
			}
			if (conn == null)
				throw new NullPointerException();

			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			conn.disconnect();

			String line;
			ArrayList<String> changelog = new ArrayList<String>();
			while ((line = reader.readLine()) != null)
			{
				if (line.startsWith("#"))
				{
					continue;
				}
				if (line.isEmpty())
				{
					continue;
				}

				changelog.add(line);
			}
			return changelog.toArray(new String[0]);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			Nether_plus.npLog.warning("Unable to read changelog from remote site.");
		}
		return new String[]{String.format("Unable to retrieve changelog for %s %s", NPProperties.mod, version)};
	}
	
	@Override
	public void run()
	{
		int count = 0;
		currentVersion = null;

		Nether_plus.npLog.info("Beginning version check");

		try {
			while ((count < 3) && ((currentVersion == null) || (currentVersion == EnumUpdateState.CONNECTION_ERROR)))
			{
				versionCheck();
				count++;

				if (currentVersion == EnumUpdateState.CONNECTION_ERROR)
				{
					Nether_plus.npLog.info("Version check attempt " + count + " failed, trying again in 10 seconds");
					Thread.sleep(10000);
				}
			}
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		if (currentVersion == EnumUpdateState.CONNECTION_ERROR)
		{
			Nether_plus.npLog.info("Version check failed");
		}
	}
	
	public static void check()
	{
		new Thread(instance).start();
	}
}
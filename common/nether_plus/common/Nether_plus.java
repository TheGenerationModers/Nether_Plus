package nether_plus.common;

import java.io.File;
import java.util.List;
import java.util.logging.Logger;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import nether_plus.common.block.NPBlockList;
import nether_plus.common.config.NPProperties;
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;
import nether_plus.common.entity.NPEntityList;
import nether_plus.common.event.FarmingNether;
import nether_plus.common.event.GrimBoneMeal;
import nether_plus.common.event.LivingEvent;
import nether_plus.common.event.ModBucket;
import nether_plus.common.gui.GuiHandler;
import nether_plus.common.item.NPItemList;
import nether_plus.common.recipe.NPRecipe;
import nether_plus.common.tileentity.NPTEntityList;
import nether_plus.proxy.NPCommonProxy;
import nether_plus.proxy.network.ClientPacketHandler;
import nether_plus.proxy.network.ServerPacketHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "nether_plus", name = "Nether plus", version = "1.0.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false,
clientPacketHandlerSpec = @SidedPacketHandler(channels = {"Nether_Plus"}, packetHandler = ClientPacketHandler.class),
serverPacketHandlerSpec = @SidedPacketHandler(channels = {"Nether_Plus"}, packetHandler = ServerPacketHandler.class))
public class Nether_plus
{
	@SidedProxy(clientSide = "nether_plus.proxy.NPClientProxy", serverSide = "nether_plus.proxy.NPCommonProxy")
	public static NPCommonProxy proxy;

	@Instance("nether_plus")
	public static Nether_plus instance;
	
	public static File ConfigFile;
	public static Logger NPlog = Logger.getLogger("Nether_Plus");
	
	protected static final GuiHandler GuiHandler = new GuiHandler();
	
	@EventHandler
	public void preload(FMLPreInitializationEvent event)
	{
		NPlog.setParent(FMLLog.getLogger());
		
		ConfigFile = new File(event.getModConfigurationDirectory(), "Nether_Plus.cfg");
		Configuration cfg = new Configuration(ConfigFile);
		try
		{
			cfg.load();
			//Blocks
			NPProperties.GlowstoneSandID = cfg.getBlock("GlowstoneSand", 600).getInt();
			NPProperties.SoulGlassID = cfg.getBlock("SoulGlass", 601).getInt();
			NPProperties.NetherrazeID = cfg.getBlock("Netherraze", 602).getInt();
			NPProperties.BewitchedWoodID = cfg.getBlock("BewitchedWood", 603).getInt();
			NPProperties.CorruptionStoneID = cfg.getBlock("CorruptionStone", 604).getInt();
			NPProperties.CorruptedCobblestoneID = cfg.getBlock("CorruptedCobblestone", 605).getInt();
			NPProperties.GrimwoodLogID = cfg.getBlock("GrimwoodLog", 606).getInt();
			NPProperties.GrimwoodLeavesID = cfg.getBlock("GrimwoodLeaves", 607).getInt();
			NPProperties.GrimwoodSaplingID = cfg.getBlock("GrimwoodSapling", 608).getInt();
			NPProperties.CorruptedGoldOreID = cfg.getBlock("CorruptedGoldOre", 609).getInt();
			NPProperties.CorruptedCharoiteOreID = cfg.getBlock("CorruptedCharoiteOre", 610).getInt();
			NPProperties.CorruptedBlackIronOreID = cfg.getBlock("CorruptedBlackIronOre", 611).getInt();
			NPProperties.GrimwoodPlanksID = cfg.getBlock("GrimwoodPlanks", 612).getInt();
			NPProperties.CorruptedBrickID = cfg.getBlock("CorruptedBrick", 613).getInt();
			NPProperties.NetherrackBrickID = cfg.getBlock("NetherrackBrick", 614).getInt();
			NPProperties.GrimwoodWorkbenchID = cfg.getBlock("GrimwoodWorkbench", 615).getInt();
			NPProperties.fourOffID = cfg.getBlock("fourOff", 616).getInt();
			NPProperties.fourOnID = cfg.getBlock("fourOn", 617).getInt();
			NPProperties.GrimwoodStairsID = cfg.getBlock("GrimwoodStairs", 618).getInt();
			NPProperties.CorruptedCobblestoneStairsID = cfg.getBlock("CorruptedCobblestoneStairs", 619).getInt();
			NPProperties.CorruptedBrickStairsID = cfg.getBlock("CorruptedBrickStairs", 620).getInt();
			NPProperties.NetherrackBrickStairsID = cfg.getBlock("NetherrackBrickStairs", 621).getInt();
			NPProperties.ModWoodDoubleSlabID = cfg.getBlock("ModWoodDoubleSlab", 622).getInt();
			NPProperties.ModWoodSlabID = cfg.getBlock("ModWoodSlab", 623).getInt();
			NPProperties.ModStoneDoubleSlabID = cfg.getBlock("ModStoneDoubleSlab", 624).getInt();
			NPProperties.ModStoneSlabID = cfg.getBlock("ModStoneSlab", 625).getInt();
			NPProperties.ModFenceID = cfg.getBlock("ModFence", 626).getInt();
			NPProperties.CorruptedCobblestoneWallID = cfg.getBlock("CorruptedCobblestoneWall", 627).getInt();
			NPProperties.CorruptedBrickWallID = cfg.getBlock("CorruptedBrickWall", 628).getInt();
			NPProperties.NetherrackBrickWallID = cfg.getBlock("NetherrackBrickWall", 629).getInt();
			NPProperties.GrimwoodChestID = cfg.getBlock("GrimwoodChest", 630).getInt();
			NPProperties.WhiteSkullID = cfg.getBlock("WhiteSkull", 631).getInt();
			NPProperties.BlackSkullID = cfg.getBlock("BlackSkull", 632).getInt();
			NPProperties.SoulGlassPaneID = cfg.getBlock("SoulGlassPane", 633).getInt();
			NPProperties.InfernumOreID = cfg.getBlock("InfenumOre", 634).getInt();
			NPProperties.InfernumBlockID = cfg.getBlock("InfernumBlock", 635).getInt();
			NPProperties.BlockGrimwoodDoorID = cfg.getBlock("BlockGrimwoodDoor", 636).getInt();
			NPProperties.BlackIronBlockID = cfg.getBlock("BlackIronBlock", 637).getInt();
			NPProperties.CharoiteBlockID = cfg.getBlock("CharoiteBlock", 638).getInt();
			NPProperties.Nether_FarmID = cfg.getBlock("Nether_Farm", 639).getInt();
			NPProperties.CropsID = cfg.getBlock("Crops", 640).getInt();
			NPProperties.ChiliCID = cfg.getBlock("ChiliC", 641).getInt();
			NPProperties.ChiliBID = cfg.getBlock("ChiliB", 642).getInt();
			NPProperties.RiceCID = cfg.getBlock("RiceC", 643).getInt();
			NPProperties.LadderID = cfg.getBlock("Lader", 644).getInt();
			NPProperties.NetherRailID = cfg.getBlock("NetherRail", 645).getInt();
			NPProperties.NetherDetectorRailID = cfg.getBlock("NetherDetectorRail", 646).getInt();
			NPProperties.NetherPoweredRailID = cfg.getBlock("NetherPoweredRail", 647).getInt();
			NPProperties.GrimwoodTorchID = cfg.getBlock("GrimwoodTorch", 648).getInt();
			NPProperties.NetherDonjonSpawnerID = cfg.getBlock("NetherDonjonSpawner", 649).getInt();
			
			NPProperties.QuicksilverMovingID = cfg.getBlock("QuicksilverMoving", 650).getInt();
			NPProperties.QuicksilverStillID = cfg.getBlock("QuicksilverStill", 651).getInt();
			NPProperties.SoulplasmMovingID = cfg.getBlock("SoulplasmMoving", 652).getInt();
			NPProperties.SoulplasmStillID = cfg.getBlock("SoulplasmStill", 653).getInt();
			NPProperties.AcidMovingID = cfg.getBlock("AcidMoving", 654).getInt();
			NPProperties.AcidStillID = cfg.getBlock("AcidStill", 655).getInt();
			//milk 656
			//milk 657
			NPProperties.SteelWoolID = cfg.getBlock("SteelWool", 658).getInt();

		
			//Items
			NPProperties.CharoiteCrystalID = cfg.getItem("CharoiteCrystal", 4000).getInt();
			NPProperties.BlackIronIngotID = cfg.getItem("BlaackIronIngot", 4001).getInt();
			NPProperties.BlackBoneID = cfg.getItem("BlackBone", 4002).getInt();
			NPProperties.BlackBoneMealID = cfg.getItem("BlackBoneMeal", 4003).getInt();
			NPProperties.FireslimeballID = cfg.getItem("Fireslimeball", 4004).getInt();
			
			NPProperties.SkeletonWhiteHelmetID = cfg.getItem("SkeletonWhiteHelmet", 4005).getInt();
			NPProperties.SkeletonWhiteChestplateID = cfg.getItem("SkeletonWhiteChestplate", 4006).getInt();
			NPProperties.SkeletonWhiteLeggingsID = cfg.getItem("SkeletonWhiteLeggings", 4007).getInt();
			NPProperties.SkeletonWhiteBootID = cfg.getItem("SkeletonWhiteBoot", 4008).getInt();
			
			NPProperties.SkeletonBlackHelmetID = cfg.getItem("SkeletonBlackHelmet", 4009).getInt();
			NPProperties.SkeletonBlackChestplateID = cfg.getItem("SkeletonBlackChestplate", 4010).getInt();
			NPProperties.SkeletonBlackLeggingsID = cfg.getItem("SkeletonBlackLeggings", 4011).getInt();
			NPProperties.SkeletonBlackBootID = cfg.getItem("SkeletonBlackBoot", 4012).getInt();
			
			NPProperties.GrimwoodSwordID = cfg.getItem("GrimwoodSword", 4013).getInt();
			NPProperties.GrimwoodPickaxeID = cfg.getItem("GrimwoodPickaxe", 4014).getInt();
			NPProperties.GrimwoodAxeID = cfg.getItem("GrimwoodAxe", 4015).getInt();
			NPProperties.GrimwoodShovelID = cfg.getItem("GrimwoodShovel", 4016).getInt();
			NPProperties.GrimwoodHoeID = cfg.getItem("GrimwoodHoe", 4017).getInt();
			NPProperties.GrimwoodStickID = cfg.getItem("GrimwoodStick", 4018).getInt();
			
			NPProperties.BloodGemID = cfg.getItem("BloodGem", 4019).getInt();
			NPProperties.InfernumIngotID = cfg.getItem("InfernumIngot", 4020).getInt();
			NPProperties.ItemGrimwoodDoorID = cfg.getItem("ItemGrimwoodDoor", 4021).getInt();
			
			NPProperties.WhiteWheatSeedsID = cfg.getItem("WhiteWheatSeeds", 4022).getInt();
			NPProperties.WhiteWheatID = cfg.getItem("WhiteWheat", 4023).getInt();
			NPProperties.ChiliSeedID = cfg.getItem("ChiliSeed", 4024).getInt();
			NPProperties.ChiliID = cfg.getItem("Chili", 4025).getInt();
			NPProperties.RiceID = cfg.getItem("Rice", 4026).getInt();
			NPProperties.DeadBreadID = cfg.getItem("DeadBread", 4027).getInt();
			NPProperties.GoldBucketID = cfg.getItem("GoldBucket", 4028).getInt();
			NPProperties.WaterBucketID = cfg.getItem("WaterBucket", 4029).getInt();
			NPProperties.LavaBucketID = cfg.getItem("LavaBucket", 4030).getInt();
			NPProperties.MilkBucketID = cfg.getItem("MilkBucket", 4031).getInt();
			NPProperties.QuickSilverBucketID = cfg.getItem("QuickSilverBucket", 4032).getInt();
			NPProperties.SoulplasmBucketID = cfg.getItem("SoulplasmBucket", 4033).getInt();
			NPProperties.AcidBucket1ID = cfg.getItem("AcidBucket1", 4034).getInt();
			NPProperties.AcidBucket2ID = cfg.getItem("AcidBucket2", 4035).getInt();

			NPProperties.BlackIronHelmetID = cfg.getItem("BlackIronHelmet", 4036).getInt();
			NPProperties.BlackIronChestplateID = cfg.getItem("BlackIronChestplate", 4037).getInt();
			NPProperties.BlackIronLeggingsID = cfg.getItem("BlackIronLeggings", 4038).getInt();
			NPProperties.BlackIronBootID = cfg.getItem("BlackIronBoot", 4039).getInt();
			
			NPProperties.BlackIronSwordID = cfg.getItem("BlackIronSword", 4040).getInt();
			NPProperties.BlackIronPickaxeID = cfg.getItem("BlackIronPickaxe", 4041).getInt();
			NPProperties.BlackIronAxeID = cfg.getItem("BlackIronAxe", 4042).getInt();
			NPProperties.BlackIronShovelID = cfg.getItem("BlackIronShovel", 4043).getInt();
			NPProperties.BlackIronHoeID = cfg.getItem("BlackIronHoe", 4044).getInt();
			
			NPProperties.SalamanderHelmetID = cfg.getItem("SalamanderHelmet", 4045).getInt();
			NPProperties.SalamanderChestplateID = cfg.getItem("SalamanderChestplate", 4046).getInt();
			NPProperties.SalamanderLeggingsID = cfg.getItem("SalamanderLeggings", 4047).getInt();
			NPProperties.SalamanderBootID = cfg.getItem("SalamanderBoot", 4048).getInt();
			NPProperties.SalamanderLeatherID = cfg.getItem("SalamanderLeather", 4049).getInt();
			
			NPProperties.SalamanderBoatID = cfg.getItem("SalamanderBoat", 4050).getInt();

		}
		catch(Exception ex)
		{
			NPlog.severe("Failed to load configuration");
		}
		finally
		{
			if(cfg.hasChanged())
			{
				cfg.save();
			}
			
			NPlog.info("Initialisation des ID's terminé!");
		}
		
		NetherPlusCreativeTabs.loadCreativeTab();//CreativeTab
		NPBlockList.loadBlock();//Block
		NPItemList.loadItem();//Item
		
		proxy.initSound();//Sound
	}

	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		NPEntityList.loadEntity();//Entity	
		this.removeRecipe(new ItemStack(Block.glowStone));
		
		proxy.registerRender();
		proxy.registerRenderEntity();

		MinecraftForge.EVENT_BUS.register(new GrimBoneMeal());
		MinecraftForge.EVENT_BUS.register(new LivingEvent());
		MinecraftForge.EVENT_BUS.register(new FarmingNether());
		
		//*1 /A enlevais d'apr� robin4002, mais j'attent son aide.
		ModBucket.INSTANCE.buckets.put(NPBlockList.QuicksilverStill, NPItemList.QuickSilverBucket);
		ModBucket.INSTANCE.buckets.put(NPBlockList.SoulplasmStill, NPItemList.SoulplasmBucket);
		ModBucket.INSTANCE.buckets.put(NPBlockList.AcidStill, NPItemList.AcidBucket1);
		ModBucket.INSTANCE.buckets.put(NPBlockList.AcidStill, NPItemList.AcidBucket2);
		MinecraftForge.EVENT_BUS.register(ModBucket.INSTANCE);
		//*1
		
		
		NPTEntityList.loadTileEntity();
		NetworkRegistry.instance().registerGuiHandler(this, GuiHandler);
	}

	@EventHandler
	public void modloaded(FMLPostInitializationEvent event)
	{
		LanguageRegistry.instance().loadLocalization("/mods/nether_plus/lang/en_US.lang", "en_US", false);
		LanguageRegistry.instance().loadLocalization("/mods/nether_plus/lang/fr_FR.lang", "fr_FR", false);
		NPRecipe.loadRecipe();//Recipe
		NPRecipe.loadSmelting();//Smelting
		
	}
	
	public static void removeRecipe(ItemStack par1)
	{
	     List<IRecipe> recipeList = CraftingManager.getInstance().getRecipeList();
	     for(int i=0;i<recipeList.size();i++)
	     {
	          IRecipe currentRecipe = recipeList.get(i);
	          if(currentRecipe instanceof ShapedRecipes)
	          {
	               ShapedRecipes shape = (ShapedRecipes)currentRecipe;
	               ItemStack output = shape.getRecipeOutput();
	               if(ItemStack.areItemStacksEqual(par1, output))
	               {
	                    recipeList.remove(i);
	               }
	          }

	          if(currentRecipe instanceof ShapelessRecipes)
	          {
	               ShapelessRecipes shapeless = (ShapelessRecipes)currentRecipe;
	               ItemStack output = shapeless.getRecipeOutput();
	               if(ItemStack.areItemStacksEqual(par1, output))
	               {
	                     recipeList.remove(i);
	               }
	          }
	     }
	}
}
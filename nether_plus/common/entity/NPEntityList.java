package nether_plus.common.entity;

import java.awt.Color;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import nether_plus.common.Nether_plus;
import cpw.mods.fml.common.registry.EntityRegistry;

public class NPEntityList
{
	public static void loadEntity()
	{
		EntityRegistry.registerGlobalEntityID(Salamander.class, "Salamandre", EntityRegistry.findGlobalUniqueEntityId(), new Color(255, 102, 0).getRGB(), new Color(0, 0, 0).getRGB());
		EntityRegistry.registerModEntity(Salamander.class, "Salamandre", 1, Nether_plus.instance, 40, 1, true);
		EntityRegistry.addSpawn(Salamander.class, 100, 7, 7, EnumCreatureType.creature, BiomeGenBase.hell);
		
		EntityRegistry.registerGlobalEntityID(Wight.class, "Wight", EntityRegistry.findGlobalUniqueEntityId(), new Color(255, 255, 255).getRGB(), new Color(0, 0, 0).getRGB());
		EntityRegistry.registerModEntity(Wight.class, "Wight", 2, Nether_plus.instance, 40, 1, true);
		EntityRegistry.addSpawn(Wight.class, 100, 7, 7, EnumCreatureType.creature, BiomeGenBase.hell);
		
		EntityRegistry.registerGlobalEntityID(Mogus.class, "Mogus", EntityRegistry.findGlobalUniqueEntityId(), new Color(156, 88, 37).getRGB(), new Color(255, 255, 255).getRGB());
		EntityRegistry.registerModEntity(Mogus.class, "Mogus", 3, Nether_plus.instance, 40, 1, true);
		EntityRegistry.addSpawn(Mogus.class, 75, 12, 12, EnumCreatureType.creature, BiomeGenBase.hell);
		
		EntityRegistry.registerGlobalEntityID(RedMogus.class, "RedMogus", EntityRegistry.findGlobalUniqueEntityId(), new Color(167, 37, 40).getRGB(), new Color(255, 255, 255).getRGB());
		EntityRegistry.registerModEntity(RedMogus.class, "RedMogus", 4, Nether_plus.instance, 40, 1, true);
		EntityRegistry.addSpawn(RedMogus.class, 75, 12, 12, EnumCreatureType.creature, BiomeGenBase.hell);
	}
}
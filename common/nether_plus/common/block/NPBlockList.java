package nether_plus.common.block;

import net.minecraft.block.Block;
//import net.minecraft.block.BlockFlowing;
//import net.minecraft.block.BlockFluid;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.MinecraftForge;
import nether_plus.common.Nether_plus;
import nether_plus.common.config.NPProperties;
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;
import cpw.mods.fml.common.registry.GameRegistry;

public class NPBlockList
{
	public static Block GlowstoneSand;
	public static Block SoulGlass;
	public static Block Netherraze;
	public static Block BewitchedWood;
	public static Block CorruptionStone;
	public static Block CorruptedCobblestone;
	
	public static Block GrimwoodLog;
	public static Block GrimwoodLeaves;
	public static Block GrimwoodSapling;
	
	public static Block CorruptedGoldOre;
	public static Block CorruptedCharoiteOre;
	public static Block CorruptedBlackIronOre;
	public static Block InfernumOre;
	public static Block InfernumBlock;
	public static Block BlackIronBlock;
	public static Block CharoiteBlock;
	
	public static Block GrimwoodPlanks;
	public static Block CorruptedBrick;
	public static Block NetherrackBrick;
	
	public static Block GrimwoodWorkbench;
	public static Block fourOff;
	public static Block fourOn;
	public static Block GrimwoodChest;
	
	public static Block GrimwoodStairs;
	public static Block CorruptedCobblestoneStairs;
	public static Block CorruptedBrickStairs;
	public static Block NetherrackBrickStairs;
	
	public static Block ModWoodSlab;
	public static Block ModWoodDoubleSlab;
	public static Block ModStoneSlab;
	public static Block ModStoneDoubleSlab;
	
	public static Block ModFence;
	public static Block CorruptedCobblestoneWall;
	public static Block CorruptedBrickWall;
	public static Block NetherrackBrickWall;
	
	public static Block WhiteSkull;
	public static Block BlackSkull;
	
	public static Block SoulGlassPane;
	
	public static Block BlockGrimwoodDoor;
	
	public static Block Nether_Farm;
	public static Block Crops;
	public static Block ChiliC;
	public static Block ChiliB;
	public static Block RiceC;
	
	public static Block Ladder;
	public static Block NetherRail;
	public static Block NetherDetectorRail;
	public static Block NetherPoweredRail;
	public static Block GrimwoodTorch;
	public static Block NetherDonjonSpawner;
	
	public static Block QuicksilverMoving;
	public static Block QuicksilverStill;
	public static Block SoulplasmMoving;
	public static Block SoulplasmStill;
	public static Block AcidMoving;
	public static Block AcidStill;
	
	public static Block SteelWool;
	
	public static void loadBlock()
	{
		//GlowstoneSand = new GlowstoneSand().setStepSound(Block.soundTypeSand).setLightLevel(1.0F).setHardness(0.5F).setBlockName("GlowstoneSand");
		GlowstoneSand = new GlowstoneSand().setStepSound(Block.soundTypeSand).setLightLevel(1.0F).setHardness(0.5F).setBlockName("GlowstoneSand").setBlockTextureName("nether_plus:GlowstoneSand");
		SoulGlass = new SoulGlass(null, false).setStepSound(Block.soundTypeGlass).setHardness(0.3F).setBlockName("SoulGlass").setBlockTextureName("nether_plus:SoulGlass");
		Netherraze = new Netherraze().setStepSound(Block.soundTypeStone).setLightLevel(0.4F).setHardness(3.0F).setBlockName("Netherraze");
		BewitchedWood = new BewitchedWood().setStepSound(Block.soundTypeWood).setHardness(2.0F).setBlockName("BewitchedWood");
		CorruptionStone = new CorruptionStone().setStepSound(Block.soundTypeStone).setHardness(1.0F).setBlockName("CorruptionStone").setBlockTextureName("nether_plus:CorruptionStone");
		CorruptedCobblestone = new CorruptedCobblestone().setStepSound(Block.soundTypeStone).setHardness(1.5F).setBlockName("CorruptedCobblestone");
		
		GrimwoodLog = new GrimwoodLog(NPProperties.GrimwoodLogID).setHardness(1.0F).setResistance(5F).setStepSound(Block.soundTypeWood).setBlockName("GrimwoodLog");
		GrimwoodLeaves = new GrimwoodLeaves(NPProperties.GrimwoodLeavesID).setHardness(0.5F).setResistance(5F).setStepSound(Block.soundTypeGrass).setBlockName("GrimwoodLeaves");
		GrimwoodSapling = new GrimwoodSapling(NPProperties.GrimwoodSaplingID).setHardness(0.0F).setResistance(5F).setStepSound(Block.soundTypeGrass).setBlockName("GrimwoodSapling");
		
		CorruptedGoldOre = new CorruptedGoldOre().setStepSound(Block.soundTypeStone).setHardness(3.0F).setResistance(5.0F).setBlockName("CorruptedGoldOre").setBlockTextureName("nether_plus:CorruptedGoldOre");
		CorruptedCharoiteOre = new CorruptedCharoiteOre().setStepSound(Block.soundTypeStone).setHardness(3.0F).setResistance(5.0F).setBlockName("CorruptedCharoiteOre").setBlockTextureName("nether_plus:CorruptedCharoiteOre");
		CorruptedBlackIronOre = new CorruptedBlackIronOre().setStepSound(Block.soundTypeStone).setHardness(3.0F).setResistance(5.0F).setBlockName("CorruptedBlackIronOre").setBlockTextureName("nether_plus:CorruptedBlackIronOre");
		InfernumOre = new InfernumOre().setStepSound(Block.soundTypeStone).setHardness(3.0F).setResistance(5.0F).setBlockName("InfernumOre").setBlockTextureName("nether_plus:InfernumOre");
		InfernumBlock = new InfernumBlock().setStepSound(Block.soundTypeStone).setHardness(3.0F).setResistance(5.0F).setBlockName("InfernumBlock").setBlockTextureName("nether_plus:InfernumBlock");
		BlackIronBlock = new BlackIronBlock().setStepSound(Block.soundTypeMetal).setHardness(3.0F).setResistance(5.0F).setBlockName("BlackIronBlock").setBlockTextureName("nether_plus:BlackIronBlock");
		CharoiteBlock = new CharoiteBlock().setStepSound(Block.soundTypeMetal).setHardness(3.0F).setResistance(5.0F).setBlockName("CharoiteBlock").setBlockTextureName("nether_plus:CharoiteBlock");
		
		GrimwoodPlanks = new GrimwoodPlanks().setStepSound(Block.soundTypeWood).setHardness(2.0F).setResistance(5.0F).setBlockName("GrimwoodPlanks").setBlockTextureName("nether_plus:GrimwoodPlanks");
		CorruptedBrick = new CorruptedBrick(NPProperties.CorruptedBrickID, Material.rock).setStepSound(Block.soundTypeStone).setHardness(1.5F).setResistance(7.0F).setBlockName("CorruptedBrick").setBlockTextureName("nether_plus:CorruptedBrick");
		NetherrackBrick = new NetherrackBrick(NPProperties.NetherrackBrickID, Material.rock).setStepSound(Block.soundTypeStone).setHardness(1.5F).setResistance(7.0F).setBlockName("NetherrackBrick").setBlockTextureName("nether_plus:NetherrackBrick");
		GrimwoodWorkbench  = new GrimwoodWorkbench(NPProperties.GrimwoodWorkbenchID).setStepSound(Block.soundTypeWood).setHardness(1.5F).setResistance(5.0F).setBlockName("GrimwoodWorkbench");
		GrimwoodChest = new GrimwoodChest(NPProperties.GrimwoodChestID).setStepSound(Block.soundTypeWood).setHardness(2.0F).setResistance(5.0F).setBlockName("GrimwoodChest");
		fourOn = new BlockFour(NPProperties.fourOnID, true).setStepSound(Block.soundTypeStone).setHardness(1.5F).setResistance(7.0F).setBlockName("CorruptedFurnace");
		fourOff = new BlockFour(NPProperties.fourOffID, false).setStepSound(Block.soundTypeStone).setHardness(1.5F).setResistance(7.0F).setBlockName("CorruptedFurnace").setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
		
		WhiteSkull = new WhiteSkull(NPProperties.WhiteSkullID).setStepSound(Block.soundTypeStone).setHardness(1.0F).setResistance(1.0F).setBlockName("WhiteSkull");
		BlackSkull = new BlackSkull(NPProperties.BlackSkullID).setStepSound(Block.soundTypeStone).setHardness(1.0F).setResistance(1.0F).setBlockName("BlackSkull");
		
		GrimwoodStairs = new ModStairs(NPProperties.GrimwoodStairsID, GrimwoodPlanks, 0).setStepSound(Block.soundTypeWood).setHardness(2.0F).setResistance(5.0F).setBlockName("GrimwoodStairs").setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
		CorruptedCobblestoneStairs = new ModStairs(NPProperties.CorruptedCobblestoneStairsID, CorruptedCobblestone, 0).setStepSound(Block.soundTypeStone).setHardness(2.0F).setResistance(5.0F).setBlockName("CorruptedCobblestoneStairs").setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
		CorruptedBrickStairs = new ModStairs(NPProperties.CorruptedBrickStairsID, CorruptedBrick, 0).setStepSound(Block.soundTypeStone).setHardness(2.0F).setResistance(5.0F).setBlockName("CorruptedBrickStairs").setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
		NetherrackBrickStairs = new ModStairs(NPProperties.NetherrackBrickStairsID, NetherrackBrick, 0).setStepSound(Block.soundTypeStone).setHardness(2.0F).setResistance(5.0F).setBlockName("NetherrackBrickStairs").setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
		
		ModWoodDoubleSlab = new ModWoodSlab(NPProperties.ModWoodDoubleSlabID, true).setStepSound(Block.soundTypeWood).setHardness(1.5F).setResistance(5.0F).setBlockName("ModWoodSlab");
		ModWoodSlab = new ModWoodSlab(NPProperties.ModWoodSlabID, false).setStepSound(Block.soundTypeWood).setHardness(1.5F).setResistance(5.0F).setBlockName("ModWoodSlab");
		ModStoneDoubleSlab = new ModStoneSlab(NPProperties.ModStoneDoubleSlabID, true).setStepSound(Block.soundTypeStone).setHardness(1.5F).setResistance(5.0F).setBlockName("ModStoneSlab");
		ModStoneSlab = new ModStoneSlab(NPProperties.ModStoneSlabID, false).setStepSound(Block.soundTypeStone).setHardness(1.5F).setResistance(5.0F).setBlockName("ModStoneSlab");
		
		ModFence = new ModFence(626, "nether_plus:GrimwoodPlanks", Material.wood).setStepSound(Block.soundTypeWood).setHardness(2.0F).setResistance(5.0F).setBlockName("ModFence");
		CorruptedCobblestoneWall = new CorruptedCobblestoneWall(627, CorruptedCobblestone).setBlockName("CorruptedCobblestoneWall").setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
		CorruptedBrickWall = new CorruptedBrickWall(628, CorruptedBrick).setBlockName("CorruptedBrickWall").setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
		NetherrackBrickWall = new NetherrackBrickWall(629, NetherrackBrick).setBlockName("NetherrackBrickWall").setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
		
		SoulGlassPane = new SoulGlassPane(633, "nether_plus:SoulGlasspane", "nether_plus:SoulGlasspane_top", Material.glass, false).setStepSound(Block.soundTypeGlass).setHardness(0.5F).setResistance(5.0F).setBlockName("SoulGlassPane").setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
		BlockGrimwoodDoor = new BlockGrimwoodDoor(NPProperties.BlockGrimwoodDoorID, Material.wood).setHardness(3.0F).setStepSound(Block.soundTypeWood).setBlockName("BlockGrimwoodDoor");
		
		Nether_Farm = new Nether_Farm(NPProperties.Nether_FarmID).setStepSound(Block.soundTypeSand).setHardness(0.5F).setBlockName("Nether_Farm");
		Crops = new Crops(NPProperties.CropsID).setBlockName("Crops");
		ChiliC = new ChiliC(NPProperties.ChiliCID, ChiliB).setBlockName("ChiliC");
		ChiliB = new ChiliB(NPProperties.ChiliBID).setStepSound(Block.soundTypeWood).setHardness(2.0F).setResistance(5.0F).setBlockName("ChiliB");
		RiceC = new RiceC(NPProperties.RiceCID).setBlockName("RiceC");
		
		Ladder = new Ladder(NPProperties.LadderID).setStepSound(Block.soundTypeLadder).setHardness(0.4F).setResistance(5.0F).setBlockName("Ladder");
		NetherRail = new NetherRail(NPProperties.NetherRailID).setStepSound(Block.soundTypeMetal).setHardness(0.7F).setResistance(5.0F).setBlockName("NetherRail").setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
		NetherDetectorRail = new NetherDetectorRail(NPProperties.NetherDetectorRailID).setStepSound(Block.soundTypeMetal).setHardness(0.7F).setResistance(5.0F).setBlockName("NetherDetectorRail").setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
		NetherPoweredRail = new NetherPoweredRail(NPProperties.NetherPoweredRailID).setStepSound(Block.soundTypeMetal).setHardness(0.7F).setResistance(5.0F).setBlockName("NetherPoweredRail").setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
		GrimwoodTorch = new GrimwoodTorch(NPProperties.GrimwoodTorchID).setStepSound(Block.soundTypeWood).setLightLevel(0.9375F).setHardness(0.0F).setResistance(5.0F).setBlockName("GrimwoodTorch");
		NetherDonjonSpawner = new NetherDonjonSpawner(NPProperties.NetherDonjonSpawnerID).setStepSound(Block.soundTypeMetal).setHardness(5.0F).setResistance(5.0F).setBlockName("NetherDonjonSpawner");
		
		SteelWool = new SteelWool(NPProperties.SteelWoolID, Material.cloth).setStepSound(Block.soundTypeCloth).setHardness(2.0F).setResistance(5.0F).setBlockName("SteelWool");
		
		//liquides
		QuicksilverMoving = new QuicksilverFluid(NPProperties.QuicksilverMovingID).setUnlocalizedName("QuicksilverMoving");
		QuicksilverStill = new QuicksilverStationary(NPProperties.QuicksilverStillID).setUnlocalizedName("QuicksilverStill");
		SoulplasmMoving = new SoulplasmFluid(NPProperties.SoulplasmMovingID).setLightValue(1.0F).setUnlocalizedName("SoulplasmMoving");
		SoulplasmStill = new SoulplasmStationary(NPProperties.SoulplasmStillID).setLightValue(1.0F).setUnlocalizedName("SoulplasmStill");
		AcidMoving = new AcidFluid(NPProperties.AcidMovingID).setUnlocalizedName("AcidMoving");
		AcidStill = new AcidStationary(NPProperties.AcidStillID).setUnlocalizedName("AcidStill");
		
		try
		{
		GameRegistry.registerBlock(GlowstoneSand, "Glowstone_Sand");
		GameRegistry.registerBlock(SoulGlass, "Soul_Glass");
		GameRegistry.registerBlock(Netherraze, "Netherraze");
		GameRegistry.registerBlock(BewitchedWood, "bewitched_Wood");
		GameRegistry.registerBlock(CorruptionStone, "Corruption_Stone");
		GameRegistry.registerBlock(CorruptedCobblestone, "Corrupted_Cobblestone");
		
		GameRegistry.registerBlock(GrimwoodLog, "Grimwood_Log");
		GameRegistry.registerBlock(GrimwoodLeaves, "Grimwood_Leaves");
		GameRegistry.registerBlock(GrimwoodSapling, "Grimwood_Sapling");
		
		GameRegistry.registerBlock(CorruptedGoldOre, "Corrupted_Gold_Ore");
		GameRegistry.registerBlock(CorruptedCharoiteOre, "Corrupted_Charoite_Ore");
		GameRegistry.registerBlock(CorruptedBlackIronOre, "Corrupted_Black_Iron_Ore");
		GameRegistry.registerBlock(InfernumOre, "InfernumOre");

		GameRegistry.registerBlock(InfernumBlock, "Infernum_Block");
		GameRegistry.registerBlock(BlackIronBlock, "Black_Iron_Block");
		GameRegistry.registerBlock(CharoiteBlock, "Charoite_Block");
		
		GameRegistry.registerBlock(GrimwoodPlanks, "Grimwood_Planks");
		GameRegistry.registerBlock(CorruptedBrick, "Corrupted_Brick");
		GameRegistry.registerBlock(NetherrackBrick, "Netherrack_Brick");
		GameRegistry.registerBlock(GrimwoodWorkbench, "Grimwood_Workbench");
		GameRegistry.registerBlock(GrimwoodChest, "Grimwood_Chest");
		
		GameRegistry.registerBlock(fourOn, "four_On");
		GameRegistry.registerBlock(fourOff, "four_Off");
		
		GameRegistry.registerBlock(GrimwoodStairs, "Grimwood_Stairs");
		GameRegistry.registerBlock(CorruptedCobblestoneStairs, "Corrupted_Cobblestone_Stairs");
		GameRegistry.registerBlock(CorruptedBrickStairs, "Corrupted_Brick_Stairs");
		GameRegistry.registerBlock(NetherrackBrickStairs, "Netherrack_Brick_Stairs");
		
		GameRegistry.registerBlock(ModWoodSlab, ItemBlockModWoodSlab.class, "Mod_Wood_Slab");
		GameRegistry.registerBlock(ModWoodDoubleSlab, ItemBlockModWoodSlab.class, "Mod_Wood_Double_Slab");
		GameRegistry.registerBlock(ModStoneSlab, ItemBlockModStoneSlab.class, "Mod_Stone_Slab");
		GameRegistry.registerBlock(ModStoneDoubleSlab, ItemBlockModStoneSlab.class, "Mod_Stone_Double_Slab");
		
		GameRegistry.registerBlock(ModFence, "Mod_Fence");
		GameRegistry.registerBlock(CorruptedCobblestoneWall, "Corrupted_Cobblestone_Wall");
		GameRegistry.registerBlock(CorruptedBrickWall, "Corrupted_Brick_Wall");
		GameRegistry.registerBlock(NetherrackBrickWall, "Netherrack_Brick_Wall");
		
		GameRegistry.registerBlock(WhiteSkull, "White_Skull");
		GameRegistry.registerBlock(BlackSkull, "Black_Skull");
		
		GameRegistry.registerBlock(SoulGlassPane, "Soul_Glass_Pane");
		GameRegistry.registerBlock(BlockGrimwoodDoor, "BlockGrimwoodDoor");
		GameRegistry.registerBlock(Nether_Farm, "Nether_Farm");
		GameRegistry.registerBlock(Crops, "Crops");
		GameRegistry.registerBlock(ChiliC, "Chili_Crops");
		GameRegistry.registerBlock(ChiliB, "Chili_Block");
		
		GameRegistry.registerBlock(Ladder, "Ladder");
		GameRegistry.registerBlock(NetherRail, "Nether_Rail");
		GameRegistry.registerBlock(NetherDetectorRail, "Nether_Detector_Rail");
		GameRegistry.registerBlock(NetherPoweredRail, "Nether_Powered_Rail");
		GameRegistry.registerBlock(GrimwoodTorch, "Grimwood_Torch");
		GameRegistry.registerBlock(NetherDonjonSpawner, "Nether_Donjon_Spawner");
		
		GameRegistry.registerBlock(QuicksilverMoving, "Quicksilver_Moving");
		GameRegistry.registerBlock(QuicksilverStill, "Quicksilver_Still");
		GameRegistry.registerBlock(SoulplasmMoving, "Soulplasm_Moving");
		GameRegistry.registerBlock(SoulplasmStill, "Soulplasm_Still");
		GameRegistry.registerBlock(AcidMoving, "Acid_Moving");
		GameRegistry.registerBlock(AcidStill, "Acid_Still");
		GameRegistry.registerBlock(SteelWool, "Iron_Wool");

		MinecraftForge.setBlockHarvestLevel(CorruptedGoldOre, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(CorruptedCharoiteOre, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(CorruptedBlackIronOre, "pickaxe", 2);
		}
		catch(Exception ex)
		{
			Nether_plus.NPlog.severe("Erreur lors de l'initialisation des Blocks!");
		}
		Nether_plus.NPlog.info("Initialisation des Blocks terminés!");
	}
}
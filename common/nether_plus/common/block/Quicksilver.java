package nether_plus.common.block;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Quicksilver extends BlockFluidClassic
{
    private IIcon stillIcon, flowingIcon;
	
	protected Quicksilver(Fluid fluid, Material material)
	{
		super(fluid, material);
		this.blockHardness = 100.0F;
		this.setLightOpacity(3);
		this.disableStats();
	}
	
	public void onEntityCollidedWithBlock(World world, int par2, int par3, int par4, Entity entity)
	{
		if (entity instanceof EntityLiving)
		{
			((EntityLiving)entity).addPotionEffect(new PotionEffect(Potion.poison.getId(),25, 500));
			((EntityLiving)entity).addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(),200, 10));
		}
	}
	
	public IIcon getIcon(int side, int metadata)
	{
		return (side == 0 || side == 1) ? flowingIcon : stillIcon;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		this.stillIcon = iconRegister.registerIcon("nether_plus:Quicksilver");
		this.flowingIcon = iconRegister.registerIcon("nether_plus:Quicksilver_flow");
	}
	
	public boolean canDisplace(IBlockAccess world, int x, int y, int z)
	{
		if(world.getBlock(x, y, z).getMaterial() != null)
		{
			return false;
		}
		return super.canDisplace(world, x, y, z);
	}

	public boolean displaceIfPossible(World world, int x, int y, int z)
	{
		if(world.getBlock(x, y, z).getMaterial() != null)
		{
			return false;
		}
		return super.displaceIfPossible(world, x, y, z);
	}
}
/*
import net.minecraft.block.BlockStaticLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class QuicksilverStationary extends BlockStaticLiquid
{
    private IIcon[] field_149806_a;
	public QuicksilverStationary()
	{
		super(Material.water);
		this.blockHardness = 100.0F;
		this.setLightOpacity(3);
		this.disableStats();
	}
       
	public void onEntityCollidedWithBlock(World world, int par2, int par3, int par4, Entity entity)
	{
		if (entity instanceof EntityLiving)
		{
			((EntityLiving)entity).addPotionEffect(new PotionEffect(Potion.poison.getId(),25, 500));
			((EntityLiving)entity).addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(),200, 10));
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		this.field_149806_a = new IIcon[] { iconRegister.registerIcon("nether_plus:Quicksilver"), iconRegister.registerIcon("nether_plus:Quicksilver_flow") };
	}
}*/
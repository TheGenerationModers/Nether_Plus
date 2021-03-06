package nether_plus.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WhiteSkull extends Block
{
	private IIcon IconTop;
	private IIcon IconBottom;
	
	public WhiteSkull()
	{
		super(Material.rock);
		this.setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
	}
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving living, ItemStack stack)
	{
		int direction = MathHelper.floor_double((double)(living.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
		world.setBlockMetadataWithNotify(x, y, z, direction, 2);
	}
	
	 @SideOnly(Side.CLIENT)
	 public IIcon getIcon(int side, int metadata)
	 {
	 return side == 1 ? this.IconTop : (side == 0 ? this.IconBottom : (metadata == 2 && side == 2 ? this.blockIcon : (metadata == 3 && side == 5 ? this.blockIcon : (metadata == 0 && side == 3 ? this.blockIcon : (metadata == 1 && side == 4 ? this.blockIcon : this.IconTop)))));
	 }
	 
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon("Nether_Plus:WhiteSkull_Front");
	 	this.IconBottom = par1IconRegister.registerIcon("Nether_Plus:WhiteSkull_Bottom");
	 	this.IconTop = par1IconRegister.registerIcon("Nether_Plus:WhiteSkull_Top");
	}
}
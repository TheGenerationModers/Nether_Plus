package nether_plus.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class Wight extends EntityCreature
{

	public Wight(World World)
	{
		super(World);
		this.texture = "/mods/nether_plus/textures/Entity/wight.png";
        this.moveSpeed = 0.50F;
		this.isImmuneToFire = true;
	}
	
	public void onLivingUpdate()
	{
		super.onLivingUpdate();
	}
	
	@Override
	public int getMaxHealth()
	{
		return 10;
	}
	
/**	private void setAngry(boolean b)
	{
		byte b0 = this.dataWatcher.getWatchableObjectByte(16);

        if (b)
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 | 2)));
        }
        else
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 & -3)));
        }
	}
	
	public boolean isAngry()
    {
        return (this.dataWatcher.getWatchableObjectByte(16) & 2) != 0;
    }
	
	public void setAttackTarget(EntityLiving par1EntityLiving)
    {
        super.setAttackTarget(par1EntityLiving);

        if (par1EntityLiving instanceof EntityPlayer)
        {
            this.setAngry(true);
        }
    }*/
	
	public int getAttackStrength(Entity entity)
	{
		return 5;
	}
	
	protected String getLivingSound()
	{
		return "mob.zombie.say";
	}
	
	protected String getHurtSound()
    {
        return "mob.zombie.hurt";
    }

    protected String getDeathSound()
    {
        return "mob.zombie.death";
    }
    
    public boolean attackEntityFrom(DamageSource damagesource, int i)
    {
        Entity entity = damagesource.getEntity();
        this.setTarget(entity);
        return super.attackEntityFrom(damagesource, i);
    }

    protected int getDropItemId()
    {
        return Item.bone.itemID;
    }

}

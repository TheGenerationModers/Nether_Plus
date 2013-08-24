package nether_plus.common.entity;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import nether_plus.common.item.NPItemList;

public class FireSlime extends EntityLiving implements IMob
{
	public float field_40139_a;
    public float field_768_a;
    public float field_767_b;
    private int slimeJumpDelay;

    public FireSlime(World world)
    {
        super(world);
        slimeJumpDelay = 0;
        texture = "/mods/nether_plus/textures/Entity/fireslime.png";
        int i = 1 << rand.nextInt(3);
        yOffset = 0.0F;
        slimeJumpDelay = rand.nextInt(20) + 10;
        setFireSlimeSize(i);
        experienceValue = i;
    }

    protected void entityInit()
    {
        super.entityInit();
        dataWatcher.addObject(16, new Byte((byte)1));
    }

    public void setFireSlimeSize(int i)
    {
        dataWatcher.updateObject(16, new Byte((byte)i));
        setSize(0.6F * (float)i, 0.6F * (float)i);
        setPosition(posX, posY, posZ);
        setEntityHealth(getMaxHealth());
    }

    public int getMaxHealth()
    {
        int i = getFireSlimeSize();
        return i * i;
    }

    public int getFireSlimeSize()
    {
        return dataWatcher.getWatchableObjectByte(16);
    }

    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setInteger("Size", getFireSlimeSize() - 1);
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
        setFireSlimeSize(nbttagcompound.getInteger("Size") + 1);
    }

    protected String func_40135_ac()
    {
        return "slime";
    }

    protected String func_40138_aj()
    {
        return "mob.slime";
    }

    public void onUpdate()
    {
        if(!worldObj.isRemote && worldObj.difficultySetting == 0 && getFireSlimeSize() > 0)
        {
            isDead = true;
        }
        field_768_a = field_768_a + (field_40139_a - field_768_a) * 0.5F;
        field_767_b = field_768_a;
        boolean flag = onGround;
        super.onUpdate();
        if(onGround && !flag)
        {
            int i = getFireSlimeSize();
            for(int j = 0; j < i * 8; j++)
            {
                float f = rand.nextFloat() * 3.141593F * 2.0F;
                float f1 = rand.nextFloat() * 0.5F + 0.5F;
                float f2 = MathHelper.sin(f) * (float)i * 0.5F * f1;
                float f3 = MathHelper.cos(f) * (float)i * 0.5F * f1;
                worldObj.spawnParticle(func_40135_ac(), posX + (double)f2, boundingBox.minY, posZ + (double)f3, 0.0D, 0.0D, 0.0D);
            }

            if(func_40134_ak())
            {
                worldObj.playSoundAtEntity(this, func_40138_aj(), getSoundVolume(), ((rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.0F) / 0.8F);
            }
            field_40139_a = -0.5F;
        }
        func_40136_ag();
    }

    protected void updateEntityActionState()
    {
        despawnEntity();
        EntityPlayer entityplayer = worldObj.getClosestVulnerablePlayerToEntity(this, 16D);
        if(entityplayer != null)
        {
            faceEntity(entityplayer, 10F, 20F);
        }
        if(onGround && slimeJumpDelay-- <= 0)
        {
            slimeJumpDelay = func_40131_af();
            if(entityplayer != null)
            {
                slimeJumpDelay /= 3;
            }
            isJumping = true;
            if(func_40133_ao())
            {
                worldObj.playSoundAtEntity(this, func_40138_aj(), getSoundVolume(), ((rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.0F) * 0.8F);
            }
            field_40139_a = 1.0F;
            moveStrafing = 1.0F - rand.nextFloat() * 2.0F;
            moveForward = 1 * getFireSlimeSize();
        } else
        {
            isJumping = false;
            if(onGround)
            {
                moveStrafing = moveForward = 0.0F;
            }
        }
    }

    protected void func_40136_ag()
    {
        field_40139_a = field_40139_a * 0.6F;
    }

    protected int func_40131_af()
    {
        return rand.nextInt(20) + 10;
    }

    protected FireSlime func_40132_ae()
    {
        return new FireSlime(worldObj);
    }

    public void setDead()
    {
        int i = getFireSlimeSize();
        if(!worldObj.isRemote && i > 1 && getHealth() <= 0)
        {
            int j = 2 + rand.nextInt(3);
            for(int k = 0; k < j; k++)
            {
                float f = (((float)(k % 2) - 0.5F) * (float)i) / 4F;
                float f1 = (((float)(k / 2) - 0.5F) * (float)i) / 4F;
                FireSlime fireslime = func_40132_ae();
                fireslime.setFireSlimeSize(i / 2);
                fireslime.setLocationAndAngles(posX + (double)f, posY + 0.5D, posZ + (double)f1, rand.nextFloat() * 360F, 0.0F);
                worldObj.spawnEntityInWorld(fireslime);
            }

        }
        super.setDead();
    }

    public void onCollideWithPlayer(EntityPlayer entityplayer)
    {
        if(func_40137_ah())
        {
            int i = getFireSlimeSize();
            if(canEntityBeSeen(entityplayer) && (double)getDistanceToEntity(entityplayer) < 0.59999999999999998D * (double)i && entityplayer.attackEntityFrom(DamageSource.causeMobDamage(this), func_40130_ai()))
            {
                worldObj.playSoundAtEntity(this, "mob.slimeattack", 1.0F, (rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.0F);
            }
        }
    }

    protected boolean func_40137_ah()
    {
        return getFireSlimeSize() > 1;
    }

    protected int func_40130_ai()
    {
        return getFireSlimeSize();
    }

    protected String getHurtSound()
    {
        return "mob.slime";
    }

    protected String getDeathSound()
    {
        return "mob.slime";
    }

    protected int getDropItemId()
    {
        if(getFireSlimeSize() == 1)
        {
            return NPItemList.Fireslimeball.itemID;
        } else
        {
            return 0;
        }
    }

    public boolean getCanSpawnHere()
    {
        Chunk chunk = worldObj.getChunkFromBlockCoords(MathHelper.floor_double(posX), MathHelper.floor_double(posZ));
        if((getFireSlimeSize() == 1 || worldObj.difficultySetting > 0) && rand.nextInt(10) == 0 && chunk.getRandomWithSeed(0x3ad8025fL).nextInt(10) == 0 && posY < 40D)
        {
            return super.getCanSpawnHere();
        } else
        {
            return false;
        }
    }

    protected float getSoundVolume()
    {
        return 0.4F * (float)getFireSlimeSize();
    }

    public int getVerticalFaceSpeed()
    {
        return 0;
    }

    protected boolean func_40133_ao()
    {
        return getFireSlimeSize() > 1;
    }

    protected boolean func_40134_ak()
    {
        return getFireSlimeSize() > 2;
    }
}
package com.SimpleCampfire;

import java.util.List;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.IMob;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CampfireTileEntity extends TileEntity {

	int timer = 0;
	@Override
	public void readFromNBT(NBTTagCompound tag) {
		// TODO Auto-generated method stub
		super.readFromNBT(tag);
	}
	@Override
	public void writeToNBT(NBTTagCompound tag) {
		// TODO Auto-generated method stub
		super.writeToNBT(tag);
	}
	
	Tessellator tess = new Tessellator();
	
	@Override
	public void updateEntity()
	{
		World world = worldObj;
		boolean isHostileNear = false;
		AxisAlignedBB bounds = AxisAlignedBB.getBoundingBox(this.xCoord-16, this.yCoord, this.zCoord-16, this.xCoord+16, this.yCoord+16, this.zCoord+16);
		List<Entity> entities = world.getEntitiesWithinAABBExcludingEntity(null, bounds);
		
		for(int i = 0; i < entities.size(); i++)
		{
			if(entities.size() > 0)
			{
				if(entities.get(i) instanceof IMob)
				{
					isHostileNear = true;
				}
			}
		}
		
		float xVel=(float) ((Math.random()-0.5f)*0.05f);
		float zVel=(float) ((Math.random()-0.5f)*0.05f);
		if(isHostileNear)
		{
			world.spawnParticle("reddust", this.xCoord+0.5f, this.yCoord+Math.random(), this.zCoord+0.5f, -1.0f, 1.0f, 2.0f);
		}
		else
		{
			world.spawnParticle("flame", this.xCoord+0.5f, this.yCoord+0.1f, this.zCoord+0.5f, xVel, Math.random()*0.1f, zVel);
		}
		if(timer > 4)
		{
			xVel = (float) ((Math.random()-0.5)*0.01f);
			zVel = (float) ((Math.random()-0.5)*0.01f);
			world.spawnParticle("largesmoke", this.xCoord+0.5f, this.yCoord+0.2f, this.zCoord+0.5f, xVel, Math.random()*0.1f, zVel);
			timer = 0;
		}
		else
		{
			timer++;
		}
	}
}
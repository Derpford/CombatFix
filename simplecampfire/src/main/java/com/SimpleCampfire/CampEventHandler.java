package com.SimpleCampfire;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import com.sun.corba.se.spi.orbutil.fsm.Action;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class CampEventHandler {

	@SubscribeEvent
	public void onPlayerInteractEvent(PlayerInteractEvent event)
	{
		World world = event.entityPlayer.worldObj;
		if(event.action == event.action.RIGHT_CLICK_BLOCK)
		{
			ItemStack item =  event.entityPlayer.getHeldItem();
			if(item.getItem() == Items.stick && item.stackSize >= 4 && world.getBlock(event.x, event.y, event.z) == Blocks.cobblestone)
			{
				int xCoord = event.x;
				int yCoord = event.y;
				int zCoord = event.z;
				world.setBlock(xCoord, yCoord, zCoord, Main.campfireBlock);
				item.stackSize -= 4;
			}
		}
	}
}

package com.SimpleCampfire;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Main.MODID, version = Main.VERSION)
public class Main
{
    public static final String MODID = "simplecampfire";
    public static final String VERSION = "0.1";
    @SidedProxy(clientSide="com.SimpleCampfire.client.SimpleCampfireClientProxy", serverSide="com.simplecampfire.SimpleCampfireCommonProxy")
    public static SimpleCampfireCommonProxy proxy;
    public static Block campfireBlock;
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some example code
        System.out.println("DIRT BLOCK >> "+Items.stick.getUnlocalizedName());
        proxy.registerRenderThings();
        GameRegistry.registerTileEntity(CampfireTileEntity.class, "tileEntityCampfire");
        campfireBlock = new CampfireBlock(Material.rock);
        GameRegistry.registerBlock(campfireBlock, "blockCampfire");
        MinecraftForge.EVENT_BUS.register(new CampEventHandler());
        

    }
}

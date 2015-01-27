package com.SimpleCampfire;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class CampfireBlock extends BlockContainer {

	protected CampfireBlock(Material material) {
		super(material);
		// TODO Auto-generated constructor stub
		this.setBlockName(Main.MODID + "_" + "blockCampfire");
		this.setCreativeTab(CreativeTabs.tabDecorations);
		this.setHardness(2.0f);
		this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.25f, 1.0f);
		this.setLightLevel(1.0f);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int beans) {
		// TODO Auto-generated method stub
		return new CampfireTileEntity();
	}
	
	@Override
    public int getRenderType() {
            return -1;
    }
	
    @Override
    public boolean isOpaqueCube() {
            return false;
    }
    
    public boolean renderAsNormalBlock() {
            return false;
    }
    
    public void registerIcons(IIconRegister icon)
    {
    	this.blockIcon = icon.registerIcon(Main.MODID+":textures/blocks/campfire.png");
    }

}

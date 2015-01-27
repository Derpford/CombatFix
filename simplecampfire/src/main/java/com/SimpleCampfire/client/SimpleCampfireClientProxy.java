package com.SimpleCampfire.client;

import com.SimpleCampfire.CampfireRenderer;
import com.SimpleCampfire.CampfireTileEntity;
import com.SimpleCampfire.SimpleCampfireCommonProxy;

import cpw.mods.fml.client.registry.ClientRegistry;

public class SimpleCampfireClientProxy extends SimpleCampfireCommonProxy{

	public void registerRenderThings() {
        ClientRegistry.bindTileEntitySpecialRenderer(CampfireTileEntity.class, new CampfireRenderer());
}

}

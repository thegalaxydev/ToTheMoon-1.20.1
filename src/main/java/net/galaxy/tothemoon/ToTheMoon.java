package net.galaxy.tothemoon;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.galaxy.tothemoon.block.ModBlocks;
import net.galaxy.tothemoon.item.ModCreativeModeTabs;
import net.galaxy.tothemoon.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ToTheMoon implements ModInitializer {
	public static final String MOD_ID = "tothemoon";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final boolean CREATE_LOADED = FabricLoader.getInstance().isModLoaded("create");
	public static final boolean AD_ASTRA_LOADED = FabricLoader.getInstance().isModLoaded("ad_astra");

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModCreativeModeTabs.registerCreativeModeTabs();
	}
}
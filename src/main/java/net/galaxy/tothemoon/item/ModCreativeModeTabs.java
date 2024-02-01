package net.galaxy.tothemoon.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.galaxy.tothemoon.ToTheMoon;
import net.galaxy.tothemoon.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class ModCreativeModeTabs {
    public static CreativeModeTab TO_THE_MOON = null;
    public static void registerCreativeModeTabs()
    {
        TO_THE_MOON = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
                new ResourceLocation(ToTheMoon.MOD_ID, "to_the_moon"),
                FabricItemGroup.builder().title(Component.translatable("tab.to_the_moon"))
                        .icon(() -> new ItemStack(ModBlocks.MOON_BLOCK)).displayItems(((itemDisplayParameters, output) -> {
                            for (Item item : ModItems.ITEMS)
                            {
                                output.accept(item);
                            }

                            for (Block block : ModBlocks.BLOCKS)
                            {
                                output.accept(block);
                            }
                        })).build());

        ToTheMoon.LOGGER.info("Registering creative mode tabs for " + ToTheMoon.MOD_ID + "!");
    }
}

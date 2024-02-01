package net.galaxy.tothemoon.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.galaxy.tothemoon.ToTheMoon;
import net.minecraft.commands.arguments.ResourceKeyArgument;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static List<Item> ITEMS = new ArrayList<Item>();
    private static void registerCompatItems()
    {
        // Create items
        if (ToTheMoon.CREATE_LOADED)
        {
            ITEMS.add(registerItem("basic_mechanism", new Item(new FabricItemSettings())));
        }

        // Ad Astra items
        if (ToTheMoon.AD_ASTRA_LOADED)
        {
        }

        // Create + Ad Astra compat items
        if (ToTheMoon.CREATE_LOADED && ToTheMoon.AD_ASTRA_LOADED)
        {
            ITEMS.add(registerItem("desh_mechanism", new Item(new FabricItemSettings())));
            ITEMS.add(registerItem("ostrum_mechanism", new Item(new FabricItemSettings())));
            ITEMS.add(registerItem("calorite_mechanism", new Item(new FabricItemSettings())));
        }
    }


    private static Item registerItem(String name, Item item)
    {
        return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(ToTheMoon.MOD_ID, name), item);
    }
    public static void registerModItems() {
        ToTheMoon.LOGGER.info("Registering mod items for " + ToTheMoon.MOD_ID + "!");
        registerCompatItems();
    }
}

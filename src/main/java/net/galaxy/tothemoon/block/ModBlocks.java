package net.galaxy.tothemoon.block;

import com.simibubi.create.AllBlocks;
import net.fabricmc.fabric.api.client.keybinding.FabricKeyBinding;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.galaxy.tothemoon.ToTheMoon;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final Block MOON_BLOCK = registerBlock("moon_block",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
    public static List<Block> BLOCKS = new ArrayList<Block>() {
        {
            add(MOON_BLOCK);
        }
    };
    private static void registerCompatBlocks()
    {
        if (ToTheMoon.CREATE_LOADED && ToTheMoon.AD_ASTRA_LOADED)
        {
            BLOCKS.add(registerBlock("desh_casing",
                    new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS))));
        }
    }

    private static Block registerBlock(String name, Block block)
    {
        registerBlockItem(name, block);

        return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(ToTheMoon.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block)
    {
        return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(ToTheMoon.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
    public static void registerModBlocks() {
        registerCompatBlocks();
        ToTheMoon.LOGGER.info("Registering mod blocks for " + ToTheMoon.MOD_ID + "!");
    }
}

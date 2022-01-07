package net.thedarkgamer.endurance.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.thedarkgamer.endurance.EnduranceMod;
import net.thedarkgamer.endurance.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup ITEMS = FabricItemGroupBuilder.build(new Identifier(EnduranceMod.MOD_ID, "items"), () -> new ItemStack(ModItems.BANDAGE));
    public static final ItemGroup BLOCKS = FabricItemGroupBuilder.build(new Identifier(EnduranceMod.MOD_ID, "blocks"), () -> new ItemStack(ModBlocks.REDWOOD_LOG));
    public static final ItemGroup ORES_AND_INGOTS = FabricItemGroupBuilder.build(new Identifier(EnduranceMod.MOD_ID, "blocks"), () -> new ItemStack(ModItems.TIN_INGOT));
}

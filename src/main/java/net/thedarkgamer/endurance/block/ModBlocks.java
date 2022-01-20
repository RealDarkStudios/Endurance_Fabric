package net.thedarkgamer.endurance.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.thedarkgamer.endurance.EnduranceMod;
import net.thedarkgamer.endurance.block.custom.MedicalUpgraderBlock;
import net.thedarkgamer.endurance.block.custom.blocktypes.*;
import net.thedarkgamer.endurance.item.ModItemGroups;
import net.thedarkgamer.endurance.world.features.tree.RedwoodSaplingGenerator;

public class ModBlocks {

    //Redwood
    public static final Block REDWOOD_LOG = registerBlock("redwood_log", new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)), new FabricItemSettings().rarity(Rarity.COMMON).group(ModItemGroups.BLOCKS));
    public static final Block REDWOOD_WOOD = registerBlock("redwood_wood", new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)), new FabricItemSettings().rarity(Rarity.COMMON).group(ModItemGroups.BLOCKS));
    public static final Block REDWOOD_PLANKS = registerBlock("redwood_planks", new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)), new FabricItemSettings().rarity(Rarity.COMMON).group(ModItemGroups.BLOCKS));
    public static final Block STRIPPED_REDWOOD_LOG = registerBlock("stripped_redwood_log", new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)), new FabricItemSettings().rarity(Rarity.COMMON).group(ModItemGroups.BLOCKS));
    public static final Block STRIPPED_REDWOOD_WOOD = registerBlock("stripped_redwood_wood", new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)), new FabricItemSettings().rarity(Rarity.COMMON).group(ModItemGroups.BLOCKS));
    public static final Block REDWOOD_LEAVES = registerBlock("redwood_leaves", new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)), new FabricItemSettings().rarity(Rarity.COMMON).group(ModItemGroups.BLOCKS));
    public static final Block REDWOOD_SAPLING = registerBlock("redwood_sapling", new ModSaplingBlock(new RedwoodSaplingGenerator(),FabricBlockSettings.copy(Blocks.OAK_SAPLING)), new FabricItemSettings().rarity(Rarity.COMMON).group(ModItemGroups.BLOCKS));
    public static final Block REDWOOD_SLAB = registerBlock("redwood_slab", new SlabBlock(FabricBlockSettings.copy(Blocks.OAK_SLAB)), new FabricItemSettings().rarity(Rarity.COMMON).group(ModItemGroups.BLOCKS));
    public static final Block REDWOOD_STAIRS = registerBlock("redwood_stairs", new ModStairsBlock(ModBlocks.REDWOOD_PLANKS.getDefaultState(), FabricBlockSettings.copy(Blocks.OAK_STAIRS)), new FabricItemSettings().rarity(Rarity.COMMON).group(ModItemGroups.BLOCKS));
    public static final Block REDWOOD_FENCE = registerBlock("redwood_fence", new FenceBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE)), new FabricItemSettings().rarity(Rarity.COMMON).group(ModItemGroups.BLOCKS));
    public static final Block REDWOOD_FENCE_GATE = registerBlock("redwood_fence_gate", new FenceGateBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE_GATE)), new FabricItemSettings().rarity(Rarity.COMMON).group(ModItemGroups.BLOCKS));
    public static final Block REDWOOD_PRESSURE_PLATE = registerBlock("redwood_pressure_plate", new ModPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copy(Blocks.OAK_PRESSURE_PLATE)), new FabricItemSettings().rarity(Rarity.COMMON).group(ModItemGroups.BLOCKS));
    public static final Block REDWOOD_BUTTON = registerBlock("redwood_button", new ModWoodenButtonBlock(FabricBlockSettings.copy(Blocks.OAK_BUTTON)), new FabricItemSettings().rarity(Rarity.COMMON).group(ModItemGroups.BLOCKS));
    public static final Block REDWOOD_DOOR = registerBlock("redwood_door", new ModDoorBlock(FabricBlockSettings.copy(Blocks.OAK_DOOR)), new FabricItemSettings().group(ModItemGroups.BLOCKS).rarity(Rarity.COMMON));
    public static final Block REDWOOD_TRAPDOOR = registerBlock("redwood_trapdoor", new ModTrapdoorBlock(FabricBlockSettings.copy(Blocks.OAK_TRAPDOOR)), new FabricItemSettings().group(ModItemGroups.BLOCKS).rarity(Rarity.COMMON));

    //Ores
    public static final Block TIN_ORE = registerBlock("tin_ore", new Block(FabricBlockSettings.copy(Blocks.IRON_ORE)), new FabricItemSettings().rarity(Rarity.COMMON).group(ModItemGroups.ORES_AND_INGOTS));

    //BlockEntities
    public static final Block MEDICAL_UPGRADER = registerBlock("medical_upgrader", new MedicalUpgraderBlock(FabricBlockSettings.copy(Blocks.IRON_BLOCK)), new FabricItemSettings().rarity(Rarity.COMMON).group(ModItemGroups.BLOCKS));

    //Secrets - Only obtainable through commands, also hi to people who read code/comments :)
    public static final Block NETHER_REACTOR_CORE = registerBlock("reactor_core", new Block(FabricBlockSettings.copy(Blocks.IRON_BLOCK)), new FabricItemSettings().rarity(Rarity.EPIC));

    private static Block registerBlock(String name, Block block, FabricItemSettings settings) {
        registerBlockItem(name, block, settings);
        return Registry.register(Registry.BLOCK, new Identifier(EnduranceMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, FabricItemSettings settings) {
        return Registry.register(Registry.ITEM, new Identifier(EnduranceMod.MOD_ID, name), new BlockItem(block, settings));
    }

    public static void registerModBlocks() {
        EnduranceMod.LOGGER.info("Registering Mod Blocks for: " + EnduranceMod.MOD_DISPLAY_NAME);
    }
}

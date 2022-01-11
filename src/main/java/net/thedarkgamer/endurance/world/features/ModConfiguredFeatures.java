package net.thedarkgamer.endurance.world.features;

import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.SpruceFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.thedarkgamer.endurance.EnduranceMod;
import net.thedarkgamer.endurance.block.ModBlocks;
import net.thedarkgamer.endurance.config.ModConfigs;

import java.util.List;

public class ModConfiguredFeatures {

    public static final ConfiguredFeature<TreeFeatureConfig, ?> REDWOOD_TREE = register("redwood", Feature.TREE.configure(new TreeFeatureConfig.Builder(
            BlockStateProvider.of(ModBlocks.REDWOOD_LOG),
            new StraightTrunkPlacer(5, 2, 1),
            BlockStateProvider.of(ModBlocks.REDWOOD_LEAVES),
            new SpruceFoliagePlacer(UniformIntProvider.create(2, 3), UniformIntProvider.create(0, 2), UniformIntProvider.create(1, 2)),
            new TwoLayersFeatureSize(2, 0, 2)).ignoreVines().build()));

    public static final ConfiguredFeature<RandomFeatureConfig, ?> REDWOOD_TREE_RANDOM = register("redwood_feature", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(List.of(new RandomFeatureEntry(
            REDWOOD_TREE.withWouldSurviveFilter(ModBlocks.REDWOOD_SAPLING), 0.1f)),
            REDWOOD_TREE.withWouldSurviveFilter(ModBlocks.REDWOOD_SAPLING))));

    /* SPRUCE TREE CODE (1.17.1)
    new SimpleBlockStateProvider(ConfiguredFeatures.States.SPRUCE_LOG),
    new StraightTrunkPlacer(5, 2, 1),
    new SimpleBlockStateProvider(ConfiguredFeatures.States.SPRUCE_LEAVES),
    new SimpleBlockStateProvider(ConfiguredFeatures.States.SPRUCE_SAPLING),
    new SpruceFoliagePlacer(UniformIntProvider.create(2, 3), UniformIntProvider.create(0, 2), UniformIntProvider.create(1, 2)),
    new TwoLayersFeatureSize(2, 0, 2))).ignoreVines().build()));*/


    public static final List<OreFeatureConfig.Target> OVERWORLD_TIN_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.TIN_ORE.getDefaultState()));

    public static final ConfiguredFeature<?, ?> TIN_ORE = register("tin_ore",
            Feature.ORE.configure(new OreFeatureConfig(OVERWORLD_TIN_ORES, ModConfigs.TIN_VEIN_SIZE)));

    public static <FC extends FeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(EnduranceMod.MOD_ID, name),
                configuredFeature);
    }

    private static RandomPatchFeatureConfig createRandomPatchFeatureConfig(BlockStateProvider block, int tries) {
        return ConfiguredFeatures.createRandomPatchFeatureConfig(tries,
                Feature.SIMPLE_BLOCK.configure(new SimpleBlockFeatureConfig(block)).withInAirFilter());
    }

    public static void registerConfiguredFeatures() {
        EnduranceMod.LOGGER.info("Registering Mod Configured Features for: " + EnduranceMod.MOD_DISPLAY_NAME);
    }
}

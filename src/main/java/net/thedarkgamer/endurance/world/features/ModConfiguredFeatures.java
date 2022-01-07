package net.thedarkgamer.endurance.world.features;

import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.HeightmapDecoratorConfig;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.SpruceFoliagePlacer;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.thedarkgamer.endurance.EnduranceMod;
import net.thedarkgamer.endurance.block.ModBlocks;
import net.thedarkgamer.endurance.config.ModConfigs;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> REDWOOD_TREE_KEY = registerKey("redwood_spawn");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TIN_ORE_KEY = registerKey("tin_ore");

    public static final ConfiguredFeature<TreeFeatureConfig, ?> REDWOOD_TREE = register("redwood", Feature.TREE.configure(new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(ModBlocks.REDWOOD_LOG.getDefaultState()),
            new StraightTrunkPlacer(5, 2, 1),
            new SimpleBlockStateProvider(ModBlocks.REDWOOD_LEAVES.getDefaultState()),
            new SimpleBlockStateProvider(ModBlocks.REDWOOD_SAPLING.getDefaultState()),
            new SpruceFoliagePlacer(UniformIntProvider.create(2, 3), UniformIntProvider.create(0, 2), UniformIntProvider.create(1, 2)),
            new TwoLayersFeatureSize(2, 0, 2)).ignoreVines().build()));

    /* SPRUCE TREE CODE
    new SimpleBlockStateProvider(ConfiguredFeatures.States.SPRUCE_LOG),
    new StraightTrunkPlacer(5, 2, 1),
    new SimpleBlockStateProvider(ConfiguredFeatures.States.SPRUCE_LEAVES),
    new SimpleBlockStateProvider(ConfiguredFeatures.States.SPRUCE_SAPLING),
    new SpruceFoliagePlacer(UniformIntProvider.create(2, 3), UniformIntProvider.create(0, 2), UniformIntProvider.create(1, 2)),
    new TwoLayersFeatureSize(2, 0, 2))).ignoreVines().build()));*/

    public static final ConfiguredFeature<?, ?> TIN_ORE = register(Feature.ORE.configure(

            new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, ModBlocks.TIN_ORE.getDefaultState(), ModConfigs.TIN_VEIN_SIZE))
            .range(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.aboveBottom(ModConfigs.TIN_SPAWN_HEIGHT_MIN), YOffset.fixed(ModConfigs.TIN_SPAWN_HEIGHT_MAX))))
            .spreadHorizontally().repeat(ModConfigs.TIN_VEINS_PER_CHUNK), TIN_ORE_KEY);

    private static ConfiguredFeature<?, ?> REDWOOD_TREE_SPAWN = register(REDWOOD_TREE.decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING))).spreadHorizontally().applyChance(3), REDWOOD_TREE_KEY);

    private static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(EnduranceMod.MOD_ID, name));
    }

    private static ConfiguredFeature<TreeFeatureConfig, ?> register(String name, ConfiguredFeature<TreeFeatureConfig, ?> configuredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(EnduranceMod.MOD_ID, name), configuredFeature);
    }

    private static ConfiguredFeature<?, ?> register(ConfiguredFeature<?, ?> configuredFeature, RegistryKey<ConfiguredFeature<?, ?>> key) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key.getValue(), configuredFeature);
    }

    public static void registerConfiguredFeatures() {
        EnduranceMod.LOGGER.info("Registering Mod Configured Features for: " + EnduranceMod.MOD_DISPLAY_NAME);
    }
}

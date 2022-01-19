package net.thedarkgamer.endurance.world.features.structure;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.thedarkgamer.endurance.EnduranceMod;

public class ModConfiguredStructures {
    /**
     * Static instance of our configured structure so we can reference it and add it to biomes easily.
     */
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_REDWOOD_HOUSE = ModStructures.REDWOOD_HOUSE.configure(DefaultFeatureConfig.DEFAULT);
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_DARKNESS_SHRINE = ModStructures.DARKNESS_SHRINE.configure(DefaultFeatureConfig.DEFAULT);

    /**
     * Registers the configured structure which is what gets added to the biomes.
     * You can use the same identifier for the configured structure as the regular structure
     * because the two fo them are registered to different registries.
     *
     * We can register configured structures at any time before a world is clicked on and made.
     * But the best time to register configured features by code is honestly to do it in onInitialize.
     */
    public static void registerConfiguredStructures() {
        Registry<ConfiguredStructureFeature<?, ?>> registry = BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE;
        Registry.register(registry, new Identifier(EnduranceMod.MOD_ID, "configured_redwood_house"), CONFIGURED_REDWOOD_HOUSE);
        Registry.register(registry, new Identifier(EnduranceMod.MOD_ID, "configured_darkness_shrine"), CONFIGURED_DARKNESS_SHRINE);
    }
}

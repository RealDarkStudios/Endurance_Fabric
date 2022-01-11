package net.thedarkgamer.endurance.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.thedarkgamer.endurance.world.features.ModPlacedFeatures;

public class ModTreeGeneration {

    public static void generateTrees() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FOREST, BiomeKeys.BIRCH_FOREST), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.REDWOOD_TREE_KEY);
    }
}

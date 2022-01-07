package net.thedarkgamer.endurance.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModification;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.BiomeAccessType;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.OceanRuinFeature;
import net.thedarkgamer.endurance.world.features.ModConfiguredFeatures;

public class ModTreeGeneration {

    public static void generateTrees() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.BIRCH_FOREST_HILLS, BiomeKeys.WOODED_HILLS), GenerationStep.Feature.VEGETAL_DECORATION, ModConfiguredFeatures.REDWOOD_TREE_KEY);
    }
}

package net.thedarkgamer.endurance.world.features.tree;

import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.thedarkgamer.endurance.world.features.ModConfiguredFeatures;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class RedwoodSaplingGenerator extends SaplingGenerator {

    @Nullable
    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random random, boolean bees) {
        return ModConfiguredFeatures.REDWOOD_TREE;
    }
}

package net.thedarkgamer.endurance.world.features;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.thedarkgamer.endurance.EnduranceMod;
import net.thedarkgamer.endurance.config.ModConfigs;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> REDWOOD_TREE_KEY = registerKey("redwood_spawn");

    public static final RegistryKey<PlacedFeature> TIN_ORE_KEY = registerKey("tin_ore");

    public static final PlacedFeature REDWOOD_PLACED = registerPlacedFeature("redwood_spawn", ModConfiguredFeatures.REDWOOD_TREE_RANDOM.withPlacement(VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2))));

    public static final PlacedFeature TIN_ORE_PLACED = registerPlacedFeature("tin_ore", ModConfiguredFeatures.TIN_ORE.withPlacement(modifiersWithCount(ModConfigs.TIN_VEINS_PER_CHUNK, HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(ModConfigs.TIN_SPAWN_HEIGHT_MIN), YOffset.fixed(ModConfigs.TIN_SPAWN_HEIGHT_MAX)))));

    public static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    public static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }

    private static PlacedFeature registerPlacedFeature(String name, PlacedFeature placedFeature) {
        return Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(EnduranceMod.MOD_ID, name), placedFeature);
    }

    private static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(EnduranceMod.MOD_ID, name));
    }
}

package net.thedarkgamer.endurance.recipe;


import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.thedarkgamer.endurance.EnduranceMod;

public class ModRecipes {
    public static void register() {
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(EnduranceMod.MOD_ID, MedicalUpgraderRecipe.Serializer.ID), MedicalUpgraderRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(EnduranceMod.MOD_ID, MedicalUpgraderRecipe.Type.ID), MedicalUpgraderRecipe.Type.INSTANCE);
        EnduranceMod.LOGGER.info("Registering Mod Recipes for: " + EnduranceMod.MOD_DISPLAY_NAME);
    }
}

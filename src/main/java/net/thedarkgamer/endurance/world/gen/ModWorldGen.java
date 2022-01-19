package net.thedarkgamer.endurance.world.gen;

import net.thedarkgamer.endurance.world.features.structure.ModConfiguredStructures;
import net.thedarkgamer.endurance.world.features.structure.ModStructures;

public class ModWorldGen {

    public static void generateModWorldGen() {
        ModOreGeneration.generateOres();

        ModTreeGeneration.generateTrees();

        ModStructures.setupAndRegisterStructureFeatures();
        ModConfiguredStructures.registerConfiguredStructures();
    }
}

package net.thedarkgamer.endurance;

import net.fabricmc.api.ModInitializer;
import net.thedarkgamer.endurance.block.ModBlocks;
import net.thedarkgamer.endurance.config.ModConfigs;
import net.thedarkgamer.endurance.item.ModItems;
import net.thedarkgamer.endurance.registries.ModRegistries;
import net.thedarkgamer.endurance.util.ModLootTableModifiers;
import net.thedarkgamer.endurance.world.features.ModConfiguredFeatures;
import net.thedarkgamer.endurance.world.gen.ModWorldGen;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EnduranceMod implements ModInitializer {
	public static final String MOD_ID = "endurance";
	public static final String MOD_DISPLAY_NAME = "Endurance";

	public static final Logger LOGGER = LogManager.getLogger(MOD_DISPLAY_NAME);

	@Override
	public void onInitialize() {
		LOGGER.info("Loading Mod: " + MOD_DISPLAY_NAME);
		ModConfigs.registerConfigs();

		ModConfiguredFeatures.registerConfiguredFeatures();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModRegistries.registerStrippables();

		ModLootTableModifiers.modifyLootTables();

		ModWorldGen.generateModWorldGen();

		LOGGER.info("Registering Mod Loot Table Modifiers for: " + MOD_DISPLAY_NAME);

	}
}

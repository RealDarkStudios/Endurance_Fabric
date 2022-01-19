package net.thedarkgamer.endurance;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.chunk.StructureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.thedarkgamer.endurance.block.ModBlocks;
import net.thedarkgamer.endurance.config.ModConfigs;
import net.thedarkgamer.endurance.item.ModItems;
import net.thedarkgamer.endurance.mixin.StructuresConfigAccessor;
import net.thedarkgamer.endurance.recipe.ModRecipes;
import net.thedarkgamer.endurance.registries.ModRegistries;
import net.thedarkgamer.endurance.util.ModLootTableModifiers;
import net.thedarkgamer.endurance.util.ModRenderHelper;
import net.thedarkgamer.endurance.world.features.ModConfiguredFeatures;
import net.thedarkgamer.endurance.world.features.structure.ModConfiguredStructures;
import net.thedarkgamer.endurance.world.features.structure.ModStructures;
import net.thedarkgamer.endurance.world.gen.ModWorldGen;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.system.CallbackI;

import java.util.HashMap;
import java.util.Map;

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

		ModRecipes.register();

		ModLootTableModifiers.modifyLootTables();

		ModWorldGen.generateModWorldGen();
		//removeStructureSpawningFromSelectedDimension();

		BiomeModifications.create(new Identifier(MOD_ID, "redwood_house_addition")).add(ModificationPhase.ADDITIONS, BiomeSelectors.all(), context ->
							context.getGenerationSettings().addBuiltInStructure(ModConfiguredStructures.CONFIGURED_REDWOOD_HOUSE));

		BiomeModifications.create(new Identifier(MOD_ID, "darkness_shrine_addition")).add(ModificationPhase.ADDITIONS, BiomeSelectors.all(), context ->
				context.getGenerationSettings().addBuiltInStructure(ModConfiguredStructures.CONFIGURED_DARKNESS_SHRINE));
	}
	public static void removeStructureSpawningFromSelectedDimension() {
		Identifier runAfterFabricAPIPhase = new Identifier(MOD_ID, "run_after_fabric_api");
		ServerWorldEvents.LOAD.addPhaseOrdering(Event.DEFAULT_PHASE, runAfterFabricAPIPhase);

		ServerWorldEvents.LOAD.register(runAfterFabricAPIPhase, (MinecraftServer minecraftServer, ServerWorld serverWorld)-> {
					Map<StructureFeature<?>, StructureConfig> tempMap = new HashMap<>(serverWorld.getChunkManager().getChunkGenerator().getStructuresConfig().getStructures());
				//}
			tempMap.keySet().remove(ModStructures.REDWOOD_HOUSE);
			((StructuresConfigAccessor)serverWorld.getChunkManager().getChunkGenerator().getStructuresConfig()).setStructures(tempMap);
		});

		LOGGER.info("Registering Mod Loot Table Modifiers for: " + MOD_DISPLAY_NAME);

	}
}

package net.thedarkgamer.endurance.registries;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.thedarkgamer.endurance.block.ModBlocks;

public class ModRegistries {

    public static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.REDWOOD_LOG, ModBlocks.STRIPPED_REDWOOD_LOG);
        StrippableBlockRegistry.register(ModBlocks.REDWOOD_WOOD, ModBlocks.STRIPPED_REDWOOD_WOOD);
    }
}

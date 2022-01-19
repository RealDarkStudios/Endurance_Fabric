package net.thedarkgamer.endurance.util;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.util.Rarity;
import net.thedarkgamer.endurance.util.rarity.ModRarity;

public class ModItemSettings extends ModItem.Settings {
    @Override
    public ModItemSettings rarity(ModRarity rarity) {
        super.rarity(rarity);
        return this;
    }
}

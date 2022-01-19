package net.thedarkgamer.endurance.util.rarity;

import net.minecraft.util.Formatting;

public enum ModRarity {
    DEFAULT(Formatting.WHITE);

    public Formatting formatting;

    ModRarity(Formatting formatting) {
        this.formatting = formatting;
    }
}

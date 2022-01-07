package net.thedarkgamer.endurance.config;

import com.mojang.datafixers.util.Pair;
import net.thedarkgamer.endurance.EnduranceMod;
import org.lwjgl.system.CallbackI;

public class ModConfigs {
    public static SimpleConfig CONFIG;
    private static ModConfigProvider configs;

    public static boolean CREATIVE_WARNINGS_ON;
    public static boolean SURVIVAL_WARNINGS_ON;
    public static int BANDAGE_HEAL_AMOUNT;
    public static int BANDAGE_COOLDOWN_AMOUNT;
    public static boolean BANDAGE_CREATIVE_WARNINGS;
    public static boolean BANDAGE_SURVIVAL_WARNINGS;
    public static boolean ALLOW_BANDAGE_USE;
    public static boolean BANDAGE_ACCIDENTAL_USE_WARNING;
    public static boolean BANDAGE_ACCIDENTAL_USE_PREVENTION;
    public static int BANDAGE_ACCIDENTAL_USE_PREVENTION_MAX;
    public static boolean BANDAGE_LOG_USE;
    public static boolean ALLOW_MEDKIT_USE;
    public static int MEDKIT_HEAL_AMOUNT;
    public static int MEDKIT_COOLDOWN_AMOUNT;
    public static boolean MEDKIT_CREATIVE_WARNINGS;
    public static boolean MEDKIT_SURVIVAL_WARNINGS;
    public static boolean MEDKIT_ACCIDENTAL_USE_WARNING;
    public static boolean MEDKIT_ACCIDENTAL_USE_PREVENTION;
    public static int MEDKIT_ACCIDENTAL_USE_PREVENTION_MAX;
    public static boolean MEDKIT_LOG_USE;

    public static int TIN_VEIN_SIZE;
    public static int TIN_VEINS_PER_CHUNK;
    public static int TIN_SPAWN_HEIGHT_MAX;
    public static int TIN_SPAWN_HEIGHT_MIN;

    public static void registerConfigs() {
        configs = new ModConfigProvider();
        createConfigs();

        CONFIG = SimpleConfig.of(EnduranceMod.MOD_ID + "config").provider(configs).request();

        assignConfigs();
    }

    private static void createConfigs() {
        configs.addKeyValuePair(new Pair<>("warnings.creative", true), "Turn on ALL warnings for Creative Mode!");
        configs.addKeyValuePair(new Pair<>("warnings.survival", true), "Turn on ALL warnings for Survival Mode!");
        configs.addKeyValuePair(new Pair<>("bandage.allow", true), "Allow Bandage use?");
        configs.addKeyValuePair(new Pair<>("bandage.amounts.heal", 6), "Amount to heal (1 heart is 2 health)");
        configs.addKeyValuePair(new Pair<>("bandage.amounts.cooldown", 100), "Bandage Cooldown (1 Second is 20 Ticks)");
        configs.addKeyValuePair(new Pair<>("bandage.warnings.creative", false), "Have Creative Warnings?");
        configs.addKeyValuePair(new Pair<>("bandage.warnings.survival", true), "Have Survival Warnings?");
        configs.addKeyValuePair(new Pair<>("bandage.use.accidental.warning", true), "Warn player about accidental use?");
        configs.addKeyValuePair(new Pair<>("bandage.use.accidental.prevention", true), "Prevent player from accidentally using Bandage?");
        configs.addKeyValuePair(new Pair<>("bandage.use.accidental.prevention.max", 14), "Prevent player from using Bandage over health (1 heart is 2 health)");
        configs.addKeyValuePair(new Pair<>("bandage.use.log", true), "Log message when Bandage used?");
        configs.addKeyValuePair(new Pair<>("medkit.allow", true), "Allow Medkit use?");
        configs.addKeyValuePair(new Pair<>("medkit.amounts.heal", 12), "Amount to heal (1 heart is 2 health)");
        configs.addKeyValuePair(new Pair<>("medkit.amounts.cooldown", 100), "Medkit Cooldown (1 Second is 20 Ticks)");
        configs.addKeyValuePair(new Pair<>("medkit.warnings.creative", false), "Have Creative Warnings?");
        configs.addKeyValuePair(new Pair<>("medkit.warnings.survival", true), "Have Survival Warnings?");
        configs.addKeyValuePair(new Pair<>("medkit.use.accidental.warning", true), "Warn player about accidental use?");
        configs.addKeyValuePair(new Pair<>("medkit.use.accidental.prevention", true), "Prevent player from accidentally using Medkit?");
        configs.addKeyValuePair(new Pair<>("medkit.use.accidental.prevention.max", 8), "Prevent player from using Medkit over health (1 heart is 2 health)");
        configs.addKeyValuePair(new Pair<>("medkit.use.log", true), "Log message when Medkit used?");
        configs.addKeyValuePair(new Pair<>("tin.amounts.vein.size", 8), "Tin Vein Size (1 - 10)");
        configs.addKeyValuePair(new Pair<>("tin.amounts.vein.chunk", 4), "Tin Veins per Chunk (1 - 5)");
        configs.addKeyValuePair(new Pair<>("tin.amounts.spawn.max", 64), "Max height of Tin Veins");
        configs.addKeyValuePair(new Pair<>("tin.amounts.spawn.min", 2), "Min height of Tin Veins");
    }

    private static void assignConfigs() {
        CREATIVE_WARNINGS_ON = CONFIG.getOrDefault("warnings.creative", true);
        SURVIVAL_WARNINGS_ON = CONFIG.getOrDefault("warnings.survival", true);
        ALLOW_BANDAGE_USE = CONFIG.getOrDefault("bandage.allow", true);
        BANDAGE_HEAL_AMOUNT = CONFIG.getOrDefault("bandage.amounts.heal", 6);
        BANDAGE_COOLDOWN_AMOUNT = CONFIG.getOrDefault("bandage.amounts.cooldown", 100);
        BANDAGE_CREATIVE_WARNINGS = CONFIG.getOrDefault("bandage.warnings.creative", false);
        BANDAGE_SURVIVAL_WARNINGS = CONFIG.getOrDefault("bandage.warnings.survival", true);
        BANDAGE_ACCIDENTAL_USE_WARNING = CONFIG.getOrDefault("bandage.use.accidental.warning", true);
        BANDAGE_ACCIDENTAL_USE_PREVENTION = CONFIG.getOrDefault("bandage.use.accidental.prevention", true);
        BANDAGE_ACCIDENTAL_USE_PREVENTION_MAX = CONFIG.getOrDefault("bandage.use.accidental.prevention.max", 14);
        BANDAGE_LOG_USE = CONFIG.getOrDefault("bandage.use.log", true);
        ALLOW_MEDKIT_USE = CONFIG.getOrDefault("medkit.allow", true);
        MEDKIT_HEAL_AMOUNT = CONFIG.getOrDefault("medkit.amounts.heal", 12);
        MEDKIT_COOLDOWN_AMOUNT = CONFIG.getOrDefault("medkit.amounts.cooldown", 100);
        MEDKIT_CREATIVE_WARNINGS = CONFIG.getOrDefault("medkit.warnings.creative", false);
        MEDKIT_SURVIVAL_WARNINGS = CONFIG.getOrDefault("medkit.warnings.survival", true);
        MEDKIT_ACCIDENTAL_USE_WARNING = CONFIG.getOrDefault("medkit.use.accidental.warning", true);
        MEDKIT_ACCIDENTAL_USE_PREVENTION = CONFIG.getOrDefault("medkit.use.accidental.prevention", true);
        MEDKIT_ACCIDENTAL_USE_PREVENTION_MAX = CONFIG.getOrDefault("medkit.use.accidental.prevention.max", 8);
        MEDKIT_LOG_USE = CONFIG.getOrDefault("medkit.use.log", true);
        TIN_VEIN_SIZE = CONFIG.getOrDefault("tin.amounts.vein.size", 8);
        TIN_VEINS_PER_CHUNK = CONFIG.getOrDefault("tin.amounts.vein.chunk", 4);
        TIN_SPAWN_HEIGHT_MAX = CONFIG.getOrDefault("tin.amounts.spawn.max", 64);
        TIN_SPAWN_HEIGHT_MIN = CONFIG.getOrDefault("tin.amounts.spawn.min", 2);

        if (TIN_VEIN_SIZE > 10) {
            EnduranceMod.LOGGER.warn("Tin Vein Size is ABOVE the max value, setting to 10");
            TIN_VEIN_SIZE = 10;
        } else if (TIN_VEIN_SIZE < 1) {
            EnduranceMod.LOGGER.warn("Tin Vein Size is BELOW the min value, setting to 1");
            TIN_VEIN_SIZE = 1;
        }
        if (TIN_VEINS_PER_CHUNK > 5) {
            EnduranceMod.LOGGER.warn("Tin Veins per Chunk is ABOVE the max value, setting to 5");
            TIN_VEINS_PER_CHUNK = 5;
        } else if (TIN_VEINS_PER_CHUNK < 1) {
            EnduranceMod.LOGGER.warn("Tin Veins per Chunk is BELOW the min value, setting to 1");
            TIN_VEINS_PER_CHUNK = 1;
        }

        EnduranceMod.LOGGER.info("All " + configs.getConfigsList().size() + " configs have been set properly: " +
                "\r\n CREATIVE WARNINGS: " + CREATIVE_WARNINGS_ON +
                "\r\n SURVIVAL WARNINGS: " + SURVIVAL_WARNINGS_ON +
                "\r\n ALLOW BANDAGE: " + ALLOW_BANDAGE_USE +
                "\r\n BANDAGE HEAL AMOUNT: " + BANDAGE_HEAL_AMOUNT +
                "\r\n BANDAGE COOLDOWN AMOUNT: " + BANDAGE_COOLDOWN_AMOUNT +
                "\r\n BANDAGE CREATIVE WARNINGS: " + BANDAGE_CREATIVE_WARNINGS +
                "\r\n BANDAGE SURVIVAL WARNINGS: " + BANDAGE_SURVIVAL_WARNINGS +
                "\r\n BANDAGE ACCIDENTAL USE WARNING: " + BANDAGE_ACCIDENTAL_USE_WARNING +
                "\r\n BANDAGE ACCIDENTAL USE PREVENTION: " + BANDAGE_ACCIDENTAL_USE_PREVENTION +
                "\r\n BANDAGE ACCIDENTAL USE PREVENTION MAX: " + BANDAGE_ACCIDENTAL_USE_PREVENTION_MAX +
                "\r\n BANDAGE LOG USE: " + BANDAGE_LOG_USE +
                "\r\n ALLOW MEDKIT" + ALLOW_MEDKIT_USE +
                "\r\n MEDKIT HEAL AMOUNT: " + MEDKIT_HEAL_AMOUNT +
                "\r\n MEDKIT COOLDOWN AMOUNT: " + MEDKIT_COOLDOWN_AMOUNT +
                "\r\n MEDKIT CREATIVE WARNINGS: " + MEDKIT_CREATIVE_WARNINGS +
                "\r\n MEDKIT SURVIVAL WARNINGS: " + MEDKIT_SURVIVAL_WARNINGS +
                "\r\n MEDKIT ACCIDENTAL USE WARNING: " + MEDKIT_ACCIDENTAL_USE_WARNING +
                "\r\n MEDKIT ACCIDENTAL USE PREVENTION: " + MEDKIT_ACCIDENTAL_USE_PREVENTION +
                "\r\n MEDKIT ACCIDENTAL USE PREVENTION MAX: " + MEDKIT_ACCIDENTAL_USE_PREVENTION_MAX +
                "\r\n MEDKIT LOG USE: " + MEDKIT_LOG_USE +
                "\r\n TIN VEIN SIZE (MIN 1, MAX 10): " + TIN_VEIN_SIZE +
                "\r\n TIN VEINS PER CHUNK (MIN 1, MAX 5): " + TIN_VEINS_PER_CHUNK +
                "\r\n TIN SPAWN HEIGHT MAX: " + TIN_SPAWN_HEIGHT_MAX +
                "\r\n TIN SPAWN HEIGHT MIN: " + TIN_SPAWN_HEIGHT_MIN
                );

    }
}

package net.thedarkgamer.endurance.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.thedarkgamer.endurance.EnduranceMod;
import net.thedarkgamer.endurance.item.custom.AdminFeederItem;
import net.thedarkgamer.endurance.item.custom.BandageItem;
import net.thedarkgamer.endurance.item.custom.MedkitItem;
import net.thedarkgamer.endurance.util.ModItem;
import net.thedarkgamer.endurance.util.ModItemSettings;

public class ModItems {

    //Admin
    public static final Item ADMIN_SWORD = registerItem("admin_sword", new SwordItem(ModToolMaterial.ADMIN, 0, 0.0F, new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final Item ADMIN_FEEDER = registerItem("admin_feeder", new AdminFeederItem(new FabricItemSettings().rarity(Rarity.EPIC)));

    //Healing
    public static final Item BANDAGE = registerItem("bandage", new BandageItem(new FabricItemSettings().group(ModItemGroups.ITEMS).rarity(Rarity.COMMON)));
    public static final Item MEDKIT = registerItem("medkit", new MedkitItem(new FabricItemSettings().group(ModItemGroups.ITEMS).rarity(Rarity.UNCOMMON).maxCount(1)));

    //Tin
    public static final Item RAW_TIN = registerItem("raw_tin", new Item(new FabricItemSettings().group(ModItemGroups.ORES_AND_INGOTS).rarity(Rarity.COMMON)));
    public static final Item TIN_INGOT = registerItem("tin_ingot", new Item(new FabricItemSettings().group(ModItemGroups.ORES_AND_INGOTS).rarity(Rarity.COMMON)));
    public static final Item TIN_NUGGET = registerItem("tin_nugget", new Item(new FabricItemSettings().group(ModItemGroups.ORES_AND_INGOTS).rarity(Rarity.COMMON)));
    public static final Item TIN_HELMET = registerItem("tin_helmet", new ArmorItem(ModArmorMaterial.TIN, EquipmentSlot.HEAD, new FabricItemSettings().group(ModItemGroups.ORES_AND_INGOTS)));
    public static final Item TIN_CHESTPLATE = registerItem("tin_chestplate", new ArmorItem(ModArmorMaterial.TIN, EquipmentSlot.CHEST, new FabricItemSettings().group(ModItemGroups.ORES_AND_INGOTS)));
    public static final Item TIN_LEGGINGS = registerItem("tin_leggings", new ArmorItem(ModArmorMaterial.TIN, EquipmentSlot.LEGS, new FabricItemSettings().group(ModItemGroups.ORES_AND_INGOTS)));
    public static final Item TIN_BOOTS = registerItem("tin_boots", new ArmorItem(ModArmorMaterial.TIN, EquipmentSlot.FEET, new FabricItemSettings().group(ModItemGroups.ORES_AND_INGOTS)));
    
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(EnduranceMod.MOD_ID,  name), item);
    }

    private static ModItem registerModItem(String name, ModItem item) {
        return new ModItem(new ModItemSettings());//ModRegistry.register(ModRegistry.CUSTOM_ITEM, new Identifier(EnduranceMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        EnduranceMod.LOGGER.info("Registering Mod Items for: " + EnduranceMod.MOD_DISPLAY_NAME);
    }
}

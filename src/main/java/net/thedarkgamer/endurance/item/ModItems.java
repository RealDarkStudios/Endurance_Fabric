package net.thedarkgamer.endurance.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.thedarkgamer.endurance.EnduranceMod;
import net.thedarkgamer.endurance.item.custom.BandageItem;
import net.thedarkgamer.endurance.item.custom.MedkitItem;

public class ModItems {

    //Admin
    public static final Item ADMIN_SWORD = registerItem("admin_sword", new SwordItem(ModToolMaterial.ADMIN, 0, 0, new FabricItemSettings().rarity(Rarity.EPIC)));

    //Healing
    public static final Item BANDAGE = registerItem("bandage", new BandageItem(new FabricItemSettings().group(ModItemGroups.ITEMS).rarity(Rarity.COMMON)));
    public static final Item MEDKIT = registerItem("medkit", new MedkitItem(new FabricItemSettings().group(ModItemGroups.ITEMS).rarity(Rarity.UNCOMMON).maxCount(1)));

    //Tin
    public static final Item RAW_TIN = registerItem("raw_tin", new Item(new FabricItemSettings().group(ModItemGroups.ORES_AND_INGOTS).rarity(Rarity.COMMON)));
    public static final Item TIN_INGOT = registerItem("tin_ingot", new Item(new FabricItemSettings().group(ModItemGroups.ORES_AND_INGOTS).rarity(Rarity.COMMON)));
    public static final Item TIN_NUGGET = registerItem("tin_nugget", new Item(new FabricItemSettings().group(ModItemGroups.ORES_AND_INGOTS).rarity(Rarity.COMMON)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(EnduranceMod.MOD_ID,  name), item);
    }

    public static void registerModItems() {
        EnduranceMod.LOGGER.info("Registering Mod Items for: " + EnduranceMod.MOD_DISPLAY_NAME);
    }

}

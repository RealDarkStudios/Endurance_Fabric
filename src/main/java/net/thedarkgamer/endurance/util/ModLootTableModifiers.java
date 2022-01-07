package net.thedarkgamer.endurance.util;

import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.item.Items;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.condition.LootConditionManager;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ConditionalLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.NbtPredicate;
import net.minecraft.predicate.NumberRange;
import net.minecraft.predicate.item.EnchantmentPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.util.Identifier;
import net.thedarkgamer.endurance.EnduranceMod;

import java.util.Set;

public class ModLootTableModifiers {
    private static final Identifier OAK_LOG_ID = new Identifier("minecraft", "blocks/oak_log");
    private static final Identifier BIRCH_LOG_ID = new Identifier("minecraft", "blocks/birch_log");
    private static final Identifier JUNGLE_LOG_ID = new Identifier("minecraft", "blocks/jungle_log");
    private static final Identifier ACACIA_LOG_ID = new Identifier("minecraft", "blocks/acacia_log");
    private static final Identifier DARK_OAK_LOG_ID = new Identifier("minecraft", "blocks/dark_oak_log");
    private static final Identifier SPRUCE_LOG_ID = new Identifier("minecraft", "blocks/spruce_log");


    public static void modifyLootTables() {
        LootTableLoadingCallback.EVENT.register((resourceManager, manager, id, supplier, setter) -> {
            if (OAK_LOG_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder().rolls(ConstantLootNumberProvider.create(1)).withCondition(new MatchToolLootCondition(new ItemPredicate(ModTags.Items.NON_LOG_MINEABLE, null, null, null, null, null, null, null))).with(ItemEntry.builder(Items.OAK_LOG)).withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());
                EnduranceMod.LOGGER.info("The \"NullPointerException: Cannot invoke net.minecraft.predicate.NumberRange$IntRange.test(int)\" error is NORMAL, this is what causes no logs to drog from data/endurance/tags/items/non_log_mineable.json");
                supplier.withPool(poolBuilder.build());
            }
            if (BIRCH_LOG_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder().rolls(ConstantLootNumberProvider.create(1)).withCondition(new MatchToolLootCondition(new ItemPredicate(ModTags.Items.NON_LOG_MINEABLE, null, null, null, null, null, null, null))).with(ItemEntry.builder(Items.BIRCH_LOG)).withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());
                supplier.withPool(poolBuilder.build());
            }
            if (JUNGLE_LOG_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder().rolls(ConstantLootNumberProvider.create(1)).withCondition(new MatchToolLootCondition(new ItemPredicate(ModTags.Items.NON_LOG_MINEABLE, null, null, null, null, null, null, null))).with(ItemEntry.builder(Items.JUNGLE_LOG)).withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());
                supplier.withPool(poolBuilder.build());
            }
            if (ACACIA_LOG_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder().rolls(ConstantLootNumberProvider.create(1)).withCondition(new MatchToolLootCondition(new ItemPredicate(ModTags.Items.NON_LOG_MINEABLE, null, null, null, null, null, null, null))).with(ItemEntry.builder(Items.ACACIA_LOG)).withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());
                supplier.withPool(poolBuilder.build());
            }
            if (DARK_OAK_LOG_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder().rolls(ConstantLootNumberProvider.create(1)).withCondition(new MatchToolLootCondition(new ItemPredicate(ModTags.Items.NON_LOG_MINEABLE, null, null, null, null, null, null, null))).with(ItemEntry.builder(Items.DARK_OAK_LOG)).withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());
                supplier.withPool(poolBuilder.build());
            }
            if (SPRUCE_LOG_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder().rolls(ConstantLootNumberProvider.create(1)).withCondition(new MatchToolLootCondition(new ItemPredicate(ModTags.Items.NON_LOG_MINEABLE, null, null, null, null, null, null, null))).with(ItemEntry.builder(Items.SPRUCE_LOG)).withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());
                supplier.withPool(poolBuilder.build());
            }
        });
    }

}

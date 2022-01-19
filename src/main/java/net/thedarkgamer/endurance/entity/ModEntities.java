package net.thedarkgamer.endurance.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.thedarkgamer.endurance.EnduranceMod;
import net.thedarkgamer.endurance.entity.entities.test_entity.TestEntity;

public class ModEntities {
    public static final EntityType<TestEntity> TEST = Registry.register(Registry.ENTITY_TYPE, new Identifier(EnduranceMod.MOD_ID, "test"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, TestEntity::new).dimensions(EntityDimensions.fixed(1f, 1f)).build());

    public static void registerEntities() {
        EnduranceMod.LOGGER.info("Registering Mod Entities for mod: " + EnduranceMod.MOD_ID);
        FabricDefaultAttributeRegistry.register(TEST, TestEntity.createMobAttributes());
    }
}

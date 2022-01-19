package net.thedarkgamer.endurance.entity.entities.test_entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;

public class TestEntity extends PathAwareEntity {
    public TestEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }
}

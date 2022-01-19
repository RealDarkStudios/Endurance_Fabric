package net.thedarkgamer.endurance.entity.entities.test_entity;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.thedarkgamer.endurance.EnduranceMod;

public class TestEntityRenderer extends MobEntityRenderer<TestEntity, TestEntityModel> {
    public TestEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new TestEntityModel(context.getPart(TestEntityModel.MODEL_CUBE_LAYER)), 0.5F);
    }

    @Override
    public Identifier getTexture(TestEntity entity) {
        return new Identifier(EnduranceMod.MOD_ID, "textures/entity/test/test_entity.png");
    }
}

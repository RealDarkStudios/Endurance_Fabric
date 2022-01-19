package net.thedarkgamer.endurance;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.thedarkgamer.endurance.entity.ModEntities;
import net.thedarkgamer.endurance.entity.entities.test_entity.TestEntity;
import net.thedarkgamer.endurance.entity.entities.test_entity.TestEntityModel;
import net.thedarkgamer.endurance.entity.entities.test_entity.TestEntityRenderer;
import net.thedarkgamer.endurance.screen.MedicalUpgraderScreen;
import net.thedarkgamer.endurance.screen.ModScreenHandlers;
import net.thedarkgamer.endurance.util.ModRenderHelper;

@Environment(EnvType.CLIENT)
public class EnduranceClientMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModRenderHelper.setRenderLayers();
        ScreenRegistry.register(ModScreenHandlers.MEDICAL_UPGRADER_SCREEN_HANDLER, MedicalUpgraderScreen::new);

        EntityRendererRegistry.register(ModEntities.TEST, (context) -> {
            return new TestEntityRenderer(context);
        });
        EntityModelLayerRegistry.registerModelLayer(TestEntityModel.MODEL_CUBE_LAYER, TestEntityModel::getTexturedModelData);
    }
}

package net.thedarkgamer.endurance;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.thedarkgamer.endurance.screen.MedicalUpgraderScreen;
import net.thedarkgamer.endurance.screen.ModScreenHandlers;
import net.thedarkgamer.endurance.util.ModRenderHelper;

@Environment(EnvType.CLIENT)
public class EnduranceClientMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModRenderHelper.setRenderLayers();
        ScreenRegistry.register(ModScreenHandlers.MEDICAL_UPGRADER_SCREEN_HANDLER, MedicalUpgraderScreen::new);
    }
}

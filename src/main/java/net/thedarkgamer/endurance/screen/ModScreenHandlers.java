package net.thedarkgamer.endurance.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.thedarkgamer.endurance.EnduranceMod;

public class ModScreenHandlers {
    public static ScreenHandlerType<MedicalUpgraderScreenHandler> MEDICAL_UPGRADER_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(EnduranceMod.MOD_ID, "medical_upgrader"), MedicalUpgraderScreenHandler::new);
}

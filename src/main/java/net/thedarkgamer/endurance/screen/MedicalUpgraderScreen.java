package net.thedarkgamer.endurance.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.thedarkgamer.endurance.EnduranceMod;

public class MedicalUpgraderScreen extends HandledScreen<MedicalUpgraderScreenHandler> {
    private static final Identifier TEXTURE = new Identifier(EnduranceMod.MOD_ID, "textures/gui/medical_upgrader_gui.png");
    private static final int texWidth = 176;
    private static final int texHeight = 166;

    public MedicalUpgraderScreen(MedicalUpgraderScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    protected void init() {
        super.init();
        //Center the title
        titleX = (texWidth - textRenderer.getWidth(title)) / 2;
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - texWidth) / 2;
        int y = (height - texHeight) / 2;
        drawTexture(matrices, x, y, 0, 0, texWidth, texHeight, 176, 166);
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices, mouseX, mouseY);
    }
}

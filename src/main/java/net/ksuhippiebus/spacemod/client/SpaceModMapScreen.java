package net.ksuhippiebus.spacemod.client;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class SpaceModMapScreen extends Screen {

    public SpaceModMapScreen() {
        super(Component.literal("My GUI"));
    }

    private void fillCircle(
        GuiGraphics graphics,
        int centerX,
        int centerY,
        int radius,
        int color
    )
    {

        for (int y = -radius; y <= radius; y++) {
            int width = (int) Math.sqrt(radius * radius - y * y);

            graphics.fill(
                    centerX - width,
                    centerY + y,
                    centerX + width + 1,
                    centerY + y + 1,
                    color
            );
        }
    }

    private void fillEllipse(
            GuiGraphics graphics,
            int centerX,
            int centerY,
            int radiusX,
            int radiusY,
            int color
    ) {

        for (int y = -radiusY; y <= radiusY; y++) {

            double normalizedY = (double)(y * y) / (radiusY * radiusY);

            int width = (int)(
                    radiusX * Math.sqrt(1.0 - normalizedY)
            );

            graphics.fill(
                    centerX - width,
                    centerY + y,
                    centerX + width + 1,
                    centerY + y + 1,
                    color
            );
        }
    }

    @Override
    protected void init() {
        super.init();

        if (this.minecraft != null) {
            this.minecraft.levelRenderer.needsUpdate();
        }
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        //this.renderBackground(graphics);

        super.render(graphics, mouseX, mouseY, partialTick);

        graphics.drawString(
                this.font,
                "Hello from my GUI",
                this.width / 2 - 50,
                this.height / 2,
                0xFFFFFF
        );

        fillCircle(graphics, 100, 100, 40, 0xFFFF0000);

        fillEllipse(graphics, 250, 100, 80, 40, 0xFF00FF00);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
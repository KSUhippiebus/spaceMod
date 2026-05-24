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
    ) {
        fillCircle(graphics, centerX, centerY, radius, color, -1);
    }

    private void fillCircle(
            GuiGraphics graphics,
            int centerX,
            int centerY,
            int radius,
            int color,
            int lineWidth // <= 0 = filled
    ) {

        // Filled circle
        if (lineWidth <= 0 || lineWidth >= radius) {
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
            return;
        }

        int innerRadius = radius - lineWidth;

        for (int y = -radius; y <= radius; y++) {
            int outerWidth = (int) Math.sqrt(radius * radius - y * y);

            int innerWidth = 0;
            if (Math.abs(y) <= innerRadius) {
                innerWidth = (int) Math.sqrt(innerRadius * innerRadius - y * y);
            }

            // Left outline segment
            graphics.fill(
                    centerX - outerWidth,
                    centerY + y,
                    centerX - innerWidth + 1,
                    centerY + y + 1,
                    color
            );

            // Right outline segment
            graphics.fill(
                    centerX + innerWidth,
                    centerY + y,
                    centerX + outerWidth + 1,
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
        fillEllipse(graphics, centerX, centerY, radiusX, radiusY, color, -1);
    }

    private void fillEllipse(
            GuiGraphics graphics,
            int centerX,
            int centerY,
            int radiusX,
            int radiusY,
            int color,
            int lineWidth // <= 0 = filled
    ) {

        // Filled ellipse
        if (lineWidth <= 0 || lineWidth >= Math.min(radiusX, radiusY)) {

            for (int y = -radiusY; y <= radiusY; y++) {

                double normalizedY = (double) (y * y) / (radiusY * radiusY);

                int width = (int) (
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

            return;
        }

        int innerRadiusX = radiusX - lineWidth;
        int innerRadiusY = radiusY - lineWidth;

        for (int y = -radiusY; y <= radiusY; y++) {

            double outerNormalizedY =
                    (double) (y * y) / (radiusY * radiusY);

            int outerWidth = (int) (
                    radiusX * Math.sqrt(1.0 - outerNormalizedY)
            );

            int innerWidth = 0;

            if (Math.abs(y) <= innerRadiusY) {

                double innerNormalizedY =
                        (double) (y * y) / (innerRadiusY * innerRadiusY);

                innerWidth = (int) (
                        innerRadiusX * Math.sqrt(1.0 - innerNormalizedY)
                );
            }

            // Left side
            graphics.fill(
                    centerX - outerWidth,
                    centerY + y,
                    centerX - innerWidth + 1,
                    centerY + y + 1,
                    color
            );

            // Right side
            graphics.fill(
                    centerX + innerWidth,
                    centerY + y,
                    centerX + outerWidth + 1,
                    centerY + y + 1,
                    color
            );
        }
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        //this.renderBackground(graphics);

        super.render(graphics, mouseX, mouseY, partialTick);

        graphics.drawString(
                this.font,
                "timer is: "+ClientTimerData.ticks,
                this.width / 2 - 50,
                this.height / 2,
                0xFFFFFF
        );

        //fillCircle(graphics, 100, 100, 40, 0xFFFF0000, 5);

        //fillEllipse(graphics, 250, 100, 80, 40, 0xFF00FF00);

        int radius = 100;

        double speed = (Math.PI / 10) / 10;
        double orbitDir = ClientTimerData.ticks * speed;

        fillEllipse(graphics, this.width/2, this.height/2, radius, radius, 0xAAFFFFFF, 2);

        fillCircle(graphics, (int)(this.width/2 + radius * Math.cos(orbitDir)), (int)(this.height/2 + radius * Math.sin(orbitDir)), 10, 0xFF00FF00);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
package net.ksuhippiebus.spacemod.utils;

import net.minecraft.client.gui.GuiGraphics;

public final class Drawing {

    public static int screenSizeX = 0;
    public static int screenSizeY = 0;

    public static void fillCircle(
            GuiGraphics graphics,
            int centerX,
            int centerY,
            int radius,
            int color
    ) {
        fillCircle(graphics, centerX, centerY, radius, color, -1);
    }

    public static void fillCircle(
            GuiGraphics graphics,
            int centerX,
            int centerY,
            int radius,
            int color,
            int lineWidth
    ) {

        if (radius <= 0) {
            return;
        }

        // Completely off-screen
        if (centerX + radius < 0 ||
                centerX - radius >= screenSizeX ||
                centerY + radius < 0 ||
                centerY - radius >= screenSizeY) {
            return;
        }

        int minY = Math.max(-radius, -centerY);
        int maxY = Math.min(radius, screenSizeY - centerY - 1);

        // Filled circle
        if (lineWidth <= 0 || lineWidth >= radius) {

            for (int y = minY; y <= maxY; y++) {

                int width = (int)Math.sqrt(radius * radius - y * y);

                int startX = Math.max(0, centerX - width);
                int endX = Math.min(screenSizeX, centerX + width + 1);

                if (startX < endX) {
                    graphics.fill(
                            startX,
                            centerY + y,
                            endX,
                            centerY + y + 1,
                            color
                    );
                }
            }

            return;
        }

        int innerRadius = radius - lineWidth;

        for (int y = minY; y <= maxY; y++) {

            int outerWidth =
                    (int)Math.sqrt(radius * radius - y * y);

            int innerWidth = 0;

            if (Math.abs(y) <= innerRadius) {
                innerWidth =
                        (int)Math.sqrt(innerRadius * innerRadius - y * y);
            }

            int drawY = centerY + y;

            // Left outline segment
            int leftStart = Math.max(0, centerX - outerWidth);
            int leftEnd = Math.min(screenSizeX, centerX - innerWidth + 1);

            if (leftStart < leftEnd) {
                graphics.fill(
                        leftStart,
                        drawY,
                        leftEnd,
                        drawY + 1,
                        color
                );
            }

            // Right outline segment
            int rightStart = Math.max(0, centerX + innerWidth);
            int rightEnd = Math.min(screenSizeX, centerX + outerWidth + 1);

            if (rightStart < rightEnd) {
                graphics.fill(
                        rightStart,
                        drawY,
                        rightEnd,
                        drawY + 1,
                        color
                );
            }
        }
    }
}
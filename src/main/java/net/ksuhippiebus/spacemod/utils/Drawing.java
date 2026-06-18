package net.ksuhippiebus.spacemod.utils;

import net.minecraft.client.gui.GuiGraphics;

public final class Drawing {
    public static void fillCircle(
            GuiGraphics graphics,
            int centerX,
            int centerY,
            int diameter,
            int color
    ) {
        fillCircle(graphics, centerX, centerY, diameter, color, -1);
    }

    public static void fillCircle(
            GuiGraphics graphics,
            int centerX,
            int centerY,
            int diameter,
            int color,
            int lineWidth // <= 0 = filled
    ) {

        // Filled circle
        if (lineWidth <= 0 || lineWidth >= diameter) {
            for (int y = -diameter; y <= diameter; y++) {
                int width = (int) Math.sqrt(diameter * diameter - y * y);

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

        int innerRadius = diameter - lineWidth;

        for (int y = -diameter; y <= diameter; y++) {
            int outerWidth = (int) Math.sqrt(diameter * diameter - y * y);

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

    public static void fillEllipse(
            GuiGraphics graphics,
            int centerX,
            int centerY,
            int diameterX,
            int diameterY,
            int color
    ) {
        fillEllipse(graphics, centerX, centerY, diameterX, diameterY, color, -1);
    }

    public static void fillEllipse(
            GuiGraphics graphics,
            int centerX,
            int centerY,
            int diameterX,
            int diameterY,
            int color,
            int lineWidth // <= 0 = filled
    ) {

        // Filled ellipse
        if (lineWidth <= 0 || lineWidth >= Math.min(diameterX, diameterY)) {

            for (int y = -diameterY; y <= diameterY; y++) {

                double normalizedY = (double) (y * y) / (diameterY * diameterY);

                int width = (int) (
                        diameterX * Math.sqrt(1.0 - normalizedY)
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

        int innerRadiusX = diameterX - lineWidth;
        int innerRadiusY = diameterY - lineWidth;

        for (int y = -diameterY; y <= diameterY; y++) {

            double outerNormalizedY =
                    (double) (y * y) / (diameterY * diameterY);

            int outerWidth = (int) (
                    diameterX * Math.sqrt(1.0 - outerNormalizedY)
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
}

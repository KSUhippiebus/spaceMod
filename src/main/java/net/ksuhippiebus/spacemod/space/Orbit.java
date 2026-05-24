package net.ksuhippiebus.spacemod.space;

import net.minecraft.client.gui.GuiGraphics;

public class Orbit {

    public long Period = 30; // in ticks
    public long Offset = 0; // in ticks
    public long XPos = 100;
    public long XNeg = 100;
    public long YPos = 100;
    public long YNeg = 100;

    public Orbit() {}

    public Orbit(long period, long offset,
                 long xPos, long xNeg,
                 long yPos, long yNeg) {

        this.Period = period;
        this.Offset = offset;
        this.XPos = xPos;
        this.XNeg = xNeg;
        this.YPos = yPos;
        this.YNeg = yNeg;
    }

    public double getRadius(double angle) {
        // normalize angle to [0, 2π)
        angle = angle % (2.0 * Math.PI);
        if (angle < 0) angle += 2.0 * Math.PI;

        double segment = Math.PI / 2.0;

        double t;
        double a, b;

        if (angle < segment) {
            // 0 → 90
            t = angle / segment;
            a = XPos; b = YPos;

        } else if (angle < 2 * segment) {
            // 90 → 180
            t = (angle - segment) / segment;
            a = YPos; b = XNeg;

        } else if (angle < 3 * segment) {
            // 180 → 270
            t = (angle - 2 * segment) / segment;
            a = XNeg; b = YNeg;

        } else {
            // 270 → 360
            t = (angle - 3 * segment) / segment;
            a = YNeg; b = XPos;
        }

        return a + (b - a) * t;
    }

    public Vec2 calcPos(
        long frame
    ) {
        double angle = (frame + Offset) * (2 * Math.PI) / Period;

        double radius = getRadius(angle);

        double x = radius * Math.cos(angle);
        double y = radius * Math.sin(angle);

        return new Vec2(x,y);
    }

    public void draw(GuiGraphics graphics) {

    }
}

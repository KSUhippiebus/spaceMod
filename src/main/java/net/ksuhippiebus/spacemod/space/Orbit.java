package net.ksuhippiebus.spacemod.space;

import net.ksuhippiebus.spacemod.utils.Vec2;
import net.minecraft.client.gui.GuiGraphics;

public class Orbit {

    public long Period = 20; // in ticks
    public long TimeOffset = 0; // in ticks
    public double Radius = 0;
    public Planet Parent = null;
    public Vec2 Offset = new Vec2(0,0);

    public Orbit() {}

    public Orbit(long period, long timeOffset, double radius) {
        this.Period = period;
        this.TimeOffset = timeOffset;
        this.Radius = radius;
    }

    public Orbit(long period, long timeOffset, double radius, Vec2 offset) {
        this.Period = period;
        this.TimeOffset = timeOffset;
        this.Radius = radius;
        this.Offset = offset;
    }

    public Orbit(long period, long timeOffset, double radius, Planet parent) {
        this.Period = period;
        this.TimeOffset = timeOffset;
        this.Radius = radius;
        this.Parent = parent;
    }

    public Orbit(long period, long timeOffset, double radius, Planet parent, Vec2 offset) {
        this.Period = period;
        this.TimeOffset = timeOffset;
        this.Radius = radius;
        this.Parent = parent;
        this.Offset = offset;
    }

    public Vec2 calcPos(
        long frame
    ) {
        if (Parent == null) {
            return Offset;
        }

        double angle = (frame + this.TimeOffset) * (2 * Math.PI) / this.Period;

        double radius = this.Radius;

        double x = radius * Math.cos(angle);
        double y = radius * Math.sin(angle);

        return Vec2.add(new Vec2(x,y), Offset);
    }
}

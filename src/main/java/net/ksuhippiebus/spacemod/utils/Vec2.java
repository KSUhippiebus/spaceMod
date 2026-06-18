package net.ksuhippiebus.spacemod.utils;

public class Vec2 {
    public double x;
    public double y;

    public Vec2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Vec2 add(Vec2 a, Vec2 b) {
        return new Vec2(a.x + b.x, a.y + b.y);
    }

    public static Vec2 subtract(Vec2 a, Vec2 b) {
        return new Vec2(a.x - b.x, a.y - b.y);
    }

    public static Vec2 multiply(Vec2 v, double scalar) {
        return new Vec2(v.x * scalar, v.y * scalar);
    }

    public static Vec2 divide(Vec2 v, double scalar) {
        return new Vec2(v.x / scalar, v.y / scalar);
    }
}

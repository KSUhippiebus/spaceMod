package net.ksuhippiebus.spacemod.space;

import net.ksuhippiebus.spacemod.utils.Vec2;

import java.util.ArrayList;
import java.util.List;

public class Planet {

    private static int nextId = 0;

    public String name = "";
    public final int id;
    public long mass = 0;
    public int color = 0xFF000000;
    public PlanetType type;

    public List<Planet> moons = new ArrayList<>();

    public Orbit orbit = new Orbit();
    public Vec2 drawPos = null;

    public Planet() {
        this.name = "ROOT";
        this.id = nextId;
        nextId ++;
        this.type = PlanetType.ROOT;
    }

    public Planet(String name, long mass, int color, PlanetType type) {
        this.name = name;
        this.id = nextId;
        nextId ++;
        this.mass = mass;
        this.color = color;
        this.type = type;
    }

    public void addMoon(Planet moon) {
        moons.add(moon);
    }
}

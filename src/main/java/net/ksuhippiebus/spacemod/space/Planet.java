package net.ksuhippiebus.spacemod.space;

import java.util.ArrayList;
import java.util.List;

public class Planet {
    public String name = "";
    public int id = 0;
    public long mass = 0;
    public int color = 0xFF000000;
    public PlanetType type;

    public List<Planet> orbitingBodies = new ArrayList<>();

    public Orbit orbit = new Orbit();

    public Planet(String name, int id, long mass, int color, PlanetType type) {
        this.name = name;
        this.id = id;
        this.mass = mass;
        this.color = color;
        this.type = type;
    }

    public void addMoon(Planet moon) {
        orbitingBodies.add(moon);
    }
}

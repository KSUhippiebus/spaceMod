package net.ksuhippiebus.spacemod.data.starsystems;

import net.ksuhippiebus.spacemod.space.Orbit;
import net.ksuhippiebus.spacemod.space.Planet;
import net.ksuhippiebus.spacemod.space.PlanetType;

public class Sol extends StarSystem {

    public Planet SUN =
            //new Planet("Sun", 0, 198900000L, 0xFFFFFF00, PlanetType.STAR);
            new Planet("Sun", 50, 0xFFFFFF00, PlanetType.STAR);

    public Planet EARTH =
            //new Planet("Earth", 1, 597200L, 0xFF00AAFF, PlanetType.EARTHLIKE);
            new Planet("Earth", 20L, 0xFF00AAFF, PlanetType.EARTHLIKE);

    public Planet MOON1 =
            //new Planet("Moon", 2, 7348L, 0xFFAAAAAA, PlanetType.ROCK);
            new Planet("Moon", 8L, 0xFFAAAAAA, PlanetType.ROCK);

    public Planet MOON2 =
            //new Planet("Moon", 2, 7348L, 0xFFAAAAAA, PlanetType.ROCK);
            new Planet("Moon2", 3L, 0xFFAAAAAA, PlanetType.ROCK);

    public Planet MARS =
            new Planet("Mars", 20L, 0xFF9C2E35, PlanetType.ROCK);

    public Sol() {
        ROOT = new Planet();

        ROOT.addMoon(SUN);
        SUN.orbit = new Orbit();
        SUN.addMoon(EARTH);
        EARTH.orbit = new Orbit(20 * 60 * 5, 0, 200, SUN);
        SUN.addMoon(MARS);
        MARS.orbit = new Orbit(20, 0, 400, SUN);
        EARTH.addMoon(MOON1);
        MOON1.orbit = new Orbit(20 * 30, 0, 50, EARTH);
        EARTH.addMoon(MOON2);
        MOON2.orbit = new Orbit(20 * 30, (20 * 30) / 2, 70, EARTH);
    }
}

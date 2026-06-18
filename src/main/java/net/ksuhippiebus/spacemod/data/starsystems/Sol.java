package net.ksuhippiebus.spacemod.data.starsystems;

import net.ksuhippiebus.spacemod.space.Orbit;
import net.ksuhippiebus.spacemod.space.Planet;
import net.ksuhippiebus.spacemod.space.PlanetType;

//[TODO] change to implements
public class Sol extends StarSystem {

    public static Planet SUN =
            //new Planet("Sun", 0, 198900000L, 0xFFFFFF00, PlanetType.STAR);
            new Planet("Sun", 0, 100, 0xFFFFFF00, PlanetType.STAR);

    public Planet EARTH =
            //new Planet("Earth", 1, 597200L, 0xFF00AAFF, PlanetType.EARTHLIKE);
            new Planet("Earth", 1, 30L, 0xFF00AAFF, PlanetType.EARTHLIKE);

    public Planet MOON =
            //new Planet("Moon", 2, 7348L, 0xFFAAAAAA, PlanetType.ROCK);
            new Planet("Moon", 2, 5L, 0xFFAAAAAA, PlanetType.ROCK);

    public Sol() {
        //[TODO] FIX THIS
        ROOT = new Planet(-1);

        ROOT.addMoon(SUN);
        SUN.orbit = new Orbit();
        SUN.addMoon(EARTH);
        EARTH.orbit = new Orbit(20 * 60 * 5, 0, 30, SUN);
        EARTH.addMoon(MOON);
        MOON.orbit = new Orbit(20 * 30, 0, 10, EARTH);
    }
}

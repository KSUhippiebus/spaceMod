package net.ksuhippiebus.spacemod.data.starsystems;

import net.ksuhippiebus.spacemod.space.Planet;

public class StarSystem {

    private static int nextId = 0;

    public Planet ROOT = null;
    public final int id;

    public StarSystem() {
        this.id = nextId;
        nextId ++;
    }
}

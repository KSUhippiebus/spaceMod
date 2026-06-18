package net.ksuhippiebus.spacemod.client;

import net.ksuhippiebus.spacemod.data.starsystems.Sol;
import net.ksuhippiebus.spacemod.data.starsystems.StarSystem;
import net.ksuhippiebus.spacemod.space.Planet;
import net.ksuhippiebus.spacemod.utils.Vec2;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.ksuhippiebus.spacemod.SpaceMod;

import java.util.ArrayList;
import java.util.List;

import static net.ksuhippiebus.spacemod.utils.Drawing.*;


public class SpaceModMapScreen extends Screen {

    public StarSystem CurrentSystem = new Sol();

    public static final double scale = 0.5;
    public static final double massScale = 1; //0.0000001;
    public static final int orbitColor = 0xFF888888;
    public static final int orbitThickness = 1;

    public SpaceModMapScreen() {
        super(Component.literal("My GUI"));
    }

    @Override
    protected void init() {
        super.init();
        SpaceMod.LOGGER.info("init");

        CurrentSystem = new Sol();
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        //this.renderBackground(graphics);

        super.render(graphics, mouseX, mouseY, partialTick);

        graphics.fill(0,0,this.width, this.height, 0xFF000000);

        graphics.drawString(
                this.font,
                "timer is: "+ClientTimerData.ticks,
                this.width / 2 - 50,
                this.height / 2,
                0xFFFFFF
        );

        if (SpaceMod.DEBUG) {
            SpaceMod.LOGGER.info("Drawing system with id: " + CurrentSystem.id);
        }

        Planet currentPlanet = null;
        Planet lastPlanet = null;
        List<Planet> queuedPlanets = new ArrayList<>();
        if (CurrentSystem.ROOT != null) {
            //SpaceMod.LOGGER.info("CurrentSystem.ROOT != null");
            queuedPlanets.add(CurrentSystem.ROOT);
            // iterate over moons recursively

            if (SpaceMod.DEBUG) {
                SpaceMod.LOGGER.info("--- Start planet draw ---");
            }
            while (!queuedPlanets.isEmpty()) {

                currentPlanet = queuedPlanets.removeFirst();

                if (SpaceMod.DEBUG) {
                    SpaceMod.LOGGER.info(currentPlanet.name);
                }

                currentPlanet.drawPos = Vec2.add(
                        (currentPlanet.orbit.Parent != null ? currentPlanet.orbit.Parent.drawPos : new Vec2(0,0)),
                        currentPlanet.orbit.calcPos(ClientTimerData.ticks)
                );
                //[TODO] make this based on camera
                if (currentPlanet.orbit.Parent != null) {
                    fillCircle(graphics, this.width / 2 + (int)(currentPlanet.orbit.Parent.drawPos.x * scale), this.height / 2 + (int)(currentPlanet.orbit.Parent.drawPos.y * scale), (int)(currentPlanet.orbit.Radius)/2, orbitColor, orbitThickness);
                }
                fillCircle(graphics, this.width / 2 + (int)(currentPlanet.drawPos.x * scale), this.height / 2 + (int)(currentPlanet.drawPos.y * scale), (int)(currentPlanet.mass * massScale * scale) + 1, 0xFF000000);
                fillCircle(graphics, this.width / 2 + (int)(currentPlanet.drawPos.x * scale), this.height / 2 + (int)(currentPlanet.drawPos.y * scale), (int)(currentPlanet.mass * massScale * scale), currentPlanet.color);

                if (!(currentPlanet.moons.isEmpty())) {
                    queuedPlanets.addAll(currentPlanet.moons);
                }
            }

            if (SpaceMod.DEBUG) {
                SpaceMod.LOGGER.info("--- End planet draw ---");
            }
        }
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
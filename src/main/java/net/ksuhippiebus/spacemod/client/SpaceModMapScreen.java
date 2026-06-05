package net.ksuhippiebus.spacemod.client;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import static net.ksuhippiebus.spacemod.utils.Drawing.fillCircle;
import static net.ksuhippiebus.spacemod.utils.Drawing.fillEllipse;

public class SpaceModMapScreen extends Screen {

    public SpaceModMapScreen() {
        super(Component.literal("My GUI"));
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        //this.renderBackground(graphics);

        super.render(graphics, mouseX, mouseY, partialTick);

        graphics.drawString(
                this.font,
                "timer is: "+ClientTimerData.ticks,
                this.width / 2 - 50,
                this.height / 2,
                0xFFFFFF
        );

        //fillCircle(graphics, 100, 100, 40, 0xFFFF0000, 5);

        //fillEllipse(graphics, 250, 100, 80, 40, 0xFF00FF00);

        int radius = 100;

        double speed = (Math.PI / 10) / 10;
        double orbitDir = ClientTimerData.ticks * speed;

        fillEllipse(graphics, this.width/2, this.height/2, radius, radius, 0xAAFFFFFF, 2);

        fillCircle(graphics, (int)(this.width/2 + radius * Math.cos(orbitDir)), (int)(this.height/2 + radius * Math.sin(orbitDir)), 10, 0xFF00FF00);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
package net.ksuhippiebus.spacemod.client;

import net.minecraft.client.Minecraft;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;

@EventBusSubscriber
public class ClientForgeEvents {

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Post event) {

        while (SpaceModKeybinds.OPEN_GUI.consumeClick()) {
            Minecraft.getInstance().setScreen(new SpaceModMapScreen());
        }
    }
}
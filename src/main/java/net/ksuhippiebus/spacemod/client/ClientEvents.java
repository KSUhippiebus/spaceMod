package net.ksuhippiebus.spacemod.client;

import net.ksuhippiebus.spacemod.network.RequestTimerPacket;
import net.minecraft.client.Minecraft;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.network.PacketDistributor;

@EventBusSubscriber
public class ClientEvents {

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Post event) {

        ClientTimerData.ticks++;

        while (SpaceModKeybinds.OPEN_GUI.consumeClick()) {

            // request latest timer from server
            PacketDistributor.sendToServer(
                    new RequestTimerPacket()
            );

            // open GUI
            Minecraft.getInstance().setScreen(
                    new SpaceModMapScreen()
            );
        }
    }
}
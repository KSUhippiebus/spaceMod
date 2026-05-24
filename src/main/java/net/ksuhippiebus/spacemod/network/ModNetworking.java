package net.ksuhippiebus.spacemod.network;

import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

public class ModNetworking {

    public static void register(RegisterPayloadHandlersEvent event) {

        PayloadRegistrar registrar =
                event.registrar("1");

        registrar.playToServer(
                RequestTimerPacket.TYPE,
                RequestTimerPacket.STREAM_CODEC,
                RequestTimerPacketHandler::handle
        );

        registrar.playToClient(
                SyncTimerPacket.TYPE,
                SyncTimerPacket.STREAM_CODEC,
                SyncTimerPacketHandler::handle
        );
    }
}
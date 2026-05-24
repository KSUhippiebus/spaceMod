package net.ksuhippiebus.spacemod.network;

import net.ksuhippiebus.spacemod.client.ClientTimerData;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public class SyncTimerPacketHandler {

    public static void handle(
            final SyncTimerPacket packet,
            final IPayloadContext context
    ) {

        ClientTimerData.ticks = packet.ticks();
    }
}
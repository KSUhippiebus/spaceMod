package net.ksuhippiebus.spacemod.network;

import net.ksuhippiebus.spacemod.data.GlobalTimerData;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public class RequestTimerPacketHandler {

    public static void handle(
            final RequestTimerPacket packet,
            final IPayloadContext context
    ) {

        long ticks =
                GlobalTimerData.get(
                        context.player().getServer()
                ).getTicks();

        context.reply(new SyncTimerPacket(ticks));
    }
}
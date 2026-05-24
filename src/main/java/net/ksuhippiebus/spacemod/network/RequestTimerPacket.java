package net.ksuhippiebus.spacemod.network;

import io.netty.buffer.ByteBuf;
import net.ksuhippiebus.spacemod.SpaceMod;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record RequestTimerPacket()
        implements CustomPacketPayload {

    public static final Type<RequestTimerPacket> TYPE =
            new Type<>(
                    ResourceLocation.fromNamespaceAndPath(
                            SpaceMod.MODID,
                            "request_timer"
                    )
            );

    public static final StreamCodec<ByteBuf, RequestTimerPacket> STREAM_CODEC =
            StreamCodec.unit(new RequestTimerPacket());

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
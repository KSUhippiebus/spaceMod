package net.ksuhippiebus.spacemod.network;

import io.netty.buffer.ByteBuf;
import net.ksuhippiebus.spacemod.SpaceMod;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record SyncTimerPacket(long ticks)
        implements CustomPacketPayload {

    public static final Type<SyncTimerPacket> TYPE =
            new Type<>(
                    ResourceLocation.fromNamespaceAndPath(
                            SpaceMod.MODID,
                            "sync_timer"
                    )
            );

    public static final StreamCodec<ByteBuf, SyncTimerPacket> STREAM_CODEC =
            StreamCodec.composite(
                    ByteBufCodecs.VAR_LONG,
                    SyncTimerPacket::ticks,
                    SyncTimerPacket::new
            );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
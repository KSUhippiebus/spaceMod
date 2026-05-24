package net.ksuhippiebus.spacemod.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.saveddata.SavedData;

public class GlobalTimerData extends SavedData {

    private long ticks = 0;

    public long getTicks() {
        return ticks;
    }

    public void tick() {
        ticks++;
        setDirty(); // marks for saving
    }

    public static GlobalTimerData create() {
        return new GlobalTimerData();
    }

    public static GlobalTimerData load(CompoundTag tag, HolderLookup.Provider registries) {
        GlobalTimerData data = new GlobalTimerData();
        data.ticks = tag.getLong("ticks");
        return data;
    }

    @Override
    public CompoundTag save(CompoundTag tag, HolderLookup.Provider registries) {
        tag.putLong("ticks", ticks);
        return tag;
    }

    public static GlobalTimerData get(MinecraftServer server) {

        return server.overworld()
            .getDataStorage()
            .computeIfAbsent(
                    new Factory<>(
                            GlobalTimerData::create,
                            GlobalTimerData::load
                    ),
                    "spacemod_global_timer"
            );
    }
}
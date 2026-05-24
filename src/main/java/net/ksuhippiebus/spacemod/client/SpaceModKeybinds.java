package net.ksuhippiebus.spacemod.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class SpaceModKeybinds {

    public static final String CATEGORY =
            "key.categories.spacemod";

    public static final KeyMapping OPEN_GUI = new KeyMapping(
            "key.spacemod.open_gui",
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_G,
            CATEGORY
    );
}

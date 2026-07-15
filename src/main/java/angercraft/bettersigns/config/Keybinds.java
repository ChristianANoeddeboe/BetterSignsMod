package angercraft.bettersigns.config;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.common.util.Lazy;
import org.lwjgl.glfw.GLFW;

public class Keybinds {

    public static final Lazy<KeyMapping> noSignGui = Lazy.of(() -> new KeyMapping("key.bettersigns.nosigntext", KeyConflictContext.UNIVERSAL, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_LEFT_ALT, "key.categories.bettersigns"));
}

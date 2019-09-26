package angercraft.bettersigns.config;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.fml.client.registry.ClientRegistry;

import static org.lwjgl.input.Keyboard.KEY_LMENU;

public class Keybinds {

    public static KeyBinding noSignGui;

    public static void register() {

        noSignGui = new KeyBinding("key.bettersigns.nosigntext", KeyConflictContext.IN_GAME, KEY_LMENU , "key.categories.bettersigns");

        ClientRegistry.registerKeyBinding(noSignGui);
    }
}

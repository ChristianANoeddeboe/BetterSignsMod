package angercraft.bettersigns.client;

import angercraft.bettersigns.config.Keybinds;
import net.minecraft.client.gui.screens.inventory.AbstractSignEditScreen;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.event.ScreenEvent;

/**
 * Client-side setup for Better Signs. Registers the event listeners directly on each event's bus.
 */
public final class BetterSignsClient {

    private BetterSignsClient() {}

    public static void init() {
        // Register the keybind used to suppress the sign editing GUI.
        RegisterKeyMappingsEvent.BUS.addListener(
                (RegisterKeyMappingsEvent event) -> event.register(Keybinds.noSignGui.get()));

        // While the keybind is held, cancel the opening of any sign edit screen so that signs can be
        // placed and edited without the text GUI. Returning true from the listener cancels the event.
        ScreenEvent.Opening.BUS.addListener(
                (ScreenEvent.Opening event) -> event.getScreen() instanceof AbstractSignEditScreen
                        && Keybinds.noSignGui.get().isDown());
    }
}

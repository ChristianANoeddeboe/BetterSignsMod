package angercraft.bettersigns.client;

import angercraft.bettersigns.config.Keybinds;
import net.minecraft.client.gui.inventory.GuiEditSign;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Eventlistener {

    @SubscribeEvent
    public static void onRenderGui(GuiOpenEvent event) {
        if(event.getGui() instanceof GuiEditSign) {
            if(Keybinds.noSignGui.isKeyDown()) {
                event.setCanceled(true);
            }
        }
    }
}

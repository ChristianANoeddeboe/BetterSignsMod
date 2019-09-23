package angercraft.bettersigns.client;

import angercraft.bettersigns.BetterSigns;
import angercraft.bettersigns.config.Keybinds;
import net.minecraft.client.gui.screen.EditSignScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BetterSigns.MOD_ID, value = Dist.CLIENT)
public class Eventlistener {

    @SubscribeEvent
    public static void onRenderGui(GuiOpenEvent event) {
        if(event.getGui() instanceof EditSignScreen) {
            if(Keybinds.noSignGui.isKeyDown()) {
                event.setCanceled(true);
            }
        }
    }
}

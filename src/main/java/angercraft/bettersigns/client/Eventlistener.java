package angercraft.bettersigns.client;

import angercraft.bettersigns.BetterSigns;
import angercraft.bettersigns.config.Keybinds;
import net.minecraft.client.gui.screens.inventory.SignEditScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ScreenOpenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BetterSigns.MOD_ID, value = Dist.CLIENT)
public class Eventlistener {

    @SubscribeEvent
    public static void onRenderGui(ScreenOpenEvent event) {
        if(event.getScreen() instanceof SignEditScreen) {
            if(Keybinds.noSignGui.isDown()) {
                event.setCanceled(true);
            }
        }
    }
}

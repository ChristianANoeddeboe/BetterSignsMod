package angercraft.bettersigns.client;

import angercraft.bettersigns.BetterSigns;
import net.minecraft.client.gui.screens.inventory.SignEditScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static angercraft.bettersigns.config.Keybinds.noSignGui;

@Mod.EventBusSubscriber(modid = BetterSigns.MOD_ID, value = Dist.CLIENT)
public class Eventlistener {

    @SubscribeEvent
    public static void onRenderGui(ScreenEvent.Opening event) {
        if(event.getScreen() instanceof SignEditScreen) {
            if(noSignGui.get().isDown()) {
                event.setCanceled(true);
            }
        }
    }
}

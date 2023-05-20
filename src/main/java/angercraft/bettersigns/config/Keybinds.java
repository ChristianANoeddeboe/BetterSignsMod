package angercraft.bettersigns.config;

import angercraft.bettersigns.BetterSigns;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = BetterSigns.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Keybinds {

    public static final Lazy<KeyMapping> noSignGui = Lazy.of(() -> new KeyMapping("key.bettersigns.nosigntext", KeyConflictContext.UNIVERSAL, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_LEFT_ALT, "key.categories.bettersigns"));

    @SubscribeEvent
    public static void registerKeyBindings(final RegisterKeyMappingsEvent event) {
        event.register(noSignGui.get());
    }
}

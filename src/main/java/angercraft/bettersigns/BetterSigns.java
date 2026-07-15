package angercraft.bettersigns;

import angercraft.bettersigns.client.BetterSignsClient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(BetterSigns.MOD_ID)
public class BetterSigns {
    public static final String MOD_ID = "bettersigns";

    public BetterSigns(FMLJavaModLoadingContext context) {
        // This mod is purely client-side. Only wire up the client event listeners on the client so
        // that client-only classes are never loaded on a dedicated server.
        if (FMLEnvironment.dist == Dist.CLIENT) {
            BetterSignsClient.init();
        }
    }
}

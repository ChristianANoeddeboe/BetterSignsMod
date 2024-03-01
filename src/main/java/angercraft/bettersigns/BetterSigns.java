package angercraft.bettersigns;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(BetterSigns.MOD_ID)
public class BetterSigns {
    public static final String MOD_ID = "bettersigns";

    private static final Logger LOGGER = LogManager.getLogger();

    public BetterSigns() {
        MinecraftForge.EVENT_BUS.register(this);
    }
}

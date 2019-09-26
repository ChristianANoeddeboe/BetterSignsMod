package angercraft.bettersigns;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = BetterSigns.MOD_ID, name = BetterSigns.NAME, version = BetterSigns.VERSION, acceptedMinecraftVersions = BetterSigns.MCVERSION)
public class BetterSigns
{
    public static final String MOD_ID = "bettersigns";
    public static final String NAME = "Better Signs";
    public static final String VERSION = "0.1.0";
    public static final String MCVERSION = "(,1.12.2]";

    public static final String CLIENT_PROXY_CLASS = "angercraft.bettersigns.proxy.ClientProxy";
    public static final String SERVER_PROXY_CLASS = "angercraft.bettersigns.proxy.ServerProxy";

    @Instance
    public static BetterSigns instance;

    public static Logger logger;

    @SidedProxy(clientSide = CLIENT_PROXY_CLASS, serverSide = SERVER_PROXY_CLASS)
    private static angercraft.bettersigns.proxy.IProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init();
    }

    @EventHandler
    public void postinit(FMLPostInitializationEvent event) {
        proxy.postInit();
    }
}

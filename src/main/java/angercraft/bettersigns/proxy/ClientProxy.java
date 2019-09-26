package angercraft.bettersigns.proxy;

import angercraft.bettersigns.client.Eventlistener;
import angercraft.bettersigns.config.Keybinds;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy implements IProxy {

	@Override
	public void preInit() {}

	@Override
	public void init() {
		Keybinds.register();
	}

	@Override
	public void postInit() {
		MinecraftForge.EVENT_BUS.register(Eventlistener.class);
	}


}

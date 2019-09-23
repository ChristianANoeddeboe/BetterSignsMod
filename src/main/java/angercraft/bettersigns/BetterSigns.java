package angercraft.bettersigns;

import net.minecraft.block.StandingSignBlock;
import net.minecraft.block.WallSignBlock;
import net.minecraft.item.SignItem;
import net.minecraft.tileentity.SignTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(value = BetterSigns.MOD_ID)
public class BetterSigns
{
    public static final String MOD_ID = "bettersigns";

    private static final Logger LOGGER = LogManager.getLogger();

    public BetterSigns() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onRightClicked(PlayerInteractEvent.RightClickBlock event) {
        if(event.getWorld().getBlockState(event.getPos()).getBlock() instanceof WallSignBlock || event.getWorld().getBlockState(event.getPos()).getBlock() instanceof StandingSignBlock) {
            if(event.getItemStack().getItem() instanceof SignItem) {
                return;
            }
            TileEntity tileEntity = event.getWorld().getTileEntity(event.getPos());
            if(event.getPlayer().isSneaking() && tileEntity instanceof SignTileEntity) {
                SignTileEntity signTileEntity = (SignTileEntity) tileEntity;
                signTileEntity.setPlayer(event.getPlayer());
                try {
                    ObfuscationReflectionHelper.findField(SignTileEntity.class, "field_145916_j").set(signTileEntity, true);
                    event.getPlayer().openSignEditor(signTileEntity);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

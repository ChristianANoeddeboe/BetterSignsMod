package angercraft.bettersigns;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSign;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = BetterSigns.MOD_ID)
public class EditSigns {

    @SubscribeEvent
    public static void onRightClicked(PlayerInteractEvent.RightClickBlock event) {
        if(event.getWorld().getBlockState(event.getPos()).getBlock().equals(Blocks.WALL_SIGN) || event.getWorld().getBlockState(event.getPos()).getBlock().equals(Blocks.STANDING_SIGN)) {
            if(event.getItemStack().getItem() instanceof ItemSign) {
                return;
            }
            TileEntity tileEntity = event.getWorld().getTileEntity(event.getPos());
            if(event.getEntityPlayer().isSneaking() && tileEntity instanceof TileEntitySign) {
                TileEntitySign signTileEntity = (TileEntitySign) tileEntity;
                signTileEntity.setPlayer(event.getEntityPlayer());
                try {
                    ObfuscationReflectionHelper.setPrivateValue(TileEntitySign.class, signTileEntity, true, "field_145916_j");
                } catch(NoSuchMethodError e) {
                    //Makes it compatible with the latest recommended release of Forge, version 1.12.2 - 14.23.5.2768
                    ObfuscationReflectionHelper.setPrivateValue(TileEntitySign.class, signTileEntity, true, "field_145916_j", "isEditable");
                }
                event.getEntityPlayer().openEditSign(signTileEntity);
            }
        }
    }
}

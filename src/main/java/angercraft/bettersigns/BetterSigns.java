package angercraft.bettersigns;

import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

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
        if(event.getLevel().getBlockState(event.getPos()).getBlock() instanceof WallSignBlock || event.getLevel().getBlockState(event.getPos()).getBlock() instanceof StandingSignBlock) {
            LOGGER.log(Level.DEBUG, event);
            LOGGER.log(Level.DEBUG, event.getItemStack().getItem());
            System.out.println(event.getItemStack().getItem());
            if(event.getItemStack().getItem() instanceof SignItem) {
                return;
            }
            BlockEntity tileEntity = event.getLevel().getBlockEntity(event.getPos());
            if(event.getEntity().isCrouching() && tileEntity instanceof SignBlockEntity) {
                SignBlockEntity signTileEntity = (SignBlockEntity) tileEntity;
                signTileEntity.setEditable(true);
                event.getEntity().openTextEdit(signTileEntity);
            }
        }
    }
}

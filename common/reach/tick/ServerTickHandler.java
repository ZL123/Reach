package reach.tick;

import java.util.EnumSet;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemInWorldManager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatMessageComponent;
import reach.config.ConfigSettings;
import reach.item.ModItems;
import reach.lib.Reference;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ServerTickHandler implements ITickHandler {
	
	protected int grabberTickCount = 0;
	protected boolean flag = false;
	protected boolean b1 = false;
	protected long i1;
	protected long i2;
	
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		if (type.equals(EnumSet.of(TickType.PLAYER))) {
			onPlayerTick((EntityPlayer) tickData[0]);
		}
	}
	
	protected void onPlayerTick(EntityPlayer player) {
		ItemInWorldManager manager = ((EntityPlayerMP)player).theItemInWorldManager;
		System.out.println(grabberTickCount);
		ItemStack stack = player.getCurrentEquippedItem();
		grabberTickCount += 1;
		if(flag) flag = false;
		
		if(stack != null) {
			
			if(stack.hasTagCompound()) {
				if(stack.getTagCompound().getBoolean(Reference.GRABBER_ACTIVATION_KEY) && b1 == false) {
					b1 = true;
					i1 = grabberTickCount;
				}
				
				if(stack.itemID == ModItems.itemGrabberIron.itemID && stack.getTagCompound().getBoolean(Reference.GRABBER_ACTIVATION_KEY)) {
					i2 = i1 + (ConfigSettings.grabberIronTime * Reference.TICKS_PER_SECOND);
					if(flag) grabberTickCount = 0;
					manager.setBlockReachDistance(Reference.BLOCK_REACH_DISTANCE + ConfigSettings.grabberIronBonus);
					if(i2 < grabberTickCount) {
						manager.setBlockReachDistance(Reference.BLOCK_REACH_DISTANCE);
						manager.thisPlayerMP.sendChatToPlayer(new ChatMessageComponent().addText("Your Reach bonus has worn off.").setItalic(true));
						grabberTickCount = 0;
						System.out.println(stack.getTagCompound().getBoolean(Reference.GRABBER_ACTIVATION_0));
						stack.getTagCompound().setBoolean(Reference.GRABBER_ACTIVATION_KEY, false);
						stack.getTagCompound().setBoolean(Reference.GRABBER_ACTIVATION_0, false);
						flag = true;
						b1 = false;
					}
				}
			}
		}
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.PLAYER, TickType.SERVER);
	}

	@Override
	public String getLabel() {
		return Reference.MOD_ID + ": " + getClass().getSimpleName();
	}

}

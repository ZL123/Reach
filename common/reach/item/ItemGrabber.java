package reach.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.world.World;
import reach.config.ConfigSettings;
import reach.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemGrabber extends Item {
	
	protected static double reachBonus;
	protected static long maxReachTime;
	protected static long currentReachTime;
	protected NBTTagCompound compound = new NBTTagCompound();
	
	public ItemGrabber(int id, int durability, double bonus, long time) {
		super(id);
		setMaxDamage(durability);
		reachBonus = bonus;
		maxReachTime = time;
		maxStackSize = 1;
		isDamageable();
		setNoRepair();
		setFull3D();
		setCreativeTab(CreativeTabs.tabTools);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		
		stack.damageItem(1, player);
		stack.setTagCompound(compound);
		if (stack.getTagCompound().getBoolean(Reference.GRABBER_ACTIVATION_KEY)) stack.getTagCompound().setBoolean(Reference.GRABBER_ACTIVATION_0, true);
		compound.setBoolean(Reference.GRABBER_ACTIVATION_KEY, true);
		if(player.worldObj.isRemote) {
			if(stack.getTagCompound().getBoolean(Reference.GRABBER_ACTIVATION_KEY) &&
					!stack.getTagCompound().getBoolean(Reference.GRABBER_ACTIVATION_0)) {
				player.sendChatToPlayer(new ChatMessageComponent().addText("You can now reach further!"));	
			}
		}
			
		return stack;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		this.itemIcon = register.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(5));
		
	}
	
	protected int theSuperior(int item1, int item2) {
		if (item1 == ConfigSettings.grabberCreativeID) return item1;
		else if (item1 == ConfigSettings.grabberObsidianID) return
				item2 == ConfigSettings.grabberCreativeID ? item2 : item1;
		else if (item1 == ConfigSettings.grabberDiamondID) return
				item2 == ConfigSettings.grabberCreativeID ||
				item2 == ConfigSettings.grabberObsidianID ? item2 : item1;
		else if (item1 == ConfigSettings.grabberGoldID) return
				item2 == ConfigSettings.grabberIronID ? item1 : item2;
		else if (item1 == ConfigSettings.grabberIronID) return item2;
		else return -1;
		
	}
	
}

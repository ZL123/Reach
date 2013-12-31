package reach.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.world.World;
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
		compound.setBoolean(Reference.GRABBER_ACTIVATION_KEY, true);
		if(player.worldObj.isRemote) player.sendChatToPlayer(new ChatMessageComponent().addText("You can now reach further!"));
		
		return stack;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		this.itemIcon = register.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(5));
		
	}
	
}

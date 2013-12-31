package reach.item;

import reach.config.ConfigSettings;
import net.minecraft.item.Item;

public class ModItems {
	
	//Instances
	public static Item itemGrabberIron;
	public static Item itemGrabberGold;
	public static Item itemGrabberDiamond;
	public static Item itemGrabberObsidian;
	public static Item itemGrabberCreative;
	
	public static void init() {
		
		itemGrabberIron = new ItemGrabber(ConfigSettings.grabberIronID, ConfigSettings.grabberIronDurability,
											ConfigSettings.grabberIronBonus, ConfigSettings.grabberIronTime)
											.setUnlocalizedName("grabberIron");
		itemGrabberGold = new ItemGrabber(ConfigSettings.grabberGoldID, ConfigSettings.grabberGoldDurability,
											ConfigSettings.grabberGoldBonus, ConfigSettings.grabberGoldTime)
											.setUnlocalizedName("grabberGold");
		
	}
	
}

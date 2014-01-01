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
		itemGrabberDiamond = new ItemGrabber(ConfigSettings.grabberDiamondID, ConfigSettings.grabberDiamondDurability,
									ConfigSettings.grabberDiamondBonus, ConfigSettings.grabberDiamondTime)
									.setUnlocalizedName("grabberDiamond");
		itemGrabberObsidian = new ItemGrabber(ConfigSettings.grabberObsidianID, ConfigSettings.grabberObsidianDurability,
									ConfigSettings.grabberObsidianBonus, ConfigSettings.grabberObsidianTime)
									.setUnlocalizedName("grabberObsidian");
		itemGrabberCreative = new ItemGrabber(ConfigSettings.grabberCreativeID, -1, 0, -1).setUnlocalizedName("grabberCreative");
		
		
		
	}
	
}

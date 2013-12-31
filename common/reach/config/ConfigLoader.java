package reach.config;

import net.minecraftforge.common.Configuration;
import reach.lib.DefaultValues;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ConfigLoader {
	
	public static Configuration config;
	
	public static void init(FMLPreInitializationEvent event) {
		
		config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		
		//Item IDs
		ConfigSettings.grabberIronID = config.getItem("Iron Grabber ID", DefaultValues.grabberIronID).getInt();
		ConfigSettings.grabberGoldID = config.getItem("Gold Grabber ID", DefaultValues.grabberGoldID).getInt();
		ConfigSettings.grabberDiamondID = config.getItem("Diamond Grabber ID", DefaultValues.grabberDiamondID).getInt();
		ConfigSettings.grabberObsidianID = config.getItem("Obsidian Grabber ID", DefaultValues.grabberObsidianID).getInt();
		ConfigSettings.grabberCreativeID = config.getItem("Creative Grabber ID", DefaultValues.grabberCreativeID).getInt();
		
		//Durability
		ConfigSettings.grabberIronDurability = config.get("Iron Grabber Durability", "Durability", DefaultValues.grabberIronDurability).getInt();
		ConfigSettings.grabberGoldDurability = config.get("Gold Grabber Durability", "Durability", DefaultValues.grabberGoldDurability).getInt();
		ConfigSettings.grabberDiamondDurability = config.get("Diamond Grabber Durability", "Durability", DefaultValues.grabberDiamondDurability).getInt();		
		ConfigSettings.grabberObsidianDurability = config.get("Obsidian Grabber Durability", "Durability", DefaultValues.grabberObsidianDurability).getInt();
		
		//Reach bonus
		ConfigSettings.grabberIronBonus = config.get("Iron Grabber Reach", "Reach Bonus", DefaultValues.grabberIronBonus).getDouble(DefaultValues.grabberIronBonus);
		ConfigSettings.grabberGoldBonus = config.get("Gold Grabber Reach", "Reach Bonus", DefaultValues.grabberGoldBonus).getDouble(DefaultValues.grabberGoldBonus);
		ConfigSettings.grabberDiamondBonus = config.get("Diamond Grabber Reach", "Reach Bonus", DefaultValues.grabberDiamondBonus).getDouble(DefaultValues.grabberDiamondBonus);
		ConfigSettings.grabberObsidianBonus = config.get("Obsidian Grabber Reach", "Reach Bonus", DefaultValues.grabberObsidianBonus).getDouble(DefaultValues.grabberObsidianBonus);
		
		//Extra reach time
		ConfigSettings.grabberIronTime = config.get("Iron Grabber Time", "Reach Time", DefaultValues.grabberIronTime).getInt((int)DefaultValues.grabberIronTime);
		ConfigSettings.grabberGoldTime = config.get("Gold Grabber Time", "Reach Time", DefaultValues.grabberGoldTime).getInt((int)DefaultValues.grabberGoldTime);
		ConfigSettings.grabberDiamondTime = config.get("Diamond Grabber Time", "Reach Time", DefaultValues.grabberDiamondTime).getInt((int)DefaultValues.grabberDiamondTime);
		ConfigSettings.grabberObsidianTime = config.get("Obsidian Grabber Time", "Reach Time", DefaultValues.grabberObsidianTime).getInt((int)DefaultValues.grabberObsidianTime);
		
		config.save();
	
	}

}

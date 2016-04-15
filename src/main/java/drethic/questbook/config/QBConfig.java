package drethic.questbook.config;

import java.io.File;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import drethic.questbook.QuestBook;
import drethic.questbook.logger.QBLogger;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class QBConfig {
	public static Configuration qbconfig;
	public static QBConfig instance;

	public static boolean spawnWithBook;
	public static boolean disablePartyNotifications;
	public static boolean disableQuestNotifications;
	
	public static final void init(FMLPreInitializationEvent e) {
		QBLogger.logger.info("Loading config file.");
		qbconfig = new Configuration(new File(e.getModConfigurationDirectory().getAbsolutePath() + "/betterquesting/questbook.cfg"));
		qbconfig.load();

		qbconfig.addCustomCategoryComment(qbconfig.CATEGORY_GENERAL, "General options for the Quest Book mod.");

		spawnWithBook = configBoolOption(qbconfig.CATEGORY_GENERAL, "spawnWithBook", false, "Enable this option so new players will spawn with a Quest Book. Default: false");
		disablePartyNotifications = configBoolOption(qbconfig.CATEGORY_GENERAL, "disablePartyNotifications", false, "[WIP]Disable party notifications.  Default: false");
		disableQuestNotifications = configBoolOption(qbconfig.CATEGORY_GENERAL, "disableQuestNotifications", false, "[WIP]Disable quest notifications.  Default: false");
		
		qbconfig.save();
	}
	
	public static boolean configBoolOption(String section, String name, boolean defaultValue, String comment) {
		Property spawnWithBookProperty = qbconfig.get(section, name, defaultValue);
		spawnWithBookProperty.comment = comment;
		return spawnWithBookProperty.getBoolean(defaultValue);
	}
}

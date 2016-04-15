package drethic.questbook.config;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import drethic.questbook.QuestBook;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class QBConfig {
	public static Configuration qbconfig;
	public static QBConfig instance;
	public static final Logger logger = LogManager.getLogger(QuestBook.MODID);
	
	public static boolean spawnWithBook;
	public static final boolean SPAWNWITHBOOK_DEFAULT = false;
	public static final String SPAWNWITHBOOK_NAME = "spawnWithBook";

	public static boolean disablePartyNotifications;
	public static final boolean DISABLEPARTYNOTIFICATIONS_DEFAULT = false;
	public static final String DISABLEPARTYNOTIFICATIONS_NAME = "disablePartyNotifications";

	public static boolean disableQuestNotifications;
	public static final boolean DISABLEQUESTNOTIFICATIONS_DEFAULT = false;
	public static final String DISABLEQUESTNOTIFICATIONS_NAME = "disableQuestNotifications";
	
	public static final void init(FMLPreInitializationEvent e) {
		logger.info("Loading config file.");
		qbconfig = new Configuration(new File(e.getModConfigurationDirectory().getAbsolutePath() + "/betterquesting/questbook.cfg"));
		qbconfig.load();
		configOptions();
		qbconfig.save();
	}
	
	public static void configOptions() {
		final String OPTIONS = qbconfig.CATEGORY_GENERAL + qbconfig.CATEGORY_SPLITTER + "Options";
		qbconfig.addCustomCategoryComment(OPTIONS, "General options for the Quest Book mod.");
		Property spawnWithBookProperty = qbconfig.get(OPTIONS, SPAWNWITHBOOK_NAME, SPAWNWITHBOOK_DEFAULT);
		spawnWithBookProperty.comment = "Enable this option so new players will spawn with a Quest Book. Default: false";
		spawnWithBook = spawnWithBookProperty.getBoolean(SPAWNWITHBOOK_DEFAULT);

		Property disablePartyNotificationsProperty = qbconfig.get(OPTIONS, DISABLEPARTYNOTIFICATIONS_NAME, DISABLEPARTYNOTIFICATIONS_DEFAULT);
		disablePartyNotificationsProperty.comment = "[WIP]Disable party notifications.  Default: false";
		disablePartyNotifications = disablePartyNotificationsProperty.getBoolean(DISABLEPARTYNOTIFICATIONS_DEFAULT);

		Property disableQuestNotificationsProperty = qbconfig.get(OPTIONS, DISABLEQUESTNOTIFICATIONS_NAME, DISABLEQUESTNOTIFICATIONS_DEFAULT);
		disableQuestNotificationsProperty.comment = "[WIP]Disable party notifications.  Default: false";
		disableQuestNotifications = disableQuestNotificationsProperty.getBoolean(DISABLEQUESTNOTIFICATIONS_DEFAULT);
	}
}

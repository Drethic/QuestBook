package drethic.questbook.proxy;

import drethic.questbook.config.QBConfig;
import drethic.questbook.crafting.QBCrafting;
import drethic.questbook.events.FMLEventHandler;
import drethic.questbook.item.QBItems;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
        QBItems.init();
        QBCrafting.init();
        QBConfig.init(e);
    }

    public void init(FMLInitializationEvent e) {
    	FMLCommonHandler.instance().bus().register(FMLEventHandler.INSTANCE);
    }

    public void postInit(FMLPostInitializationEvent e) {

    }
}
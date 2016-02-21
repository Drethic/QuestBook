package drethic.questbook.proxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import drethic.questbook.crafting.QBCrafting;
import drethic.questbook.item.QBItems;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
        QBItems.init();
        QBCrafting.init();
    }

    public void init(FMLInitializationEvent e) {

    }

    public void postInit(FMLPostInitializationEvent e) {

    }
}
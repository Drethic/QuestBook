package drethic.questbook.proxy;

import drethic.questbook.config.QBConfig;
import drethic.questbook.events.FMLEventHandler;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
        QBConfig.init(e);
    }

    public void init(FMLInitializationEvent e) {
    	MinecraftForge.EVENT_BUS.register(FMLEventHandler.INSTANCE);
    }

    public void postInit(FMLPostInitializationEvent e) {

    }

    public void registerItemRenderer(Item item, int meta, String id) {

    }

    public String localize(String unlocalized, Object... args) {
        return I18n.format(unlocalized, args);
    }

    public void registerRenderers() {
    }
}
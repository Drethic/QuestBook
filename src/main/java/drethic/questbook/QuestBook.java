package drethic.questbook;

import drethic.questbook.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = QuestBook.MODID, name = QuestBook.MODNAME, version = QuestBook.VERSION, dependencies = "required-after:betterquesting@[2.3.195,)")
public class QuestBook {

	
    public static final String MODID = "questbook";
    public static final String MODNAME = "Better Questing Quest Book";
    public static final String VERSION = "2.1.0-1.10";
        
    @Instance("MODID")
    public static QuestBook instance = new QuestBook();

    @SidedProxy(clientSide="drethic.questbook.proxy.ClientProxy", serverSide="drethic.questbook.proxy.ServerProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
    	proxy.preInit(e);
    }
        
    @EventHandler
    public void init(FMLInitializationEvent e) {
    	proxy.init(e);
    }
        
    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
    	proxy.postInit(e);
    }
}
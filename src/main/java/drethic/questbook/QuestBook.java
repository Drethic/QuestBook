package drethic.questbook;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import drethic.questbook.item.QBItems;
import drethic.questbook.proxy.CommonProxy;
import drethic.questbook.recipe.QBRecipes;

@Mod(modid = QuestBook.modId, name = QuestBook.name, version = QuestBook.version, dependencies = "required-after:betterquesting@[2.5.236,)")
public class QuestBook {

    public static final String modId = "questbook";
    public static final String name = "Better Questing Quest Book";
    public static final String version = "3.0.1-1.12.1";

    @Mod.Instance(modId)
    public static QuestBook instance;

    @SidedProxy(serverSide = "drethic.questbook.proxy.ServerProxy", clientSide = "drethic.questbook.proxy.ClientProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
        proxy.registerRenderers();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
        QBRecipes.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @Mod.EventBusSubscriber
    public static class RegsitrationHandler {

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            QBItems.register(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
        }

        @SubscribeEvent
        public static void registerModels(ModelRegistryEvent event) {
            QBItems.registerModels();
        }

    }

}
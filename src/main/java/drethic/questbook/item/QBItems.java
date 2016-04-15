package drethic.questbook.item;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import drethic.questbook.QuestBook;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public final class QBItems {
    public static Item questBook = new questBook();
    public static final Logger logger = LogManager.getLogger(QuestBook.MODID);
    
    public static final void init() {
    	GameRegistry.registerItem(questBook, "questBook");
    }
}

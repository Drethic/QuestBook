package drethic.questbook.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public final class QBItems {
    public static Item questBook = new questBook();
    
    public static final void init() {
    	GameRegistry.registerItem(questBook, "questBook");
    }
}

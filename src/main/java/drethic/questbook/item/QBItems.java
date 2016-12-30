package drethic.questbook.item;

import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public final class QBItems {
    public static ItemQuestBook itemQuestBook;
    
    public static final void init() {
    	itemQuestBook = new ItemQuestBook();
    }
    
    @SideOnly(Side.CLIENT)
    public static final void clientInit() {
    	itemQuestBook.initModel();
    }
}

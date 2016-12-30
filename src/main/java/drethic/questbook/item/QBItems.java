package drethic.questbook.item;

import net.minecraft.item.Item;

public final class QBItems {
    public static ItemQuestBook itemQuestBook;
    
    public static final void init() {
    	itemQuestBook = new ItemQuestBook();
    	itemQuestBook.initModel();
    }
}

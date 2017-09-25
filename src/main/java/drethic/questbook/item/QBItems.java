package drethic.questbook.item;

import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;
import drethic.questbook.QuestBook;
import drethic.questbook.item.*;

public class QBItems {

    public static ItemQuestBook questbook = new ItemQuestBook();

    public static void register(IForgeRegistry<Item> registry) {
        registry.register(questbook);
    }

    public static void registerModels() {
        questbook.registerItemModel();
    }
}
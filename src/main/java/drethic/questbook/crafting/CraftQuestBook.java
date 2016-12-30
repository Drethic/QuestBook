package drethic.questbook.crafting;

import drethic.questbook.item.QBItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class CraftQuestBook {
	public static final void init() {
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(QBItems.itemQuestBook), new Object[] {
			Items.BOOK, "stickWood"
		}));
	}
}

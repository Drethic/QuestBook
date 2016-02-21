package drethic.questbook.crafting;

import cpw.mods.fml.common.registry.GameRegistry;
import drethic.questbook.item.QBItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class questBook {
	public static final void init() {
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(QBItems.questBook), new Object[] {
			Items.book, "stickWood"
		}));
	}
}

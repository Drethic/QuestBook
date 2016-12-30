package drethic.questbook.item;

import betterquesting.api.storage.BQ_Settings;
import betterquesting.client.gui.GuiHome;
import betterquesting.client.gui.GuiQuestLinesMain;
import betterquesting.core.BetterQuesting;
import drethic.questbook.QuestBook;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemQuestBook extends Item {
	
	public static boolean hasEffect;
	
	public ItemQuestBook() {
    	setRegistryName("ItemQuestBook");
    	setUnlocalizedName("ItemQuestBook");
    	setCreativeTab(BetterQuesting.tabQuesting);
    	GameRegistry.register(this);
    	hasEffect = false;
    }
	
	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(QuestBook.MODID + ":" + this.getUnlocalizedName().substring(5), "inventory"));
	}

	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        return false;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
		Minecraft mc = Minecraft.getMinecraft();
		if(BQ_Settings.useBookmark && GuiQuestLinesMain.bookmarked != null) {
			mc.displayGuiScreen(GuiQuestLinesMain.bookmarked);
		} else {
			mc.displayGuiScreen(new GuiHome(mc.currentScreen));
		}
    	
		return new ActionResult<>(EnumActionResult.SUCCESS, stack);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack) {
		return hasEffect;
    }
}
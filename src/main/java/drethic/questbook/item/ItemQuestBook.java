package drethic.questbook.item;

import betterquesting.client.gui.GuiHome;
import betterquesting.client.gui.GuiQuestLinesMain;
import betterquesting.api.storage.BQ_Settings;
import betterquesting.core.BetterQuesting;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import drethic.questbook.QuestBook;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemQuestBook extends Item {
	
	public static boolean hasEffect;
	
	public ItemQuestBook() {
    	this.setTextureName(QuestBook.MODID + ":questBook");
    	this.setUnlocalizedName("ItemQuestBook");
    	this.setCreativeTab(BetterQuesting.tabQuesting);
    	hasEffect = false;
    }

	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        return false;
    }
    
	@Override
    @SideOnly(Side.CLIENT)
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		Minecraft mc = Minecraft.getMinecraft();
		if(BQ_Settings.useBookmark && GuiQuestLinesMain.bookmarked != null) {
			mc.displayGuiScreen(GuiQuestLinesMain.bookmarked);
		} else {
			mc.displayGuiScreen(new GuiHome(mc.currentScreen));
		}
    	
        return stack;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack) {
		return hasEffect;
    }
}
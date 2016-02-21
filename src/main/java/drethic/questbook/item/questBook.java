package drethic.questbook.item;

import betterquesting.client.gui.GuiHome;
import betterquesting.core.BetterQuesting;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import drethic.questbook.QuestBook;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class questBook extends Item{
	
	public questBook()
    {
    	this.setTextureName(QuestBook.MODID + ":questBook1-labled");
    	this.setUnlocalizedName("questBook");
    	this.setCreativeTab(BetterQuesting.tabQuesting);
    }

	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
        return false;
    }
    
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
    	if(world.isRemote)
    	{
    		Minecraft mc = Minecraft.getMinecraft();
			mc.displayGuiScreen(new GuiHome(mc.currentScreen));
    	}
    	
        return stack;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
		return false;
    }
	
}
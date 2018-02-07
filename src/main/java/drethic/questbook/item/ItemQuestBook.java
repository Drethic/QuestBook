package drethic.questbook.item;

import org.apache.commons.lang3.EnumUtils;
import betterquesting.api.storage.BQ_Settings;
import betterquesting.client.gui2.GuiHome;
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
    protected String name;

    public ItemQuestBook() {
        super();
        setUnlocalizedName("itemquestbook");
        setRegistryName("itemquestbook");
        setCreativeTab(BetterQuesting.tabQuesting);
        hasEffect = false;
    }

    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack stack = player.getHeldItem(hand);
        if (world.isRemote) {
            if ( hand.name() == "OFF_HAND" && null != player.inventory.getCurrentItem() && player.inventory.getCurrentItem().getItem() == player.inventory.offHandInventory.get(0).getItem()) {
                return new ActionResult(EnumActionResult.PASS, stack);
            }
            Minecraft mc = Minecraft.getMinecraft();
            if(BQ_Settings.useBookmark && GuiQuestLinesMain.bookmarked != null) {
                mc.displayGuiScreen(GuiQuestLinesMain.bookmarked);
            } else {
                mc.displayGuiScreen(new GuiHome(mc.currentScreen));
            }
        }

        return new ActionResult(EnumActionResult.PASS, stack);
    }

    public void registerItemModel() {
        QuestBook.proxy.registerItemRenderer(this, 0, "ItemQuestBook");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack) {
        return hasEffect;
    }
}
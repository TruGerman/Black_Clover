package animecenter.blackclover.guis;

import java.io.IOException;

import animecenter.blackclover.magic.MagicType;
import animecenter.blackclover.util.helpers.SpellHelper;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class GuiGrimoireFire extends GuiGrimoireBase 
{
	public GuiGrimoireFire(MagicType type, int level, ItemStack stack) 
	{
		super(type, level, stack);
	}
	
	@Override
	public void initGui() 
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f);
		super.initGui();
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException
	{
		super.actionPerformed(button);
	}
}

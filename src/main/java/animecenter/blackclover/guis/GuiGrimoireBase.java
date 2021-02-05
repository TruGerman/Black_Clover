package animecenter.blackclover.guis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import animecenter.blackclover.magic.MagicType;
import animecenter.blackclover.magic.Spell;
import animecenter.blackclover.network.GuiButtonPacket;
import animecenter.blackclover.util.Constants;
import animecenter.blackclover.util.helpers.SpellHelper;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public abstract class GuiGrimoireBase extends GuiScreen 
{
	
	protected MagicType type;
	protected EntityPlayer player;
	protected int level;
	protected ArrayList<Spell> list;
	protected int buttonID = 0;
	//maps buttonId to spell
	protected Map<Integer, Spell> buttonMap = new HashMap<>();
	protected ItemStack stack;

	public GuiGrimoireBase(MagicType type, int level, ItemStack stack) 
	{
		this.type = type;
		this.level = level;
		this.stack = stack;
	}
	
	@Override
	public void initGui() 
	{
		drawDefaultBackground();
		this.buttonList.clear();
		//past me here, I'm so not gonna enjoy writing this....
		//TODO button map for easy reference
		this.list = SpellHelper.getFilledLevelList(this.type, this.level);
		int totalSize = this.list.size();
		int x = 20;
		int y = 50;
		int rowCount = 0;
		Iterator<Spell> iterator = this.list.iterator();
		for(int i = 0; i < totalSize && i < 36; i++, this.buttonID++)
		{
			Spell nextSpell = iterator.next();
			this.buttonList.add(new GuiButton(this.buttonID, x, y, nextSpell.getName()));
			this.buttonMap.put(this.buttonID, nextSpell);
			rowCount++;
			x+=200;
			if(rowCount == 2)
			{
				y+=30;
				x-=400;
				rowCount = 0;
			}
		}
	}
	//present me here: HAHAHA I FUCKING DID IT!
	
	@Deprecated //nice try tho
	public void createRow(int buttons, int startX, int y, String[] names)
	{
		//should I make this dynamic? ah man
		//needlessly complicated but whatever
		int x = startX;
		int n = 0;
		for(int i = 0; i < buttons; i++, n++, x = x + 40)
		{
			this.buttonList.add(new GuiButton(buttonID, x, y, names[n]));
		}
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException 
	{
		Constants.INSTANCE.sendToServer(new GuiButtonPacket(this.buttonMap.get(button.id).getID()));
	}
	
	@Override
	public boolean doesGuiPauseGame() 
	{
		return false;
	}
}

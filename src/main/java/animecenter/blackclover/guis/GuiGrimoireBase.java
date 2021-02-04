package animecenter.blackclover.guis;

import java.util.ArrayList;
import java.util.Iterator;

import animecenter.blackclover.magic.MagicType;
import animecenter.blackclover.magic.Spell;
import animecenter.blackclover.util.helpers.SpellHelper;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;

public abstract class GuiGrimoireBase extends GuiScreen 
{
	
	protected MagicType type;
	protected EntityPlayer player;
	protected int level;
	protected ArrayList<Spell> list;
	protected int buttonID = 0;
	protected int x = 20;
	protected int y = 50;

	public GuiGrimoireBase(MagicType type, int level) 
	{
		this.type = type;
		this.level = level;
	}
	
	@Override
	public void initGui() 
	{
		this.drawDefaultBackground();
		this.buttonList.clear();
		//past me here, I'm so not gonna enjoy writing this....
		//TODO button map for easy reference
		this.list = SpellHelper.getFilledLevelList(type, level);
		int totalSize = this.list.size();
		int x = 20;
		int y = 50;
		int rowCount = 0;
		Iterator<Spell> iterator = this.list.iterator();
		for(int i = 0; i < totalSize && i < 36; i++, this.buttonID++)
		{
			this.buttonList.add(new GuiButton(buttonID, x, y, iterator.next().getName()));
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
}

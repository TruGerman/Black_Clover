package animecenter.blackclover.items;

import java.util.ArrayList;
import java.util.Iterator;

import animecenter.blackclover.BlackClover;
import animecenter.blackclover.magic.MagicType;
import animecenter.blackclover.magic.Spell;
import animecenter.blackclover.util.Constants;
import animecenter.blackclover.util.helpers.SpellHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

@Deprecated
//????
//how much fucking crack did you smoke when you made this holy shit
//past me was an actual retard like fuck me I can't believe this
public class GrimoireBase extends ItemBase 
{
	//I'm leaving this here for shits and giggles
	protected MagicType type;
	protected ArrayList<Spell> spells;
	protected int level;
	

	public GrimoireBase(String name, MagicType type, int level) 
	{
		super(name, Constants.GRIMOIRES);
		setMaxStackSize(1);
		this.type = type;
		this.level = level;
		spells = new ArrayList<>();
		Iterator<Spell> iterator = Spell.ALL_SPELLS.iterator();
		while(iterator.hasNext())
		{
			Spell pogchamp = iterator.next();
			if(pogchamp.getType() == this.type)
			{
				this.spells.add(pogchamp);
			}
		}
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) 
	{
		if(!worldIn.isRemote)
		{
			playerIn.openGui(BlackClover.instance, Constants.GUI_GRIMOIRE_BASE, worldIn, playerIn.getPosition().getX(), playerIn.getPosition().getY(), playerIn.getPosition().getZ());
			int[] test = playerIn.getHeldItem(handIn).getTagCompound().getIntArray("Spells");
			for(int i = 0; i<test.length;i++)
			{
			playerIn.sendMessage(new TextComponentString(Integer.toString(test[i])));
			}
		}	
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
	}
	
	public ArrayList<Spell> getSpells(GrimoireBase stack)
	{
		return stack.spells;
	}
	
	//shrug
	//present me: DUDE WHAT THE FUCK IS THIS
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) 
	{
		NBTTagCompound tag = stack.getTagCompound();
		if(tag == null)
		{
			tag = new NBTTagCompound();
			stack.writeToNBT(tag);
			this.writeToNBT(tag);
		}
		
	}
	//present me: WHY WOULD YOU EVEN-
	/* retarded
	 * public NBTTagCompound writeToNBT(NBTTagCompound tag)
	{
		Iterator<Spell> iterator = this.spells.iterator();
		int[] spellArray = new int[this.spells.size()];
		int i = 0;
		while(iterator.hasNext())
		{
			int[] values = new int[2];
			Spell pogchamp = iterator.next();
			values[1] = pogchamp.getDamage();
			values[2] = pogchamp.getManaCost();
			spellArray[i] = pogchamp.getID();
			i++;
			tag.setIntArray("Spell_ID:" + pogchamp.getID(), values);
			
		}
		tag.setIntArray("Spells", spellArray);
		return tag;
	} 
	
	//should probably just create spells using their unique ID...
	 * present me: hah yeah good idea, too bad IT'S STILL BRAINDEAD AS SHIT 
	public void readFromNBT(NBTTagCompound tag)
	{
		if(tag != null)
		{
			int[] spellIDs = tag.getIntArray("Spells");
			for(int i = 0; i<spellIDs.length; i++)
			{
				
			}
		}
		
	} */
	//could be worse
	//present me: NO, NO IT COULD NOT BE WORSE
	public NBTTagCompound writeToNBT(NBTTagCompound tag)
	{
		int[] idArray = new int[this.spells.size()];
		int i = 0;
		Iterator<Spell> iterator = spells.iterator();
		while(iterator.hasNext())
		{
			Spell spell = iterator.next();
			idArray[i] = spell.getID();
		}
		tag.setIntArray("Spells", idArray);
		tag.setInteger("level", this.level);
		return tag;
	}
	
	public void readFromNBT(NBTTagCompound tag)
	{
		int[] spellIDs = tag.getIntArray("Spells");
		for(int i = 0; i<spellIDs.length; i++)
		{
			this.spells.add(SpellHelper.getSpell(i));
		}
		this.level = tag.getInteger("level");
	}

}

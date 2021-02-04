package animecenter.blackclover.items;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import animecenter.blackclover.BlackClover;
import animecenter.blackclover.magic.GrimoireType;
import animecenter.blackclover.magic.MagicType;
import animecenter.blackclover.magic.Spell;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public abstract class GrimoireBaseV2 extends ItemBase 
{
	protected MagicType magicType;
	protected int GUI_ID;
	protected GrimoireType type;

	public GrimoireBaseV2(String name, CreativeTabs tab, MagicType type) 
	{
		super(name, tab);
		this.magicType = type;
		
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) 
	{
		ItemStack stack = playerIn.getHeldItem(handIn);
		NBTTagCompound tagP = playerIn.getEntityData();
		if(!worldIn.isRemote)
		{
			//create and attach tag if there is none
			if(!stack.hasTagCompound())
			{
				stack.setTagCompound(new NBTTagCompound());
			}
			
			NBTTagCompound tagI = stack.getTagCompound();
			
			//does the grimoire have an owner?
			if(tagI.hasKey("bcGrimoireOwner"))
			{
				//is it the player?
				if(tagI.getLong("bcGrimoireOwner") == playerIn.getPersistentID().getMostSignificantBits())
				{
					//playerIn.openGui(BlackClover.instance, GUI_ID, worldIn, (int)playerIn.posX, (int)playerIn.posY, (int)playerIn.posZ);
					BlackClover.proxy.openGrimoireGui(GUI_ID, playerIn.getEntityData().getInteger("bcLevel"), magicType);
					return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
				} 
				else
				{
					playerIn.sendMessage(new TextComponentString("This isn't your Grimoire!"));
					return new ActionResult<ItemStack>(EnumActionResult.PASS, stack);
				}
			} 
			//an empty grimoire, I wonder what we can do with it!
			else 
			{
				//you can't use multiple grimoires (yet)
				if(tagP.hasKey("isGrimoireOwner"))
				{
					playerIn.sendMessage(new TextComponentString("You can't use more than one Grimoire!"));
					return new ActionResult<ItemStack>(EnumActionResult.PASS, stack);
				}
				//assign this grimoire to the player
				else 
				{
					tagI.setLong("bcGrimoireOwner", playerIn.getPersistentID().getMostSignificantBits());
					tagP.setBoolean("isGrimoireOwner", true);
					return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
				}
			}
		}
		return new ActionResult<ItemStack>(EnumActionResult.FAIL, stack);
	}
		
	public void writeToNBT(NBTTagCompound tag)
	{
		tag.setString("bcMagicType", this.magicType.toString());
		tag.setInteger("bcGuiID", this.GUI_ID);
	}
		
	public void readFromNBT(NBTTagCompound tag)
	{
		this.magicType = MagicType.getTypeFromName(tag.getString("bcMagicType"));
		this.GUI_ID = tag.getInteger("bcGuiID");
	}
	
	public GrimoireBaseV2 setIdGui(int ID)
	{
		this.GUI_ID = ID;
		return this;
	}
	
	public GrimoireBaseV2 setType(MagicType type)
	{
		this.magicType = type;
		return this;
	}
	
	public MagicType getMagicType()
	{
		return this.magicType;
	}
	
	//redundant
	public ArrayList<Spell> getFilledLevelList(int level)
	{
		List<Spell> spells = new ArrayList<Spell>();
		Iterator<Spell> iterator = Spell.ALL_SPELLS.iterator();
		while(iterator.hasNext())
		{
			Spell spell = iterator.next();
			if(spell.getType() == this.magicType && spell.getRequiredLevel() <= level)
			{
				spells.add(spell);
			}
		}
		return (ArrayList<Spell>) spells;
	}
	
	//redundant
	public ArrayList<Spell> getFilledList()
	{
		List<Spell> spells = new ArrayList<Spell>();
		Iterator<Spell> iterator = Spell.ALL_SPELLS.iterator();
		while(iterator.hasNext())
		{
			Spell spell = iterator.next();
			if(spell.getType() == this.magicType)
			{
				spells.add(spell);
			}
		}
		return (ArrayList<Spell>) spells;
	}
		
}


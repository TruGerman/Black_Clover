package animecenter.blackclover.items;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import animecenter.blackclover.BlackClover;
import animecenter.blackclover.magic.GrimoireType;
import animecenter.blackclover.magic.MagicType;
import animecenter.blackclover.magic.Spell;
import net.minecraft.client.util.ITooltipFlag;
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
		setMaxStackSize(1);
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
			if(tagI.hasKey("bcLastMagic")) playerIn.sendMessage(new TextComponentString(tagI.getString("bcLastMagic")));
			//does the grimoire have an owner?
			if(tagI.hasKey("bcGrimoireOwner"))
			{
				//is it the player?
				if(tagI.getLong("bcGrimoireOwner") == playerIn.getPersistentID().getMostSignificantBits())
				{
					//playerIn.openGui(BlackClover.instance, GUI_ID, worldIn, (int)playerIn.posX, (int)playerIn.posY, (int)playerIn.posZ);
					BlackClover.proxy.openGrimoireGui(GUI_ID, playerIn.getEntityData().getInteger("bcLevel"), magicType, playerIn.getHeldItem(handIn));
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
					//I wonder if the unique and persistent id differ
					tagI.setLong("bcGrimoireOwner", playerIn.getPersistentID().getMostSignificantBits());
					tagI.setLong("bcGrimoireOwner2", playerIn.getPersistentID().getLeastSignificantBits());
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
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) 
	{
		if(!stack.hasTagCompound())
		{
			tooltip.add("Unowned");
		}
		else 
		{
			tooltip.add("Owner: " + worldIn.getPlayerEntityByUUID(new UUID(stack.getTagCompound().getLong("bcGrimoireOwner"), stack.getTagCompound().getLong("bcGrimoireOwner2"))).getName());
			if(!stack.getTagCompound().hasKey("bcLastMagic"))
			{
				tooltip.add("Selected: None");
			}
			else 
			{
			tooltip.add("Selected: " + stack.getTagCompound().getString("bcLastMagic"));
			}
		}
		
	}
		
}


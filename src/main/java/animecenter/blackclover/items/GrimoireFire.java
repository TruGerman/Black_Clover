package animecenter.blackclover.items;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import animecenter.blackclover.magic.MagicType;
import animecenter.blackclover.magic.Spell;
import animecenter.blackclover.util.Constants;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class GrimoireFire extends GrimoireBaseV2 
{

	public GrimoireFire(String name)
	{
		super(name, Constants.GRIMOIRES, MagicType.FIRE);
		setIdGui(Constants.GUI_GRIMOIRE_FIRE);
		
	}
	
	public List<Spell> getFilledList(int level)
	{
		List<Spell> spells = new ArrayList<Spell>();
		Iterator<Spell> iterator = Spell.ALL_SPELLS.iterator();
		while(iterator.hasNext())
		{
			Spell pogchamp = (Spell) iterator.next();
			if(pogchamp.getType() == this.magicType && pogchamp.getRequiredLevel()<=level)
			{
				spells.add(pogchamp);
			}
		}
		return spells;
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) 
	{
		if(!worldIn.isRemote)
		{
		return super.onItemRightClick(worldIn, playerIn, handIn);
		}
		return new ActionResult<ItemStack>(EnumActionResult.FAIL, playerIn.getHeldItem(handIn));
	}

}

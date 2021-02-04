package animecenter.blackclover.util.helpers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import animecenter.blackclover.magic.MagicType;
import animecenter.blackclover.magic.Spell;

public final class SpellHelper 
{

	public static Spell getSpell(int id)
	{
		return Spell.getMap().get(id);
	}
	
	public static ArrayList<Spell> getFilledLevelList(MagicType type, int level)
	{
		List<Spell> spells = new ArrayList<Spell>();
		Iterator<Spell> iterator = Spell.ALL_SPELLS.iterator();
		while(iterator.hasNext())
		{
			Spell spell = iterator.next();
			if(spell.getType() == type && spell.getRequiredLevel() <= level)
			{
				spells.add(spell);
			}
		}
		return (ArrayList<Spell>) spells;
	}
	
	public static ArrayList<Spell> getFilledList(MagicType type)
	{
		List<Spell> spells = new ArrayList<Spell>();
		Iterator<Spell> iterator = Spell.ALL_SPELLS.iterator();
		while(iterator.hasNext())
		{
			Spell spell = iterator.next();
			if(spell.getType() == type)
			{
				spells.add(spell);
			}
		}
		return (ArrayList<Spell>) spells;
	}
	
}

package animecenter.blackclover.magic;

import java.util.ArrayList;
import java.util.HashMap;

public class Spell
{
	protected int damage;
	protected int manaCost;
	protected MagicType magicType;
	protected String name;
	protected boolean isExplosive = false;
	protected boolean isGeneric = false;
	protected int radius = 0;
	private int requiredLevel = 0;
	//fucking genius level shit right there
	protected int id;
	public static final ArrayList<Spell> ALL_SPELLS = new ArrayList<>();
	protected static final HashMap<Integer, Spell> spellMap = new HashMap<>(); 
	public static final Spell FIREBALL = new Spell("FIREBALL", MagicType.FIRE, 1).setBaseDamage(2).setBaseManaCost(100).setRequiredLevel(5);
	public static final Spell FROSTSHARD = new Spell("FROSTSHARD", MagicType.ICE, 2).setBaseDamage(2).setBaseManaCost(100).setRequiredLevel(5);
	public static final Spell PUSH = new Spell("PUSH", MagicType.NONE, 3).setBaseDamage(0).setBaseManaCost(10).setGeneric();
	public static final Spell Fire_test = new Spell("Fire_test", MagicType.FIRE, 1).setBaseDamage(2).setBaseManaCost(100).setRequiredLevel(5);
	public static final Spell Fire_test2 = new Spell("Fire_test2", MagicType.FIRE, 1).setBaseDamage(2).setBaseManaCost(100).setRequiredLevel(5);
	public static final Spell Fire_test3 = new Spell("Fire_test3", MagicType.FIRE, 1).setBaseDamage(2).setBaseManaCost(100).setRequiredLevel(25);
	
	public Spell(String name, MagicType type, int id)
	{
		this.name = name;
		this.magicType = type;
		this.id = id;
		ALL_SPELLS.add(this);
		spellMap.put(id, this);
	}
	
	public Spell setBaseDamage(int damage)
	{
		this.damage = damage;
		return this;
	}
	
	public Spell setBaseManaCost(int cost)
	{
		this.manaCost = cost;
		return this;
	}
	
	public int getDamage()
	{
		return this.damage;
	}
	
	public int getManaCost()
	{
		return this.manaCost;
	}
	
	public MagicType getType()
	{
		return this.magicType;
	}
	
	public static HashMap<Integer, Spell> getMap()
	{
		return spellMap;
	}
	
	public int getID()
	{
		return this.id;
	}
	
	public int getRequiredLevel() 
	{
		return this.requiredLevel;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	@Override
	public String toString() 
	{
		return this.name;
	}
	
	public Spell setExplosive()
	{
		this.isExplosive = true;
		return this;
	}
	
	public Spell setRadius(int radius)
	{
		this.radius = radius;
		return this;
	}
	
	public Spell setGeneric()
	{
		this.isGeneric = true;
		return this;
	}
	
	public Spell setRequiredLevel(int requiredLevel) 
	{
		this.requiredLevel = requiredLevel;
		return this;
	}
	

}

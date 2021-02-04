package animecenter.blackclover.magic;

public enum MagicType 
{
	FIRE("fire"), 
	WATER("water"), 
	POISON("poison"),
	TIME("time"),
	ANTI("anti"),
	ICE("ice"), 
	NONE("none");
	
	String name;
	
	private MagicType(String string) 
	{
		string = name;
	}
	
	public static MagicType getTypeFromName(String name)
	{
		for(MagicType type : MagicType.values())
		{
			if(type.name.equals(name)) return type;
		}
		return null;
		
	}
	//eh
	public boolean isDevilMagic(MagicType type)
	{
		switch(type) 
		{
		case ANTI:
			return true;
		}
		return false;
	}
}

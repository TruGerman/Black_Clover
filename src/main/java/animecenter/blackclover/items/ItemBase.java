package animecenter.blackclover.items;

import animecenter.blackclover.BlackClover;
import animecenter.blackclover.util.Constants;
import animecenter.blackclover.util.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel
{

	public ItemBase(String name) 
	{
		this(name, Constants.MAIN_TAB);
	}

	public ItemBase(String name, CreativeTabs tab) 
	{
		super();
		setRegistryName(name);
		setUnlocalizedName(name);
		setCreativeTab(tab);
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() 
	{
		BlackClover.proxy.registerModel(this, 0);
	}

}

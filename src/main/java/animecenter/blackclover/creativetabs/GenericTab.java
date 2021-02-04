package animecenter.blackclover.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class GenericTab extends CreativeTabs
{
protected Item item;
	
	public GenericTab(String name)
	{
		this(name, Items.IRON_INGOT);
	}

	public GenericTab(String name, Item item) 
	{
		super(name);
		this.item = item;
	}
	
	public GenericTab(String name, Item item, String texture)
	{
		this(name, item);
		setBackgroundImageName(texture);
	}

	@Override
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(item);
	}

}

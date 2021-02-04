package animecenter.blackclover.blocks;

import animecenter.blackclover.items.ModItems;
import animecenter.blackclover.util.Constants;
import animecenter.blackclover.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public abstract class BlockBase extends Block implements IHasModel
{
	
	public BlockBase(String name) 
	{
		this(name, Material.IRON, Constants.MAIN_TAB);
	}
	
	public BlockBase(String name, Material material) 
	{
		this(name, material, Constants.MAIN_TAB);
	}

	public BlockBase(String name, Material materialIn, CreativeTabs tab) 
	{
		super(materialIn);
		setRegistryName(name);
		setUnlocalizedName(name);
		setCreativeTab(tab);
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(Item.getItemFromBlock(this).setRegistryName(this.getRegistryName()).setCreativeTab(tab));
		
	}



}

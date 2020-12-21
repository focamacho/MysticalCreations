package com.focamacho.mysticalcreations.items;

import com.blakebr0.mysticalagriculture.MysticalAgriculture;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;

public class ItemEssence extends Item {

	private final String name;
	
	public ItemEssence(String name) {
		this.setRegistryName(name + "_essence");
		this.setUnlocalizedName(name + "_essence");
		this.setCreativeTab(MysticalAgriculture.CREATIVE_TAB);
		this.name = name;
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		String nameFinal = "";
		nameFinal += I18n.translateToLocal("item.mysticalcreations.essence.name.before");
		String[] name = this.name.split("_");
		if(name.length > 1) {
			for(String string : name) {
				nameFinal += string.substring(0, 1).toUpperCase() + string.substring(1) + " ";
			}
		} else {
			nameFinal = name[0].substring(0, 1).toUpperCase() + name[0].substring(1) + " ";
		}
		nameFinal += I18n.translateToLocal("item.mysticalcreations.essence.name");
		return nameFinal;
	}

}

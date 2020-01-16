package com.focamacho.mysticalcreations.lib;

import javax.annotation.Nullable;

import com.focamacho.mysticalcreations.blocks.BlockCrop;
import com.focamacho.mysticalcreations.init.ModBlocks;
import com.focamacho.mysticalcreations.init.ModItems;
import com.focamacho.mysticalcreations.items.ItemChunk;
import com.focamacho.mysticalcreations.items.ItemEssence;
import com.focamacho.mysticalcreations.items.ItemSeed;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.EntityEntry;

public class CustomSeed {

	private BlockCrop crop;
	private Item itemCrop;
	private ItemEssence essence;
	private ItemSeed seed;
	private String name;
	private int tier;
	private int color;
	private ItemStack crux;
	private ItemChunk chunk;
	private EntityEntry entity;
	
	public CustomSeed(String name, Integer tier, Integer color, @Nullable ItemStack crux, @Nullable EntityEntry entity) {
		BlockCrop crop = new BlockCrop(name, crux, tier);
		ItemEssence essence = new ItemEssence(name, color);
		ItemSeed seed = new ItemSeed(name, crop, tier, color);
		ItemChunk chunk = new ItemChunk(name, tier, color);
		crop.setSeed(seed);
		crop.setEssence(essence);
		this.itemCrop = crop.getItemCrop();
		ModBlocks.BLOCKS.add(crop);
		ModItems.ITEMS.add(itemCrop);
		ModItems.ITEMS.add(essence);
		ModItems.ITEMS.add(seed);
		if(entity != null) ModItems.ITEMS.add(chunk);
		this.name = name;
		this.crop = crop;
		this.essence = essence;
		this.seed = seed;
		this.tier = tier;
		this.color = color;
		this.entity = entity;
		if(crux != null) this.crux = crux;
		else crux = null;
		if(entity != null) {
			this.chunk = chunk;
			CustomSeeds.chunkSeeds.add(this);
		}
		else this.chunk = null;
		CustomSeeds.allSeeds.add(this);
	}
	
	public int getTier() {
		return this.tier;
	}
	
	public BlockCrop getCrop() {
		return this.crop;
	}
	
	public ItemSeed getSeed() {
		return this.seed;
	}
	
	public ItemEssence getEssence() {
		return this.essence;
	}

	public int getColor() {
		return this.color;
	}

	public Item getItemCrop() {
		return this.itemCrop;
	}
	
	public String getName() {
		return this.name;
	}
	
	public ItemStack getCrux() {
		return this.crux;
	}
	
	public ItemChunk getChunk() {
		return this.chunk;
	}
	
	public EntityEntry getEntity() {
		return this.entity;
	}
}
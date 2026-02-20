package com.narxoz.rpg.loot;

import java.util.Arrays;
import java.util.List;

public class ShadowLootTable implements LootTable {
    private List<String> items;
    private int goldDrop;
    private int experienceDrop;
    
    public ShadowLootTable() {
        this.items = Arrays.asList("Shadow Gem", "Dark Essence", "Shadow Rune", "Void Crystal", "Umbral Core");
        this.goldDrop = 600;
        this.experienceDrop = 1100;
    }
    
    @Override
    public List<String> getItems() {
        return items;
    }
    
    @Override
    public int getGoldDrop() {
        return goldDrop;
    }
    
    @Override
    public int getExperienceDrop() {
        return experienceDrop;
    }
    
    @Override
    public String getLootInfo() {
        return String.format("Items: %s | Gold: %d | XP: %d", 
            String.join(", ", items), goldDrop, experienceDrop);
    }
    
    @Override
    public LootTable clone() {
        ShadowLootTable clone = new ShadowLootTable();
        clone.items = List.copyOf(this.items);
        clone.goldDrop = this.goldDrop;
        clone.experienceDrop = this.experienceDrop;
        return clone;
    }
}
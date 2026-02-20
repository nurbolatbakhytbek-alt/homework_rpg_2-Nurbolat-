package com.narxoz.rpg.loot;

import java.util.Arrays;
import java.util.List;

public class FireLootTable implements LootTable {
    private List<String> items;
    private int goldDrop;
    private int experienceDrop;
    
    public FireLootTable() {
        this.items = Arrays.asList("Fire Gem", "Dragon Scale", "Flame Rune", "Ember Crystal", "Magma Core");
        this.goldDrop = 500;
        this.experienceDrop = 1000;
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
        FireLootTable clone = new FireLootTable();
        clone.items = List.copyOf(this.items);
        clone.goldDrop = this.goldDrop;
        clone.experienceDrop = this.experienceDrop;
        return clone;
    }
}
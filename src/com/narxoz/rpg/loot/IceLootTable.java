package com.narxoz.rpg.loot;

import java.util.Arrays;
import java.util.List;

public class IceLootTable implements LootTable {
    private List<String> items;
    private int goldDrop;
    private int experienceDrop;
    
    public IceLootTable() {
        this.items = Arrays.asList("Ice Gem", "Frost Scale", "Ice Rune", "Frozen Heart", "Permafrost Shard");
        this.goldDrop = 450;
        this.experienceDrop = 950;
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
        IceLootTable clone = new IceLootTable();
        clone.items = List.copyOf(this.items);
        clone.goldDrop = this.goldDrop;
        clone.experienceDrop = this.experienceDrop;
        return clone;
    }
}
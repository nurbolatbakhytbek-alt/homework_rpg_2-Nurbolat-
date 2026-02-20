package com.narxoz.rpg.factory;

import com.narxoz.rpg.combat.*;
import com.narxoz.rpg.loot.*;
import java.util.List;
import java.util.Arrays;

public class IceComponentFactory implements EnemyComponentFactory {
    
    @Override
    public List<Ability> createAbilities() {
        return Arrays.asList(
            new FrostBreath(),
            new IceShield(),
            new Blizzard()
        );
    }
    
    @Override
    public LootTable createLootTable() {
        return new IceLootTable();
    }
    
    @Override
    public String createAIBehavior() {
        return "DEFENSIVE - Keeps distance, uses shields, attacks from range, retreats when damaged";
    }
}
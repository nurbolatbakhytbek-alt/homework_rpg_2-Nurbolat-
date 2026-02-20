package com.narxoz.rpg.factory;

import com.narxoz.rpg.combat.*;
import com.narxoz.rpg.loot.*;
import java.util.List;
import java.util.Arrays;

public class FireComponentFactory implements EnemyComponentFactory {
    
    @Override
    public List<Ability> createAbilities() {
        return Arrays.asList(
            new FlameBreath(),
            new FireShield(),
            new MeteorStorm()
        );
    }
    
    @Override
    public LootTable createLootTable() {
        return new FireLootTable();
    }
    
    @Override
    public String createAIBehavior() {
        return "AGGRESSIVE - Charges headfirst, uses high-damage abilities, never retreats";
    }
}
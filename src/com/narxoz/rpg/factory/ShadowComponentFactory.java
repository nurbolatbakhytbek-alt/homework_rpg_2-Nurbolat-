package com.narxoz.rpg.factory;

import com.narxoz.rpg.combat.*;
import com.narxoz.rpg.loot.*;
import java.util.List;
import java.util.Arrays;

public class ShadowComponentFactory implements EnemyComponentFactory {
    
    @Override
    public List<Ability> createAbilities() {
        return Arrays.asList(
            new ShadowStrike(),
            new Vanish(),
            new DarkNova()
        );
    }
    
    @Override
    public LootTable createLootTable() {
        return new ShadowLootTable();
    }
    
    @Override
    public String createAIBehavior() {
        return "TACTICAL - Uses stealth, strikes from shadows, targets weakened enemies, uses hit-and-run tactics";
    }
}
package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.List;

public interface Enemy {
    String getName();
    int getHealth();
    int getDamage();
    int getDefense();
    int getSpeed();
    String getElement();
    List<Ability> getAbilities();
    void addAbility(Ability ability);
    LootTable getLootTable();
    void setLootTable(LootTable lootTable);
    String getAIBehavior();
    void setAIBehavior(String aiBehavior);
    void displayInfo();
    void multiplyStats(double multiplier);
    void setElement(String element);
    Enemy clone();
}
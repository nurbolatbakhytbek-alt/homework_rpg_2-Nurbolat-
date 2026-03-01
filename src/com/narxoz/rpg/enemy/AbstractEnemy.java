package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractEnemy implements Enemy, Cloneable {
    protected String name;
    protected int health;
    protected int damage;
    protected int defense;
    protected int speed;
    protected String element;
    protected List<Ability> abilities;
    protected LootTable lootTable;
    protected String aiBehavior;

    public AbstractEnemy(String name) {
        this.name = name;
        this.abilities = new ArrayList<>();
        this.element = "NONE";
    }

   
    @Override
    public String getName() { return name; }

    @Override
    public int getHealth() { return health; }

    @Override
    public int getDamage() { return damage; }

    @Override
    public int getDefense() { return defense; }

    @Override
    public int getSpeed() { return speed; }

    @Override
    public String getElement() { return element; }

    @Override
    public List<Ability> getAbilities() { return abilities; }

    @Override
    public void addAbility(Ability ability) { abilities.add(ability); }

    @Override
    public LootTable getLootTable() { return lootTable; }

    @Override
    public void setLootTable(LootTable lootTable) { this.lootTable = lootTable; }

    @Override
    public String getAIBehavior() { return aiBehavior; }

    @Override
    public void setAIBehavior(String aiBehavior) { this.aiBehavior = aiBehavior; }

    @Override
    public void setElement(String element) { this.element = element; }

    @Override
    public void multiplyStats(double multiplier) {
        this.health = (int)(this.health * multiplier);
        this.damage = (int)(this.damage * multiplier);
        this.defense = (int)(this.defense * multiplier);
        this.speed = (int)(this.speed * multiplier);
    }

    
    @Override
    public AbstractEnemy clone() {
        try {
            return (AbstractEnemy) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning not supported", e);
        }
    }
}

package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.DragonBoss;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.loot.LootTable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BossEnemyBuilder implements EnemyBuilder {
    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;
    private String element;
    private List<Ability> abilities;
    private Map<Integer, Integer> phases;
    private LootTable lootTable;
    private String aiBehavior;
    private boolean canFly;
    private boolean hasBreathAttack;
    private int wingspan;
    
    public BossEnemyBuilder() {
        this.abilities = new ArrayList<>();
        this.phases = new HashMap<>();
        this.canFly = true;
        this.hasBreathAttack = true;
        this.wingspan = 20;
    }
    
    @Override
    public EnemyBuilder setName(String name) {
        this.name = name;
        return this;
    }
    
    @Override
    public EnemyBuilder setHealth(int health) {
        this.health = health;
        return this;
    }
    
    @Override
    public EnemyBuilder setDamage(int damage) {
        this.damage = damage;
        return this;
    }
    
    @Override
    public EnemyBuilder setDefense(int defense) {
        this.defense = defense;
        return this;
    }
    
    @Override
    public EnemyBuilder setSpeed(int speed) {
        this.speed = speed;
        return this;
    }
    
    @Override
    public EnemyBuilder setElement(String element) {
        this.element = element;
        return this;
    }
    
    @Override
    public EnemyBuilder addAbility(Ability ability) {
        this.abilities.add(ability);
        return this;
    }
    
    @Override
    public EnemyBuilder setAbilities(List<Ability> abilities) {
        this.abilities = new ArrayList<>(abilities);
        return this;
    }
    
    @Override
    public EnemyBuilder addPhase(int phaseNumber, int healthThreshold) {
        this.phases.put(phaseNumber, healthThreshold);
        return this;
    }
    
    @Override
    public EnemyBuilder setLootTable(LootTable loot) {
        this.lootTable = loot;
        return this;
    }
    
    @Override
    public EnemyBuilder setAI(String aiBehavior) {
        this.aiBehavior = aiBehavior;
        return this;
    }
    
    public BossEnemyBuilder setCanFly(boolean canFly) {
        this.canFly = canFly;
        return this;
    }
    
    public BossEnemyBuilder setHasBreathAttack(boolean hasBreathAttack) {
        this.hasBreathAttack = hasBreathAttack;
        return this;
    }
    
    public BossEnemyBuilder setWingspan(int wingspan) {
        this.wingspan = wingspan;
        return this;
    }
    
    @Override
    public Enemy build() {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalStateException("Boss name is required!");
        }
        if (health <= 0) {
            throw new IllegalStateException("Health must be positive!");
        }
        if (phases.isEmpty()) {
            throw new IllegalStateException("Boss must have at least one phase!");
        }
        
        DragonBoss enemy = new DragonBoss(name);
        enemy.health = this.health;
        enemy.damage = this.damage;
        enemy.defense = this.defense;
        enemy.speed = this.speed;
        enemy.element = this.element != null ? this.element : "NONE";
        enemy.abilities = new ArrayList<>(this.abilities);
        enemy.setPhases(this.phases);
        enemy.lootTable = this.lootTable;
        enemy.aiBehavior = this.aiBehavior != null ? this.aiBehavior : "BOSS";
        enemy.setCanFly(this.canFly);
        enemy.setHasBreathAttack(this.hasBreathAttack);
        enemy.setWingspan(this.wingspan);
        
        return enemy;
    }
}
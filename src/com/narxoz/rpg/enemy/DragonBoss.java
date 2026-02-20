package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DragonBoss extends AbstractEnemy {
    private Map<Integer, Integer> phases;
    private boolean canFly;
    private boolean hasBreathAttack;
    private int wingspan;
    
    public DragonBoss(String name) {
        super(name);
        this.phases = new HashMap<>();
        this.canFly = true;
        this.hasBreathAttack = true;
        this.wingspan = 20;
    }
    
    public void setPhases(Map<Integer, Integer> phases) {
        this.phases = new HashMap<>(phases);
    }
    
    public void addPhase(int phaseNumber, int healthThreshold) {
        this.phases.put(phaseNumber, healthThreshold);
    }
    
    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }
    
    public void setHasBreathAttack(boolean hasBreathAttack) {
        this.hasBreathAttack = hasBreathAttack;
    }
    
    public void setWingspan(int wingspan) {
        this.wingspan = wingspan;
    }
    
    @Override
    public void displayInfo() {
        System.out.println("=== " + name + " (Dragon Boss) ===");
        System.out.println("Health: " + health + " | Damage: " + damage 
                + " | Defense: " + defense + " | Speed: " + speed);
        System.out.println("Element: " + element);
        System.out.println("AI: " + aiBehavior);
        System.out.println("Abilities (" + abilities.size() + "):");
        for (Ability ability : abilities) {
            System.out.println("  - " + ability.getName() + ": " + ability.getDescription());
        }
        System.out.println("Boss Phases (" + phases.size() + "):");
        for (Map.Entry<Integer, Integer> phase : phases.entrySet()) {
            System.out.println("  Phase " + phase.getKey() + ": triggers at " + phase.getValue() + " HP");
        }
        System.out.println("Special: " + (canFly ? "Can Fly" : "Cannot Fly") 
                + " | " + (hasBreathAttack ? "Has Breath Attack" : "No Breath Attack")
                + " | Wingspan: " + wingspan + "m");
        if (lootTable != null) {
            System.out.println("Loot: " + lootTable.getLootInfo());
        }
    }
    
    @Override
    public Enemy clone() {
        DragonBoss clone = new DragonBoss(this.name);
        clone.health = this.health;
        clone.damage = this.damage;
        clone.defense = this.defense;
        clone.speed = this.speed;
        clone.element = this.element;
        clone.aiBehavior = this.aiBehavior;
        clone.canFly = this.canFly;
        clone.hasBreathAttack = this.hasBreathAttack;
        clone.wingspan = this.wingspan;
        clone.abilities = new ArrayList<>();
        for (Ability ability : this.abilities) {
            clone.abilities.add(ability.clone());
        }
        clone.phases = new HashMap<>(this.phases);
        if (this.lootTable != null) {
            clone.lootTable = this.lootTable.clone();
        }
        return clone;
    }
}
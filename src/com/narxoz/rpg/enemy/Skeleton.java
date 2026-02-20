package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import java.util.ArrayList;

public class Skeleton extends AbstractEnemy {
    
    public Skeleton(String name) {
        super(name);
        this.health = 80;
        this.damage = 20;
        this.defense = 10;
        this.speed = 25;
        this.aiBehavior = "UNDEAD - Resists physical damage, vulnerable to magic";
    }
    
    @Override
    public void displayInfo() {
        System.out.println("=== " + name + " (Skeleton) ===");
        System.out.println("Health: " + health + " | Damage: " + damage 
                + " | Defense: " + defense + " | Speed: " + speed);
        System.out.println("Element: " + element);
        System.out.println("AI: " + aiBehavior);
        System.out.println("Abilities (" + abilities.size() + "):");
        for (Ability ability : abilities) {
            System.out.println("  - " + ability.getName() + ": " + ability.getDescription());
        }
        if (lootTable != null) {
            System.out.println("Loot: " + lootTable.getLootInfo());
        }
    }
    
    @Override
    public Enemy clone() {
        Skeleton clone = new Skeleton(this.name);
        clone.health = this.health;
        clone.damage = this.damage;
        clone.defense = this.defense;
        clone.speed = this.speed;
        clone.element = this.element;
        clone.aiBehavior = this.aiBehavior;
        clone.abilities = new ArrayList<>();
        for (Ability ability : this.abilities) {
            clone.abilities.add(ability.clone());
        }
        if (this.lootTable != null) {
            clone.lootTable = this.lootTable.clone();
        }
        return clone;
    }
}
package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import java.util.ArrayList;
import java.util.List;

public class Goblin extends AbstractEnemy {
    
    public Goblin(String name) {
        super(name);
        this.health = 100;
        this.damage = 15;
        this.defense = 5;
        this.speed = 35;
        this.aiBehavior = "BASIC - Simple attack patterns";
    }
    
    @Override
    public void displayInfo() {
        System.out.println("=== " + name + " (Goblin) ===");
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
    public AbstractEnemy clone() {
        Goblin clone = new Goblin(this.name);
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

    @Override
    public void setName(String string) {
        
        throw new UnsupportedOperationException("Unimplemented method 'setName'");
    }

    @Override
    public void setAbilities(List<Ability> abilities) {
        
        throw new UnsupportedOperationException("Unimplemented method 'setAbilities'");
    }
}
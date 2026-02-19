package com.narxoz.rpg.combat;

public class Vanish implements Ability {
    private String name;
    private int damage;
    private String description;
    
    public Vanish() {
        this.name = "Vanish";
        this.damage = 0;
        this.description = "Disappears into the shadows, becoming untargetable for 2 turns and increasing next attack damage";
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public int getDamage() {
        return damage;
    }
    
    @Override
    public String getDescription() {
        return description;
    }
    
    @Override
    public Ability clone() {
        Vanish clone = new Vanish();
        clone.name = this.name;
        clone.damage = this.damage;
        clone.description = this.description;
        return clone;
    }
}
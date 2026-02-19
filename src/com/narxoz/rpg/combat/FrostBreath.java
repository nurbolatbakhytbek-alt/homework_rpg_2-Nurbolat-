package com.narxoz.rpg.combat;

public class FrostBreath implements Ability {
    private String name;
    private int damage;
    private String description;
    
    public FrostBreath() {
        this.name = "Frost Breath";
        this.damage = 45;
        this.description = "Exhales freezing air, dealing damage and slowing enemy movement by 50% for 3 turns";
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
        FrostBreath clone = new FrostBreath();
        clone.name = this.name;
        clone.damage = this.damage;
        clone.description = this.description;
        return clone;
    }
}
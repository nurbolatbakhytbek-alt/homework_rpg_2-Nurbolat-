package com.narxoz.rpg.combat;

public class MeteorStorm implements Ability {
    private String name;
    private int damage;
    private String description;
    
    public MeteorStorm() {
        this.name = "Meteor Storm";
        this.damage = 150;
        this.description = "Calls down meteors from the sky, dealing massive AoE damage and leaving burning ground";
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
        MeteorStorm clone = new MeteorStorm();
        clone.name = this.name;
        clone.damage = this.damage;
        clone.description = this.description;
        return clone;
    }
}
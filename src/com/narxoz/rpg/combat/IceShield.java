package com.narxoz.rpg.combat;

public class IceShield implements Ability {
    private String name;
    private int damage;
    private String description;
    
    public IceShield() {
        this.name = "Ice Shield";
        this.damage = 0;
        this.description = "Forms a protective layer of ice, absorbing 40% of incoming damage and chilling attackers";
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
        IceShield clone = new IceShield();
        clone.name = this.name;
        clone.damage = this.damage;
        clone.description = this.description;
        return clone;
    }
}
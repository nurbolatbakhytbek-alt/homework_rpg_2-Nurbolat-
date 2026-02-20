package com.narxoz.rpg.builder;

import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.factory.EnemyComponentFactory;

public class EnemyDirector {
    private EnemyBuilder builder;
    
    public EnemyDirector(EnemyBuilder builder) {
        this.builder = builder;
    }
    
    public Enemy createMinion(EnemyComponentFactory factory) {
        return builder
            .setName("Minion")
            .setHealth(50)
            .setDamage(10)
            .setDefense(2)
            .setSpeed(20)
            .setElement(factory.createAIBehavior().split(" ")[0])
            .setAbilities(factory.createAbilities())
            .setLootTable(factory.createLootTable())
            .setAI(factory.createAIBehavior())
            .build();
    }
    
    public Enemy createElite(EnemyComponentFactory factory) {
        return builder
            .setName("Elite Warrior")
            .setHealth(200)
            .setDamage(35)
            .setDefense(15)
            .setSpeed(40)
            .setElement(factory.createAIBehavior().split(" ")[0])
            .setAbilities(factory.createAbilities())
            .setLootTable(factory.createLootTable())
            .setAI(factory.createAIBehavior())
            .build();
    }
    
    public Enemy createMiniBoss(EnemyComponentFactory factory) {
        return builder
            .setName("Mini Boss")
            .setHealth(1000)
            .setDamage(80)
            .setDefense(40)
            .setSpeed(50)
            .setElement(factory.createAIBehavior().split(" ")[0])
            .setAbilities(factory.createAbilities())
            .addPhase(1, 1000)
            .addPhase(2, 500)
            .setLootTable(factory.createLootTable())
            .setAI(factory.createAIBehavior())
            .build();
    }
    
    public Enemy createRaidBoss(EnemyComponentFactory factory) {
        return builder
            .setName("Raid Boss")
            .setHealth(50000)
            .setDamage(500)
            .setDefense(200)
            .setSpeed(30)
            .setElement(factory.createAIBehavior().split(" ")[0])
            .setAbilities(factory.createAbilities())
            .addPhase(1, 50000)
            .addPhase(2, 30000)
            .addPhase(3, 15000)
            .addPhase(4, 5000)
            .setLootTable(factory.createLootTable())
            .setAI(factory.createAIBehavior())
            .build();
    }
}
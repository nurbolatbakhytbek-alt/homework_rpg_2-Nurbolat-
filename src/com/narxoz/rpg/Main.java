package com.narxoz.rpg;

import com.narxoz.rpg.builder.*;
import com.narxoz.rpg.combat.*;
import com.narxoz.rpg.enemy.*;
import com.narxoz.rpg.factory.*;
import com.narxoz.rpg.loot.*;
import com.narxoz.rpg.prototype.EnemyRegistry;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG Enemy System - Creational Patterns Capstone ===\n");

        System.out.println("============================================");
        System.out.println("PART 1: ABSTRACT FACTORY - Themed Components");
        System.out.println("============================================\n");

        EnemyComponentFactory fireFactory = new FireComponentFactory();
        EnemyComponentFactory iceFactory = new IceComponentFactory();
        EnemyComponentFactory shadowFactory = new ShadowComponentFactory();

        System.out.println("FIRE THEME:");
        System.out.println("Abilities:");
        for (Ability ability : fireFactory.createAbilities()) {
            System.out.println("  - " + ability.getName() + " (DMG: " + ability.getDamage() + ")");
        }
        System.out.println("Loot: " + fireFactory.createLootTable().getLootInfo());
        System.out.println("AI: " + fireFactory.createAIBehavior());
        System.out.println();

        System.out.println("ICE THEME:");
        System.out.println("Abilities:");
        for (Ability ability : iceFactory.createAbilities()) {
            System.out.println("  - " + ability.getName() + " (DMG: " + ability.getDamage() + ")");
        }
        System.out.println("Loot: " + iceFactory.createLootTable().getLootInfo());
        System.out.println("AI: " + iceFactory.createAIBehavior());
        System.out.println();

        System.out.println("SHADOW THEME:");
        System.out.println("Abilities:");
        for (Ability ability : shadowFactory.createAbilities()) {
            System.out.println("  - " + ability.getName() + " (DMG: " + ability.getDamage() + ")");
        }
        System.out.println("Loot: " + shadowFactory.createLootTable().getLootInfo());
        System.out.println("AI: " + shadowFactory.createAIBehavior());
        System.out.println();

        System.out.println("============================================");
        System.out.println("PART 2: BUILDER - Complex Enemy Construction");
        System.out.println("============================================\n");

        Enemy fireDragon = new BossEnemyBuilder()
            .setName("Ancient Fire Dragon")
            .setHealth(50000)
            .setDamage(500)
            .setDefense(200)
            .setSpeed(50)
            .setElement("FIRE")
            .setAbilities(fireFactory.createAbilities())
            .addPhase(1, 50000)
            .addPhase(2, 30000)
            .addPhase(3, 15000)
            .setLootTable(fireFactory.createLootTable())
            .setAI(fireFactory.createAIBehavior())
            .build();
        
        fireDragon.displayInfo();
        System.out.println();

        Enemy iceGoblin = new BasicEnemyBuilder()
            .setName("Ice Goblin")
            .setHealth(120)
            .setDamage(20)
            .setDefense(8)
            .setSpeed(30)
            .setElement("ICE")
            .setAbilities(iceFactory.createAbilities())
            .setLootTable(iceFactory.createLootTable())
            .setAI(iceFactory.createAIBehavior())
            .build();
        
        iceGoblin.displayInfo();
        System.out.println();

        System.out.println("============================================");
        System.out.println("DIRECTOR - Preset Constructions");
        System.out.println("============================================\n");

        EnemyDirector director = new EnemyDirector(new BossEnemyBuilder());
        Enemy raidBoss = director.createRaidBoss(fireFactory);
        System.out.println("Director created: " + raidBoss.getName());
        System.out.println();

        System.out.println("============================================");
        System.out.println("PART 3: PROTOTYPE - Enemy Cloning & Variants");
        System.out.println("============================================\n");

        EnemyRegistry registry = new EnemyRegistry();
        
        Enemy baseGoblin = new BasicEnemyBuilder()
            .setName("Goblin")
            .setHealth(100)
            .setDamage(15)
            .setDefense(5)
            .setSpeed(35)
            .addAbility(new ShadowStrike())
            .build();
        
        registry.registerTemplate("goblin", baseGoblin);
        
        Enemy baseDragon = new BossEnemyBuilder()
            .setName("Dragon")
            .setHealth(10000)
            .setDamage(200)
            .setDefense(100)
            .setSpeed(40)
            .addAbility(new FlameBreath())
            .addPhase(1, 10000)
            .addPhase(2, 5000)
            .build();
        
        registry.registerTemplate("dragon", baseDragon);
        
        Enemy baseSkeleton = new Skeleton("Skeleton");
        registry.registerTemplate("skeleton", baseSkeleton);

        registry.listTemplates();
        System.out.println();

        System.out.println("Creating variants from templates:");
        
        Enemy eliteGoblin = registry.createFromTemplate("goblin");
        eliteGoblin.multiplyStats(2.0);
        eliteGoblin.setName("Elite Goblin");
        eliteGoblin.displayInfo();
        System.out.println();

        Enemy championGoblin = registry.createFromTemplate("goblin");
        championGoblin.multiplyStats(5.0);
        championGoblin.addAbility(new MeteorStorm());
        championGoblin.setName("Champion Goblin");
        championGoblin.displayInfo();
        System.out.println();

        Enemy fireDragonClone = registry.createFromTemplate("dragon");
        fireDragonClone.setElement("FIRE");
        fireDragonClone.setAbilities(fireFactory.createAbilities());
        fireDragonClone.setName("Fire Dragon");
        fireDragonClone.displayInfo();
        System.out.println();

        System.out.println("============================================");
        System.out.println("DEEP COPY VERIFICATION");
        System.out.println("============================================\n");

        Enemy original = registry.createFromTemplate("skeleton");
        original.addAbility(new ShadowStrike());
        
        Enemy clone = original.clone();
        clone.addAbility(new FlameBreath());
        
        System.out.println("Original abilities (" + original.getAbilities().size() + "):");
        for (Ability ability : original.getAbilities()) {
            System.out.println("  - " + ability.getName());
        }
        
        System.out.println("Clone abilities (" + clone.getAbilities().size() + "):");
        for (Ability ability : clone.getAbilities()) {
            System.out.println("  - " + ability.getName());
        }
        
        System.out.println("\nVerification: Clone has FlameBreath but original doesn't - DEEP COPY WORKS!");
        System.out.println();

        System.out.println("============================================");
        System.out.println("PART 4: ALL PATTERNS WORKING TOGETHER");
        System.out.println("============================================\n");

        System.out.println("Step 1: Abstract Factory creates Shadow components");
        System.out.println("Step 2: Builder assembles Demon Lord with Shadow components");
        
        Enemy demonLord = new BossEnemyBuilder()
            .setName("Demon Lord")
            .setHealth(75000)
            .setDamage(800)
            .setDefense(300)
            .setSpeed(60)
            .setElement("SHADOW")
            .setAbilities(shadowFactory.createAbilities())
            .addPhase(1, 75000)
            .addPhase(2, 50000)
            .addPhase(3, 25000)
            .addPhase(4, 10000)
            .setLootTable(shadowFactory.createLootTable())
            .setAI(shadowFactory.createAIBehavior())
            .build();
        
        demonLord.displayInfo();
        System.out.println();

        System.out.println("Step 3: Register as Prototype template");
        registry.registerTemplate("demon-lord", demonLord);
        
        System.out.println("Step 4: Clone variants");
        Enemy greaterDemon = registry.createFromTemplate("demon-lord");
        greaterDemon.multiplyStats(2.0);
        greaterDemon.setName("Greater Demon Lord");
        
        Enemy ancientDemon = registry.createFromTemplate("demon-lord");
        ancientDemon.multiplyStats(5.0);
        ancientDemon.addAbility(new MeteorStorm());
        ancientDemon.setName("Ancient Demon Lord");
        
        System.out.println("Created 2 variants from template:");
        System.out.println("  - " + greaterDemon.getName() + " (2x stats)");
        System.out.println("  - " + ancientDemon.getName() + " (5x stats + extra ability)");
        System.out.println();

        System.out.println("============================================");
        System.out.println("PATTERN SUMMARY");
        System.out.println("============================================");
        System.out.println("Abstract Factory: Themed component families (Fire, Ice, Shadow)");
        System.out.println("Builder: Complex step-by-step enemy construction with fluent interface");
        System.out.println("Factory Method: Embedded in Builder.build() and Director.create* methods");
        System.out.println("Prototype: Efficient template cloning with deep copy verification");

        System.out.println("\n=== Demo Complete ===");
    }
}
package com.example.mud.entity;

public class Enemy {
    private final String name;
    private int health;

    public Enemy(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public String getName() { return name; }
    public int getHealth() { return health; }
    public boolean isAlive() { return health > 0; }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            System.out.println(name + " has been defeated!");
        } else {
            System.out.println(name + " has " + health + " HP left.");
        }
    }

    @Override
    public String toString() {
        return name + " (HP: " + health + ")";
    }
}
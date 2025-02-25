package com.example.mud.game;

import com.example.mud.entity.Enemy;
import java.util.*;

public class Room {
    private final String name;
    private final String description;
    private final Map<String, Room> exits;
    private final List<Item> items;
    private final List<Enemy> enemies; // New: List of enemies

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.exits = new HashMap<>();
        this.items = new ArrayList<>();
        this.enemies = new ArrayList<>();
    }

    public void setExit(String direction, Room room) { exits.put(direction, room); }
    public Room getExit(String direction) { return exits.get(direction); }

    public String getName() { return name; }
    public String getDescription() { return description; }

    public List<Item> getItems() { return items; }
    public void addItem(Item item) { items.add(item); }
    public void removeItem(Item item) { items.remove(item); }

    public List<Enemy> getEnemies() { return enemies; }
    public void addEnemy(Enemy enemy) { enemies.add(enemy); }
    public void removeEnemy(Enemy enemy) { enemies.remove(enemy); }

    public Item getItem(String name) {
        return items.stream().filter(i -> i.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public Enemy getEnemy(String name) {
        return enemies.stream().filter(e -> e.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }
}

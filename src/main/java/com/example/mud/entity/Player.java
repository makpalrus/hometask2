package com.example.mud.entity;

import com.example.mud.game.Room;
import com.example.mud.game.Item;
import java.util.*;

public class Player {
    private final String name;
    private Room currentRoom;
    private final List<Item> inventory;

    public Player(String name, Room startRoom) {
        this.name = name;
        this.currentRoom = startRoom;
        this.inventory = new ArrayList<>();
    }

    public void setCurrentRoom(Room room) { this.currentRoom = room; }
    public Room getCurrentRoom() { return currentRoom; }
    public void addItem(Item item) { inventory.add(item); }
    public List<Item> getInventory() { return inventory; }
}
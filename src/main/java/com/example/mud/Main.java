package com.example.mud;

import com.example.mud.controller.MUDController;
import com.example.mud.entity.Player;
import com.example.mud.entity.Enemy;
import com.example.mud.game.Room;
import com.example.mud.game.Item;

public class Main {
    public static void main(String[] args) {
        // Creating rooms
        Room room1 = new Room("Start Room", "A small room with stone walls.");
        Room room2 = new Room("Hallway", "A long, dark corridor.");
        Room room3 = new Room("Treasure Room", "A bright room filled with treasures.");

        // Connecting rooms
        room1.setExit("forward", room2);
        room2.setExit("back", room1);
        room2.setExit("forward", room3);
        room3.setExit("back", room2);

        // Adding items
        room1.addItem(new Item("Sword"));
        room2.addItem(new Item("Shield"));

        // Adding enemies
        room2.addEnemy(new Enemy("Goblin", 20));
        room3.addEnemy(new Enemy("Dragon", 50));

        // Creating player
        Player player = new Player("Hero", room1);

        // Running the game
        MUDController controller = new MUDController(player);
        controller.runGameLoop();
    }
}
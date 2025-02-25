package com.example.mud.controller;

import com.example.mud.entity.Player;
import com.example.mud.entity.Enemy;
import com.example.mud.game.Room;
import com.example.mud.game.Item;
import java.util.Scanner;

public class MUDController {
    private final Player player;
    private boolean running;
    private final Scanner scanner;

    public MUDController(Player player) {
        this.player = player;
        this.running = true;
        this.scanner = new Scanner(System.in);
    }

    public void runGameLoop() {
        System.out.println("Welcome to MUD! Type 'help' for available commands.");
        while (running) {
            System.out.print("> ");
            String input = scanner.nextLine().trim().toLowerCase();
            handleInput(input);
        }
        System.out.println("Game Over.");
    }

    private void handleInput(String input) {
        String[] parts = input.split(" ", 2);
        String command = parts[0];
        String argument = (parts.length > 1) ? parts[1] : "";

        switch (command) {
            case "look":
                lookAround();
                break;
            case "move":
                move(argument);
                break;
            case "pick":
                pickUp(argument);
                break;
            case "inventory":
                checkInventory();
                break;
            case "attack":
                attackEnemy(argument);
                break;
            case "help":
                showHelp();
                break;
            case "quit":
            case "exit":
                running = false;
                break;
            default:
                System.out.println("Unknown command. Type 'help' for available commands.");
        }
    }

    private void lookAround() {
        Room currentRoom = player.getCurrentRoom();
        System.out.println(currentRoom.getDescription());
        if (!currentRoom.getItems().isEmpty()) {
            System.out.println("Items in the room: " + currentRoom.getItems());
        }
        if (!currentRoom.getEnemies().isEmpty()) {
            System.out.println("Enemies in the room: " + currentRoom.getEnemies());
        }
    }

    private void move(String direction) {
        Room nextRoom = player.getCurrentRoom().getExit(direction);
        if (nextRoom != null) {
            player.setCurrentRoom(nextRoom);
            System.out.println("You moved to: " + nextRoom.getName());
        } else {
            System.out.println("You can't go that way!");
        }
    }

    private void pickUp(String itemName) {
        Room currentRoom = player.getCurrentRoom();
        Item item = currentRoom.getItem(itemName);
        if (item != null) {
            player.addItem(item);
            currentRoom.removeItem(item);
            System.out.println("You picked up: " + item.getName());
        } else {
            System.out.println("No such item here!");
        }
    }

    private void checkInventory() {
        System.out.println("Your inventory: " + player.getInventory());
    }

    private void attackEnemy(String enemyName) {
        Room currentRoom = player.getCurrentRoom();
        Enemy enemy = currentRoom.getEnemy(enemyName);
        if (enemy != null) {
            enemy.takeDamage(10); // Attacks the enemy with 10 damage
            if (!enemy.isAlive()) {
                currentRoom.removeEnemy(enemy);
            }
        } else {
            System.out.println("No such enemy here!");
        }
    }

    private void showHelp() {
        System.out.println("Available commands:");
        System.out.println("look - Describe the room");
        System.out.println("move <direction> - Move (forward, back)");
        System.out.println("pick <item> - Pick up an item");
        System.out.println("inventory - Check your inventory");
        System.out.println("attack <enemy> - Attack an enemy");
        System.out.println("help - Show commands");
        System.out.println("quit/exit - Quit the game");
    }
}
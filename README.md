# MUD Game

## Description

MUD (Multi-User Dungeon) is a text-based adventure game in which the player travels through rooms, collects items, and fights enemies.

## Functionality

- Moving between rooms
- Environmental inspection
- Selection of subjects
- View inventory
- Enemy attack

## Installation and launch

### Requirements

- Java 11/17

## Management

- `look` - to inspect the room
- `move <direction>` - move (forward, back)
- `pick <object>` - pick up an object
- `inventory` - view inventory
- `attack <enemy>` - attack the enemy
- `help` - list of commands
- `quit` or `exit' - exit the game

## Code structure

- `Main.java ` is the basic logic of the game
- `MUDController.java` - gameplay management
- `Player.java`, `Enemy.java` - player and enemy entities
- `Room.java`, `Item.java ` - game map and items

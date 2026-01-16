# Heroic Team Showdown

This project is a **console-based Java game** for two players. Each player builds a team of heroes and competes against the other player based on total team power. Heroes are read from a text file, teams are built through turn-based selection, and the winner is determined after health randomization and power calculation.

This project focuses on **object-oriented programming**, file handling, and collections in Java.

---

## Project Description

The game allows two players to register and take turns selecting heroes from a shared list. Each hero belongs to one of three types:

- Human
- Monster
- NonLiving

At the start of the game, each hero’s health is randomly reduced, which affects their remaining power. The program calculates the total power of each team and determines the winner.

---

## Technologies Used

- Java
- Console-based input/output
- File handling (`Scanner`, `FileWriter`)
- Object-Oriented Programming (Inheritance & Polymorphism)
- Collections (`ArrayList`)
- Random number generation

---

## Heroes Data File (`heroes.txt`)

Heroes are loaded from a text file using the following format:

Index, Type, Name, Description, Health, MaxPower, AttackType, [MinPower]

> Note: `MinPower` is only required for **Monster** heroes.

---

## Game Menu

1. Show all characters

2. How many non-living?

3. Add players to the game

4. Build the teams

5. Start the game

6. Quit

---

## How the Game Works

- Heroes are loaded from `heroes.txt` into an `ArrayList`.
- Two players enter valid nicknames.
- Players take turns selecting heroes to build their teams.
- Each hero’s health is randomized between 0 and 100.
- Team power is calculated based on hero type and remaining health.
- The team with the higher total power wins.
- he game result is saved to a file.

---

## Hero Types

### Human
- Power depends on health and attack ability.

### Monster
- Uses both **maximum power** and **minimum power**.
- Power changes significantly with health.

### NonLiving
- Power is less affected by health.
- Counted separately in the game statistics.

---

## Output File

### `saved.txt`

After each game, results are saved including:
- Game number
- Team details
- Winner or tie result

---

## Learning Objectives
- Practice Java OOP concepts

- Use inheritance and polymorphism

- Work with files and user input

- Implement turn-based game logic

- Use collections and randomization
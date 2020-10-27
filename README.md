# BaHotH Assistant

BaHotH Assistant is an Android app designed to facilitate gameplay of the boardgame
[Betrayal at House on the Hill](https://avalonhill.wizards.com/avalon-hill-betrayal-house-hill).

The app automates common tasks, such as:
- Tracking changes to character stats
- Maintaining a counter for omen cards drawn and using this counter to simulate "Haunt Rolls"
- Simulating various dice roll events, for example, determining inflicted damage

# Character Selection

There are two ways to select your character in BaHotH Assistant.

### Select from all Characters

By default, all characters are available for selection via scrolling list. They are displayed with
an overview of starting values for each character statistic.

![Select Character Example](/readme-assets/select-character.jpg)

### Filtered Character Selection

Before each game, players take turns choosing characters. Each player must have a character
with a unique color (ie. if a player chooses a red character, no other player can choose
a red character).

The Character Selection screen allows you to filter the character list by color, so that
you can filter out characters that aren't available, and more easily compare characters
that are available.

![Filter by Color Example](/readme-assets/filter-color.png)

# Tracking Character Stats

Changes to character stats can be tracked from the character overview screen.

**Example: An Event card gives your character "+2 Speed":**
![Adjust Stats Example](/readme-assets/adjust-stats.png)

# Dice Events

Various in-game events are decided by rolling dice.

**NOTE: BaHotH uses special dice with values 0-2, as opposed to traditional 1-6 valued dice.**

### Basic Dice Events

Many events in the game require rolling a specific number of dice to determine the outcome. The basic
dice roll feature allows the user to choose the number of dice rolled (1-8 dice) and displays the
sum for that roll.

![Basic Roll Example](/readme-assets/basic-roll.png)

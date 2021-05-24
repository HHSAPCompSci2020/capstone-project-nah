[Shoot!]
Authors: Nont Kaewtrakulpong, Michael Xiong
Revision: 5/14/2021


Introduction: 
This is a game that challenges the player with its 2D shooter stages. It doesn’t solve any real life problem, we wrote it for credit, but there will be usage of different computer language algorithms that will allow the game to run as smooth as possible. The goal of the game is to survive and complete all the stages. We hope the players can have fun, relax, and relieve stress while playing it.
Primary features includes: A 2D map that allows players to move freely with WASD keys, fire-arms for the player to hit targets with mouse clicks, and spawning different bots targets for the players.


Instructions:
Click play to play
Click quit to quit
Click weapons and abilities to choose weapons and abilities
Click stages to choose stages
Use WASD to move and mouse click to shoot.


Features List (THE ONLY SECTION THAT CANNOT CHANGE LATER):
Must-have Features:
* 2D map that allows player to move freely
* The player can fire bullets to hit targets
* The player can move using WASD keys on his/her keyboard.
* Map will spawn enemies as the game progresses.
* Enemies will have different abilities depending on difficulties.


Want-to-have Features:
* The game will have multiple maps depending on difficulties.
* Local multiplayer - co-op & pvp
* Abilities for players, including speed boost, hp regeneration, etc.
* Different types of projectiles players and enemies can use.
* Gears players can pick up to upgrade their weapons ex. Fire rate, damage.


Stretch Features:
* Boss fights - a single target with many skills as well as attack patterns.
* Friendly bots to help with the fights.
* Visual effects - Explosion, Muzzle flash, Shiny speed boost, Holy heal lights, etc.




Class List:
* Abstract Actor - Can’t overlay on each other, move, has hp
* Extends Actor:
   * Player - can use weapon, move around
   * Abstract Reactable objects - Fixed
      * Wall
   * Abstract Enemy - can use weapon
      * Turret - Fixed
      * LoopingShooter - Move in looping pattern
   * Abstract Projectile - Move at constant speed once fired, lose hp when hit other actors
      * Bulley - 1 hp 
* Main
* Menu
* DrawingSurface - Perform every single action of the game


Credits:
* Inspired by “Nier: Automata”
* Processing.org
* Library provided by Mr. Shelby
* We worked together on every class, and some methods as well. Detailed credits are listed in javadoc.
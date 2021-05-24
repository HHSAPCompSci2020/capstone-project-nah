[Shoot!]
Authors: Nont Kaewtrakulpong, Michael Xiong
Revision: 5/5/2021


Introduction: 
[In a few paragraphs totaling about ½ page, introduce the high-level concept of your program. What this looks like depends a lot on what type of thing you are making. An introduction for an application will look different than one for a game. In general, your introduction should address questions like these:
What does your program do?What problem does it solve? Why did you write it? What is the story? 
What are the rules? What is the goal? Who would want to use your program? What are the primary features of your program? 


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
[These are features that we agree you will definitely have by the project due date. A good final project would have all of these completed. At least 5 are required. Each feature should be fully described (at least a few full sentences for each)]
* 2D map that allows player to move freely
* The player can fire bullets to hit targets
* The player can move using WASD keys on his/her keyboard.
* Map will spawn enemies as the game progresses.
* Enemies will have different abilities depending on difficulties.


Want-to-have Features:
[These are features that you would like to have by the project due date, but you’re unsure whether you’ll hit all of them. A good final project would have perhaps half of these completed. At least 5 are required. Again, fully describe each.]
* The game will have multiple maps depending on difficulties.
* Local multiplayer - co-op & pvp
* Abilities for players, including speed boost, hp regeneration, etc.
* Different types of projectiles players and enemies can use.[a]
* Gears players can pick up to upgrade their weapons ex. Fire rate, damage.


Stretch Features:
[These are features that we agree a fully complete version of this program would have, but that you probably will not have time to implement. A good final project does not necessarily need to have any of these completed at all. At least 3 are required. Again, fully describe each.]
* Boss fights - a single target with many skills as well as attack patterns.
* Friendly bots to help with the fights.
* Visual effects - Explosion, Muzzle flash, Shiny speed boost, Holy heal lights, etc.




Class List:
[This section lists the Java classes that make up the program and very briefly describes what each represents. It’s totally fine to put this section in list format and not to use full sentences.]


* Abstract Actor - Can’t overlay on each other, move, has hp
* Extends Actor:
   * Player - can use weapon, move around
   * Abstract Reactable objects - Fixed
      * Wall
   * Abstract Enemy - can use weapon
      * Enemy 0(turret) - Fixed
   * Abstract Projectile - Move at constant speed once fired, lose hp when hit other actors
      * Bullet 0 - 1hp 
* Main
* Menu
* DrawingSurface


Credits:
[Gives credit for project components. This includes both internal credit (your group members) and external credit (other people, websites, libraries). To do this:
* List the group members and describe how each member contributed to the completion of the final program. This could be classes written, art assets created, leadership/organizational skills exercises, or other tasks. Initially, this is how you plan on splitting the work.
* Give credit to all outside resources used. This includes downloaded images or sounds, external java libraries, parent/tutor/student coding help, etc.]




* Inspired by “Nier: Automata”
* Processing.org


* Nont: Bullet Class
* Michael: 
[a]I really like this feature. A suggestion is that you can have the player be able to level up their weapons or abilities.
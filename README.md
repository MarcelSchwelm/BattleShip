# BattleShip

The following lines describe the project (JetBrains Academy). 
The text is taken from:
https://hyperskill.org/projects/125



"Stage 1/5:

Description
Battleship (also called Battleships or Sea Battle) is a two-player strategy game whose history traces back to the First World War. It started off as a pencil and paper game, until Milton Bradley coined the rules and published the game. Fun fact: it was one of the first games to be produced as a computer game in 1979! In this project, we will recreate this timeless classic.

First off, brush up on the rules of the game. There are different variations of the Battleship game, but we will stick to the original rules written by Milton Bradley. You have a 10×10 game field and five ships to arrange on that field. The ships can be placed horizontally or vertically but not diagonally across the grid spaces; the ships should not cross or touch each other. The goal is to sink all the ships of the opponent before your opponent does this to you.

Positioning the ships is exactly where we are going to start! The goal of this first stage is to place all the ships on the game field according to the rules.

Objectives
In this stage, you should arrange your ships on the game field. Before you start, let's discuss the conventions of the game:

On a 10x10 field, the first row should contain numbers from 1 to 10 indicating the column, and the first column should contain letters from A to J indicating the row.
1) The symbol ~ denotes the fog of war: the unknown area on the opponent's field and the yet untouched area on your field.
2) The symbol O denotes a cell with your ship, X denotes that the ship was hit, and M signifies a miss.
3) You have 5 ships: Aircraft Carrier is 5 cells, Battleship is 4 cells, Submarine is 3 cells, Cruiser is also 3 cells, and Destroyer is 2 cells. Start placing your ships with the largest one.
4) To place a ship, enter two coordinates: the beginning and the end of the ship.
If an error occurs in the input coordinates, your program should report it. The message should contain the word Error.

Stage 2/5:

Description
The goal of this game is to sink all the ships of your opponent. Our fleet is not ready for a big battle yet, so let's practice shooting on our field. Place all your units on the battlefield and take a shot!

In this step, you need to develop a system of shooting with accompanying messages about hits and misses.

Objectives
Take a shot at a prepared game field. You need to indicate the coordinates of the target, and the program should then display a message about a hit or a miss. If the shell misses the target and falls in the water, this cell should be marked with an M, and a successful strike is marked by an X. After this shot, the game should be stopped.

If the player managed to hit a ship, the game should display a message You hit a ship!; otherwise, the message is You missed!

Stage 3/5:

Description
It seems a little odd to shoot your own ships. Let's imagine they are not ours! You can ask a friend to place the ships on the game field (or do it yourself, but it will be less exciting), and then the program will hide the ships under the fog of war. You just have to take a blind shot.

Objectives
In this stage, you need to implement the "fog of war" feature in your game. First, place all the ships on the game field, and then hide them with the symbol ~. Take a shot like in the previous stage, and after your attempt, the program should print a message along with two versions of the field: one covered with the fog of war and the other one uncovered.

Stage 4/5:

Description
It looks like everything is ready for full-scale battlefield maneuvers! This time, don't cease fire until all the ships are sunk. At the end of the game, your program should print a congratulatory message to the winner: You sank the last ship. You won. Congratulations!

Objectives
To complete this step, you should add a check that all the ships were successfully sunk. The game is supposed to go on until all ships go down. The program should print an extra message You sank a ship! when all the cells of a particular ship have been hit. Take a look at the examples below!

Stage 5/5:

Description
Here is a good way to show off your new skills: offer a friend to play a computer game that you wrote yourself! Of course, it is much more fun to play Battleship with someone else: the possibility of winning or losing adds a thrill to the game!

Both players add the ships to their fields one by one (no peeking!), and then start shelling each other until one of them succeeds. To make the game fair and prevent the players from peeping at each other's fields, after each move add the message "Press Enter and pass the move to another player", which will clear the screen.

Objectives
To complete this stage and the entire project, add a PvP component to your game. Now the player will see not only the opponent's screen but their own as well. Place the opponent's screen at the top and your field at the bottom."

(https://hyperskill.org/projects/125/stages/663/implement)

# MazeGame

Project:  Energy Maze

The aim of the project is to develop a maze game,
in which energy items are collected while walking in it.


General Information

The game is played in a 21*55 game field including walls. There are two competitors: Human (H) and Computer (C). There are some energy points (*) in the game, which the players collect to increase their energy. There are also numbers from 1 to 4 in the game, which the human player can push and bring the same numbers together to get extra energy. Computer (C) always tries to catch Human (H). When it catches the human, the game ends. The aim of the game is having the highest energy point at the end.

Game Characters

H: Human
C: Computer
*: Energy item (25 energy points for human or 50 energy points for computer) 1-4: Numbers

•	Cursor keys: To move human player
WASD keys: To put an item (related direction) into the backpack IJKL keys: To remove an item (related direction) from the backpack
•	Computer controls C.
•	C’s targeted path will be marked in the game area.


 
 
Input List
The numbers (1-4) and energy points are inserted into the maze area from an input list. The input list (size of 10 numbers) is always full of numbers and energy points, and shows the next item which will be inserted into the maze. The first number or energy point in the list is inserted into the maze when the total number of these objects on the maze becomes less than 20.

Item	Generation probability
1-4	           1/2   (equal probabilities within themselves)
*	1/2


Game Initialization
The game area is loaded from a file “maze.txt” at the beginning of the game. The player can load another maze from the main menu. The players (H and C) are placed randomly in the maze.

At the beginning of the game, energy points and numbers are placed randomly in the maze.

Game Playing Information

Human player (H) can push the numbers if there is an empty square behind it. When the same numbers come together, they disappear and the Human player gains more energy according to the table below.

Same numbers	Energy
Doubles	        100
Triples	        200
Quadruples	    400

Human player gains 25 energy for each energy item (*). Computer player gains 50 energy for each energy item. Computer player cannot push or use numbers. There cannot be more than one game element in the same square.

Human player has a backpack with the capacity of 5 items. S/he can put numbers or energy items in the backpack. When human collects a number in the backpack, energy of the player is decreased by 100 points.

Each number and energy point can stay for 100 seconds in the maze. Then they disappear. New objects come from input list instead of disappeared ones. While players are moving in the maze, each movement costs 1 energy point. If the energy of a player is 0, the speed of the player becomes half of normal speed.


End of the Game

When the computer catches the human player, the game ends.


 Weekly Schedule
1.	Design of classes, data structures, menu and screen.
2.	Load operations, player movements.
3.	Input list, backpack operations, path finding algorithm.
4.	Computer related movements, path finding algorithm.
5.	Remaining parts of the game, test.

 

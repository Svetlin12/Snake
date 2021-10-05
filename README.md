# Snake ![type badge](https://img.shields.io/badge/type-own%20project-brightgreen) ![version badge](https://img.shields.io/badge/version-v1.0-blue) ![build badge](https://img.shields.io/badge/build-passing-success) ![language badge](https://img.shields.io/badge/language-Java-yellow) ![language version badge](https://img.shields.io/badge/language%20version-16-informational)

Implementation of the simple but yet traditional game "Snake".

## Table of contents

* [General Information](#general-information)
* [Technologies Used](#technologies-used)
* [Features](#features)
* [Usage](#usage)
* [Author](#author)

## General information

The project realises the game "Snake" which for those of you who don't know is a game in which you play as a snake and move around a "box", trying to eat apples in order to enlargen yourself with each apple. The game is really simple to understand which is backed up by the "Help" menu integrated into the game's main menu. The project doesn't realise a score ladderboard.

## Technologies Used

* Java
* Visual Studio Code
* Intellij IDEA Community Edition
* Swing

## Features

* Help menu which explains the controls for the snake's movement
* The classical "Snake" game
* Score which is updated every time the snake eats an apple
* End game menu with information about your total score for the finished game

## Usage

* Upon launching the project, the user will see a start menu with 3 options (*"Start Game", "Help", "Exit"*):

![Start Menu](https://github.com/Svetlin12/Snake/blob/main/images/Start%20Menu.PNG)

* When the user's mouse comes closer to either one of *"Start Game", "Help"* or *"Exit"* the text will be highlighted with red color:

![Start Menu hover](https://github.com/Svetlin12/Snake/blob/main/images/Start%20Menu%20hover.png)

* When the user presses on *"Help"*, he will be taken to a separate menu which explains which controls are used in order to control the snake's movement:

![Controls](https://github.com/Svetlin12/Snake/blob/main/images/Controls.png)

* In order to go back to the main menu, the user needs to press on *"Back"* which becomes red when it is hovered on:

![Controls hover](https://github.com/Svetlin12/Snake/blob/main/images/Controls%20hover.png)

* When the user presses *"Start Game"*, the game launches and the snake goes from the top left corner of the window to the top left one by default. At this point the user can start changing it's direction by using the designated for that purpose keys (shown in *"Help"* menu):

![Game Start](https://github.com/Svetlin12/Snake/blob/main/images/Game%20Start.png)

* When the snake's head reaches the position of the red dot (the apple) it gets larger and the red dot changes it's location. The more apples the snake devours, the longer it gets as shown in the picture down below:

![Game](https://github.com/Svetlin12/Snake/blob/main/images/Game.png)

* When the snake hits one of its own body parts or the walls the game ends leading the user to the end game menu as shown down below. On the end game menu the user can view his achieved score for that particular game and there is also an option to go back to the main menu:

![End Game Menu](https://github.com/Svetlin12/Snake/blob/main/images/End%20Game%20Menu.png)

* When the user presses *"Back to Main Menu"* option he is taken over to the main menu. That option also changes its color to green when hovered:

![Back To Main Menu](https://github.com/Svetlin12/Snake/blob/main/images/Back%20To%20Main%20Menu.png)

* The user can exit the game via the *"End Game"* option:

![End Game](https://github.com/Svetlin12/Snake/blob/main/images/End%20Game.png)

## Author

Svetlin Popivanov ([GitHub](https://github.com/Svetlin12))

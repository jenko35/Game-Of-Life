Game Of Life
============
Java implementation of "Game Of Life". For more information see the [exercise][1].

Details
-------
The main code for the task starts within the GameOfLife.java file. GetInput.java provides a command line interface to interact with the game code. 

Assumptions
-----

Some of my own assumptions were:
* The "infinite two-dimensional grid" can actually be limited. In the case of this application, by the maximum and minimum values of an integer in Java. The ability to print the grid is also limited by the maximum length of a String and the limitations of the console window. 

The assumptions provided in the exercise about the String input were:

* Non-Empty
* Valid characters
* Balanced lines

This suggests that validating the input is not required as it has already been validated.

Usage
-----
On running the application you are greeted with.
> Enter Input String

From her enter the initial state of the game as per the [exercise][1] document.
>Enter Input String
>.\*.\*..
>.\*....\*
>...\*...

After the input, enter a blank line to initialize the game. If no lines have been input then the game will initialize the default demo state. Each blank line entered after this will increment the game by 1 round and print the result. Entering a number will increment the game that many times, then print the result. Entering "exit" ends the the application.


 [1]: https://github.com/jenko35/Game-Of-Life/blob/master/stories/exercise.txt
 [2]: https://github.com/jenko35/Game-Of-Life/blob/master/src/bbc/gameoflife/GameOfLife.java
 [3]: https://github.com/jenko35/Game-Of-Life/blob/master/stories/exercise.txt

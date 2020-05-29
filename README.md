# SMARTe Assignment


Sudoku:

Rule A: digit=== in between 1 and 9
Rule 1: digit=== unique in ROW
Rule 2: digit=== unique in COLUMN
Rule 3: digit=== unique in subGrid of 3x3


1. check if (1<=digi>=9)
2. if- yes--
		- iterate through sudoku[row]
		- check digi is unique in row
				if yes return true or false
		- iterate through sudoku[column]
				if yes return true or false
		- find the starting point(starting point of row and column) of the 3x3 grid
		- iterate through 3x3 grid
			- find if digi is unique in subGrid
					if yes return true or false


****************************************************************************************


Playing card sequence:

Rule 1: every card must be of Same Suite
Rule 2: rank of card must must be in sequence



1. Cards of same suite, splits the cards on "," get the [0].charAt(0) match this with other cards of 0th char:-
	if yes
		- prepare the next value baised on the ranks
		- get the current (by the rank),  value by iterating over array of cards
		- check if nextVal==currentVal
			-if yes return true
			- else return false.


****************************************************************************************

*Enhancements*

Sudoku:

* Row Validation
* Column Validation
* Cell Validation
* Logic wise comments 
 
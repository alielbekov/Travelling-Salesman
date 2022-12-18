This program uses two sorts of algorithms to solve Travelling Salesman Problem.


One of them is heuristic approach where lowest-weight neighboring city is chosen and proceeded to.
The other approach is using recursive backtracking where we brute-force all the possible paths and return the best one.

The program also includes an improved version of the brute-force approach where the program won't have to 
iterate through unnecessary loops by skipping them once the travel cost is already more the the current lowest cost.



The following is the results from running all three approaches.


< heuristic: cost = 604.3, 1 milliseconds
< mine: cost = 604.3, 0 milliseconds
< Backtracking: cost = 604.3, 0 milliseconds


< heuristic: cost = 4.7, 0 milliseconds
< mine: cost = 4.7, 0 milliseconds
< Backtracking: cost = 4.7, 0 milliseconds

< heuristic: cost = 183.86, 0 milliseconds
< mine: cost = 183.86, 1 milliseconds
< Backtracking: cost = 183.86, 2 milliseconds


< heuristic: cost = 10.0, 0 milliseconds
< mine: cost = 10.0, 0 milliseconds
< Backtracking: cost = 10.0, 0 milliseconds

< heuristic: cost = 307.6, 0 milliseconds
< mine: cost = 307.6, 0 milliseconds
< Backtracking: cost = 307.6, 0 milliseconds


< heuristic: cost = 546.3499999999999, 0 milliseconds
< mine: cost = 546.3499999999999, 0 milliseconds
< Backtracking: cost = 546.3499999999999, 0 milliseconds


< heuristic: cost = 13.899999999999999, 0 milliseconds
< mine: cost = 13.899999999999999, 0 milliseconds
< Backtracking: cost = 13.899999999999999, 0 milliseconds



< heuristic: cost = 3.3969307170000005, 0 milliseconds
< mine: cost = 1.356677535, 4 milliseconds
< Backtracking: cost = 1.356677535, 1132 milliseconds

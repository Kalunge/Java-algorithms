
# BackTracking
- imagine a road trip problem where we are having a trip through a city aiming to visit all the places while covering the shortest distance possible and going back to where we started without revisiting places.
- here we can use the concept of backtracking allowing us to explore different paths until we find the shortest one that fulfills all the conditions.
- the brute force would be to list all the possible routes and then choose the shortest, this would be computationally expensive as coming up with all the possible routes is enormous
- using backtracking we would picking a close place to visit that meets our conditions, from there we would check whether the place is visited or if there is a way forward from there if these are not met we backtrack and repeat the same until we have a short and optimal route to the destination.
- we keep choosing, checking conditions and backtracking.
- **Backtracking:** is an algorithmic technique for solving problems by incrementally constructing choices to the solutions
- we abandon choices as soon as we determine that they are not feasible
- this is unlike a brute force approach which attempts to evaluate all possible solutions to select the required one.
- backtracking is efficient as it avoids the use of computational resources in generating and testing all possible solutions
- backtracking works by exploring all potential routes toward a solution step-by-step.
- it can be visualized as traversing a state-space-tree, whereby each node represents a partial solution
- starting from the root(an empty solution), backtracking moves deeper into the tree, exploring branches(choices) until it finds a feasible solution or reaches a leaf node that cannot be extended into a complete solution
- upon reaching a dead end, the algorithm backtracks to the previous state and explores a different branch.
- this process is repeated, with constraints applied at each step to avoid exploring paths that cannot lead to a successful, feasible solution. 

- the backtracking algorithm can be implemented using recursion.
- we use recursive calls where each call attempts to move closer towards a feasible solution.
- below are the steps
1. if the current point represents a feasible solution, declare success and terminate the search.
2. if all paths from the current point have been explored(dead end) without finding a feasible solution, backtrack to the previous poin.
3. if the current point is not a dead end, keep progressing towards the solution, and reiterate all the steps until a solution is found or all possibilities are exhausted. 

- if all the points have been explored withour finding a feasible solution, declare failure; no solution exists.

```python
FUNCTION backtrack(solution, options)
    if solution is complete:
        processSolution(solution)
        return
    for each option in options:
        if option is valid:
            makeChoice(solution) // choose the option
            backtrack(solution + [option], remaining options) // recur with new choice
            undoChoice(option)
        
```
- we begin with an initial solution that is either empty or partially constructed.
- the ```backtrack``` function explores possible solutions by iterating through ```options```
- at each step, it checks whether the solution is complete using ```processSolution```
- if the solution is incomplete, it evaluates each ```option```
- if an ```option``` is valid , ```makeChoice(option) ``` adds it to the solution and ```backtracks``` is called recursively to explore further choices.
- once a choice has been explored, ```undoChoice(option)``` removes it, ensuring that we backtrack and consider other possibilities.
- this systemic approach allows ```backtrack``` to generate all valid solutions while efficiently pruning invalid paths

## Does your problem match this pattern
Yes if
- **Complete exploration is needed for any feasible solution**
- **selecting the best feasible solution**
No if
- **Solution invalidity disqualifies other choices**

## Real world problems
- **Syntax analysis** complex nested programs can be determined
- **Game AI:** chess or Go
- **Pathfinding algorithms**










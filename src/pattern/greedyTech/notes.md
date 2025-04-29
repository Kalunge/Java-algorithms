# Greedy Techniques
- greedy algorithms are an approach for tackling optimization problems where we aim to find the best solution under given constraints.
- imagine ata buffet, and we want to fill our plate with the most satisfying combination of dishes available
- the catch: we can only make our choice one dish at a time, and once we move pasta  dish we cant go to pick it up
- in this scenario, a greedy approach would be to always choose the dish that looks most appealing to us at each step, hoping that we end up with the best possible meal.
- this pattern builds a solution piece by piece.
- this approach we makes a choice best on what seems best at the moment, the most greedy choice, with the goal of finding an overall optimal solution
- it does not worry about the future, but focuses on immediate gratification
- it makes a locally-optimal choice in the hope that it will lead to a globally optimal solution
- hence why t is used to solve optimization problems
- this approach does not always lead us to the best solution for every problem.
- by always optimizing for the immediate benefit, we might miss out on better options down the line just as in a buffet.
- one classic example where greedy algorithms shine is in organizing networks, like connecting computers with least amount of cable. 
- greedy algorithms offer a straightforward and often effective way to solve optimization problems by making the most advantageous choice at each step.


## Does your problem match this pattern
Yes if both of these conditions are met. 
**Optimization Problem:** this is a case where we are trying to find the best solution under a given set of constraints.This could involve maximizing or minimizing some value, such as cost, distance, time or profit.
**Making local choices leads to a global solution:** The problem can be solved by making simple decisions based on the current option or state without needing to look ahead or consider many future possibilities.

No if any of these conditions if fulfilled
**Local choices lead to suboptimal solutions:** our analysis shows that making local greedy choices leads us to a sub optimal solution
**problems lacks clear local optimal choice:** if the problem does not naturally break down into a series of choices where we can identify the best option at each step, a greedy algorithm might not be applicable. 

## Real World Problems
1. **CPU scheduling algorithms:** choosing the least next problem
2. **Network design in LANs:** 
3. **Fiends recommendation algorithm in social networking websites:** 
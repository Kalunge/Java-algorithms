# Dynamic Programming
- many computational problems are solved by recursively applying a divide and conquer technique.
- in some of these problems we can notice that there is an optimal substructure i.e the solution to a smaller problem helps us solve the bigger one.
- for instance consider a problem ```is the string rotator a palindrome```?
- we can start by observing that the first nd the last character math thus ths string could be a palindrome
- we shave off these characters and try to answer the same problem for the string otato.
- for all the sub-problems encountered, if the answer is no, we know that the overall string is not a palindrome. 
- if the answer is yes for all the sub-problems encountered, then the overall string is a palindrome.

- while each sub-problem in this recursive solution is distinct, there are many problems whose recursive solution involves solving some sub-problems over and over again(overlapping sub-problems)
- an example is the recursive computation of the nth fibonacci number
     
        fib(0) = 0
        fib(1) = 1;
        fib(n) = fib(n - 1) + fib(n - 2), n > 1;
- when recursively computing the fib of 4 we can notice that
  - fib(2) is evaluated twice
  - fib(1) is evaluated thrice
  - fib(0) is evaluated twice.
- these are repeated or overlapping sub-problems, since every one of them is reevaluated every time it appears, the naive recursive implementation of this problem will thus have an exponential time complexity
- an optimized approach would be to store and reuse solutions to sub-problems, reducing the time complexity to polynomial time.
- such an approach is called dynamic programming
- the key idea is to save the result of a sub-problem to avoid recomputation.
- we are now aware that we need to store and reuse computations the question is how.

## Approaches for storing and reusing computations
1. **Top-down approach:** this is a recursive approach that stores the results of redundant function calls to avoid repeating calculations for the same sub-problems
2. **Bottom-up approach:** it is an iterative strategy that systematically fills a table with results of sub-problems to solve larger problems efficiently.

## Top-down Approach
- the top-down approach is also known as memoization
- it is usually implemented as an enhancement of the naive recursive solution.
- memoization uses recursion to break down larger sub-problems into smaller ones.
- the smallest problem is solved and the result is stored in a lookup table for use in computing larger sub-problems.
- to take advantage of the stored results of subproblems, in every call, the top-down recursive function first checks if a solution to a sub-problem already exists/
- if it does, the result is fetched from the lookup table instead of making a recursive call to compute it.
- otherwise, the recursive call is made. 
- in the fib of 4 unnecessary recursive calls to fib(2), fib(1), and fib(0) would be avoided as their results would already be in the lookup table
- compared to the naive recursive solution, this approach takes up additional space in memory because it stores intermediate results in a lookup table


## Bottom-up approach
- this approach is also known as tabulation
- in this approach, the smallest problem is solved first, and then larger sub-problems are computed based on the evaluated results.
- in contrast to the topdown approach, which uses recursion to first break down a larger problem into smaller subproblems, the tabulation or bottom-up approach starts by solving the smallest sub-problem, and then iterates progressively through larger sub-problems to reach the overall sub-problem.
- we start by initializing a lookup table and setting up the values of the base cases.
- for every subsequent, larger subproblem, we simply fetch the results of the required preceding smaller subproblems and use them to get the solution to the current sub-problem
- for example in computing fib(), we first set up these two base cases fib(0) and fib(1), and then proceed to calculate the larger subproblems

        fib(2) = fib(1) + fib(0) = 1 + 0;
        fib(3) = fib(2) + fib(1) = 1 + 1 = 2;
        ...
- and son on...

## Does your problem match this pattern
- **overlapping sub-problems:** whereby we can use the results of one subproblem when solving another, possibly larger subproblem
- **Optima substructure:** in problems where the final solution can be constructed from  the optima solutions to its sub-problems

## Real World problems
1. optimal route planning in GPS navigation systems
2. Text justification
3. Robotics motion planning




















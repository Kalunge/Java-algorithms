# Java Algorithms
a series of defined instructions that perform a task

## Optimizing an algorithm
- make assumptions about data
- a trustworthy slow algorithm is better than a fast algorithm that aint reliable
## Algorithm one
- the item we are searching for will be the first or last element in the list
- this is O(1) or constant time
## Algorithm Two
- the item we are searching for could be anywhere within the list
- we have to check for every time
- best case : O(1) - first item checked
- worst case: item doesn't exist thus we have to check every element O(n) or linear. search time increases with the increase in input size
- we consider the worst case scenario in selecting an algorithm

### Time complexities
* O(1) or constant time
* O(log(n)) or logarithmic time
* O(n) or linear time
* O(n**2) or exponential time
* O(n!) or factorial time

- we can use big-O to describe space complexity
- for a validation algorithm we return true or false
- Binary search -> with sorted assumption O(log(n)) time

### STACK
- enqueue -> add item to the end of the queue
- deque -> remove item from the beginning of the queue
- peek -> see the next item from the from of the queue
- 
### STACK
- LIFO Last in first Out principle
- push() -> items on the top
- pop() -> items off the top
- the last item pushed onto the stack will be the first item popped off the stack
- the first item pushed onto the stack will be the last item popped off the stack
- the main function -? builder -> main


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

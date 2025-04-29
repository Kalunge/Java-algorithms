# Two Heaps
- Heaps are a special data structure taht helps efficiently manage priorities.
- with a min heap, one can always find the flight with the earliest prioority, and with a max heap, one can focus on flights that have been waiting for the longest - all while making updates quickly when new flights are added.
- A heap is a special binary tree that satisfies the heap property

## Heap properties
**Min Heap:** the value of each node is smaller than or equal to the values of its children. the root node holds the minimum value. a min heap always prioritises the minimum value
**Max Heap:** the value of each node is greater than or equal to the values of its children. The root node holds the maximum value. a max heap prioritises the maximum value
**Priority Queue:** this is an abstract data type that retrieves elements based on their custom priority. is is often implemented using a heap for efficiency.

- a heap is a specific data structure with a fixed ordering(max or min) while a priority queue is an abstract data type that handles custom priority requirements for elements.
- Heaps are typically implemented using arrays to efficiently access the parent and child nodes.

# Major Heap Operations
**Add:** this inserts a new element in the heap it takes O(log n) time
**Delete:** removes the root element and rebalances the heap taking O(log n) time
**Peek:** retrieves the smallest or largest element in O(1) time

## Solving problems with a single Heap
- heaps are powerful as they allow us to maintain oder(min or max) without needing full sorting, making operations much faster than arrays or LL
- heaps are also very useful when we need to repeatedly access the smallest or largest elements in a dataset.

### Solving the Last Stone problem
1. we first build a max heap using the stone weights then for each turn we:
2. pop the two largest stones from the heap
3. if the two stones have the same weight they are both destroyed and none is added back to the heap
4. if the stones have different weights, the stone with the smaller weight is destroyed, and the stone with the larger weight is reduced by the smaller stone's weight and pushed back into the heap for further processing
- this continues until wither one stone remains or none remains. the weight of the last remaining stone(or 0) is returned as the result.
- the time complexity of the algorithm is O(NlogN), where n is the number of stones
- this is becasue building the heap takes O(n) time, and each of the n smash operations involves heap insertion and deletion, each taking O(logN) time
- in contrast the naive solution, which repeatedly scans the list to find the two largest stones, has a time complexity of o(n ^ 2) due to the need for n scans of O(N) each.

## Using two Heaps for problem Solving
- there several scenarios where two heaps can be employed to optimize the solution
- for instance when we need to efficiently track a dataset's smallest and largest elements, such as finding the median or balancing data streams.
- by maintaining one min heap fro the smallest half of the data and one max heap for  the largest half, we can quickly access the median or adjust the distribution of elements.
- another scenario would be problems involving intervals or ranges, where one heap can store one set of values(e.g start times) wnr the other tracks the complementary(e.g end times) to efficiently identify valid intervals or ranges

## Solving the Find Right Interval problem
- in this problem, we are given an array of intervals and must find the right interval for each
- a right interval starts after the current interval ends. if no such intervals exist return -1.
- the goal is to efficiently find the smallest start time that is greater than or equal to the current intervals end time
- This problem can be solved using two heaps: one for storing start times and the other for storing interval end times.
- the key idea is to process intervals based on their end times, ensuring we find the smallest start time from the start heap greater than or equal to its end time for each interval

1. we begin by populating two heaps with the start and end times
2. for each interval, we pop the smallest end time from the end heap and remove any start times smaller than the current end time from the start heap.
3. if a valid start time remains in the start heap, it represents the right interval for the current interval
4. if no valid right interval exists, we return -1 for that interval

- the time complexity of this heap-based solution is O(NlogN), where n is the number of intervals. This is beacuse we perform O(N) insertions and deletions for each of the two heaps, each heap operation taking O(logN) time
- in contrast the naive solution, which involves scanning through all the intervals for each interval to find the right interval, has a time complexity of O(N^2), as it requires n comparisons for each of the n intervals.

## Does your problem Match this pattern
Yes if any of these conditions are fulfilled
**Linear Data:** if the heap is linear, it can be sorted or unsorted.
    a heap efficiently finds the max or min elements if the data is unsorted. this is also true if the data is sorted.
**Stream of Data:** the input data continuosly arrives in real time, often in an unpredictable order, requiring efficient handling and processing as it flows in.
**Calculation of minima and maxima:** teh input data can be categoirized into two parts, and we need to repeatedly calculate two maxima, two minima or one maximum and one minimum for each set
**Efficient retrieval of extreme values:** the solution needs to retrieve or update the mn or max element repeatedly but cannot afford a fulll sort each time, a heap-based pq offers O(logN) insertion/removal and O(1) retrieval
**Custom priority-based selection:** the problem involves selecting the next element based on specific priority at each step, such as proessing the largest task or earliest event.

## Real World Problems
**Video Platforms** as part of a demographic study, we are interested in the median age of the viewers, the median age should be calculated with every sign up
**Gaming matchmaking** matching players based on their skills. 


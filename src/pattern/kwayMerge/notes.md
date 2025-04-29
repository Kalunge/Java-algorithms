# K-way Merge
- this is an essemtial algorithmic startegy for merging K sorted data structures such as arrays and linked lists into a single sorted data structure.
- it is an expansion of the mergesort algorithm that merges two sorted data structures into one.
- the basic idea of this algorithm is repeatedly selecting the smalles(or largest) element from among the first elements of the K input lists and adding this element to a new output list. 
- this is repeated untill all elements are added to the new output list.

## Approaches
**Using a min heap**
1. insert the first element of each list into a min heap. this sets up our starting point , with the heap helping us efficiently track the smallest current element among the list.
2. remove the smallest element from the heap - which is always at the top o the heap- and add it to the output list.
3. keep track of which list did the element came from, this is to help with knowing where to get the next element from
4. after removing he smaller element from the heap replace it with the next element from the same list
5. repeat steps 2 - 4 until all elements are merged in a sorted manner in the output list.

**Making groups of two and repeatedly merging them**
1. start by dividing the K sorted lists into pairs, making groups of two. this organizes our lists into manageable units for merging.
2. for each pair of lists, perform a standard two-way merge operation. this results into two K/2 merged lists
3. if there are odd number of unmerged lists just leave out one unmerged list in that round
4. repeat the process of pairing up the resulting losts from the previous merge and merging the again until only one sorted list remains, which is the final result.

## Does your problem match this pattern
- involves merging sorted arrays or a matrix as a result or a step towards the result. 
- seeking the kth smallest/largest element across sorted collections

## Real world problems
- Patient records aggregation
- merging financial transaction streams
- Log file analysis
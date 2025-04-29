# Union Find
- the Union Find pattern is used to group elements into sets based on a specified property.
- each set is non-overlapping, i.e, it contains unique elements that are not present in any other set.
- the pattern uses a disjoint set data structure, such as an array, to  keep track of which set each element belongs to.
- each set forms a tree data structure and has a representative element that resides at the root of the tree. 
- every element in this tree maintains a pointer to its parent
- the representative's parent pointer points to itself. 
- if we pick any element in a set and follow its parent pointers, we will always reach the set representative
- **find(v):** Finds the representative of the set that contains v
- **union(v1, v2):** Merges the sets containing v1 and v2 into one

- for now, the worst-case time complexity of this approach is O(n) because we might have to traverse the entire tree to find the representative of an element. 
- we can improve the union find pattern through an optimization called union by rank.
- we maintain a rank for each tree
- the larger the size of the tree, the greater the rank.
- the idea is that when merging two trees with the union method, we always attach a tree of a lower rank to one with a higher rank.
- this ensures that when two trees are merged, each element in this merged tree has the shortest possible path to the root. 
- this brings the tme complexity down to O(log(n)) in the worst case

- Another optimization to the union find pattern is path compression, where on each find operation on a node of a tree, we update the parent of that node to point directly to the root
- this reduces the length of the path of that node to the root, ensuring we dont have to travel all the intermediate nodes on future find operations
- both of these optimizations used together bring down the worst-case time complexity to lower than `O(log(n))`.
- the amortized time complexity becomes `O(α(n))` which is a small constant.
- here, α is the inverse Ackerman function
- this is faster than any naive approach to merging subsets , which would take at least` O(n)` time if not more.
- if we are to perform m union finds the time complexity becomes `O(m(a(n)))`

## Does your problem match this pattern
Yes if any these conditions is fulfilled
- **Property based grouping:** the problem reqquires arranging elements with a certain property into groups or, to use graph terminology, into connected components.
- **Set combination:** we have been given a problem that contains elements represented as separate sets initially where we have to combine pairs of sets or find whether two elements belong to the same set or not.
- **graph data organisation:** the problem data is best organised in the form of a graph, yet the data has not been provided in the form of an adjacency list/matrix

## Real World problems
- image segmentation through region agglomeration
- image manipulation
- Network connectivity
- Percolation
- Hex(game)

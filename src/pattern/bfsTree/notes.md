# Breadth First Search
- a tree is a graph that is undirected, acyclic.
- it is a connected graph whereby any two are connected by the exactly one path
- its nodes can contain values of any data type
- the ime complexity of of searcha nd insert operation sin a tree is O(log n) which is better than linear data structures like array which is O(n)
- trees can be traversed j multiple ways
- a naive way of traversing a tree would include revisiting nodes which leads to a time complexity of O(N^2)
- the **Breadth first search** is a traversal method that explores the tree level by level, starting from the root node
- nodes that are connected to the root node by an edge are considered to be level 1, those connected to the level 1 nodes are level 2 and so forth
- this traversal gives us a traversal time of O(N) since every node is visited once

## Key feature of BFS
-  **Initialization** - starts at the root node
- **exploration** - nodes at level 1 are visited first before proceeding to deeper and next level nodes.
- **Strategy** - explore breadth-wse, that is current level before proceeding deeper
- **Node discovery** - as BFS discovers nodes, it processes them according to search requirements, if it is a find operation it stops otherwise eit enqueues the node for operation
- **Stopping condition** - BFS terminates once a being-searched-for node is found or once all nodes have been visited.

**BFS** doesn't have to follow a left to right order, thus nodes in the same level may be processed however.


## Does your problem match this pattern?
- Tree data structure or cost of transforming into one is low
- Not a wide tree
- requires level by leve traversal
- if we have a reason to believe the solution is near the root otherwise we use DFS

## Real world problems
- File system analysis
- Version control system
- Genealogy and evolutionary trees
- Traversing DOM tree I
- Traversing DOM tree II - we make the tree I more efficient by avoiding a queue and using a linked list that points to the next element






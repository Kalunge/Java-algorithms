# Tree Depth First Search
- A tree is a graph that contains the following properties
  - it is undirected
  - it is acyclic
  - it is a connected graph where any two vertices are connected by exactly one path
  - its nodes can contain values of any data type

## differentiating properties
- organise data in an hierarchical manner with a root node and children nodes
- non-linear - not sequential but in a branching manner
- time complexity for search and insert operations is O(log n) as opposed to O(N) in linear data structures
- there are multiple ways of traversal

**Depth first search**
- this is a traversal method that goes far into one branch before it visits other branches. it guarantees a O(n) time complexity as every node is visited once
- there are three main methods in DFS which are preorder, inorder and postorder

## PreOrder traversal
- here we visit nodes in the order of root - then left then right.
- it is like coming from the top of a tree and visiting branches as we go down.
- the steps are
1. **Traverse the Left subtree** - if the left child does not exist we move traverse the right subtree
2. **traverse the right subtree** - if the right child does not exist we move on to the next step
3. we repeat steps 1-2 until all nodes in the tree have been visited.

## inOrder traversal
- here we start with the left subtree
- starting from the root we first traverse the left subtree, then visit the current node, and finally explore the right subtree
- this means that we will traverse the tree in ascending order if the tree represents numbers
- it is like exploring a tree from the bottom left corner to the right moving up gradually.
- the steps are
1. **Traverse the left subtree** - starting from the root node we traverse the left subtree and if a left child does not exist we visit the current node
2. **traverse the parent node**- after visiting the current node in step 1 we visit its parent node.
3. **Traverse the right subtree** - we repeat step 3 starting from the right child node. if the child node does not exist we visit the current node
4. we **repeat the above steps** until all nodes in the tree have been visited. 

## PostOrder traversal
- Starting from the root, we first travers the left subtree, then the right subtree and finally the current node.
- this order means we explore nodes from the bottom up, going from the leaves toward the root
- it is like examining a tree from its outer most branches inward. 
- the steps are
1. **Traverse the left subtree** - if the left child does not exist visit the current node. 
2. **Traverse the right subtree** - if the right subtree dies not exist, visit the current node.
3. **Traverse the parent Node** - after visiting the current node in step2, we visit its parent node.
4. we **repeat steps 1-3** until all the nodes in the tree have been visited.


## Does your problem match this pattern
- Tree data structure
- Balanced/low balancing factor for efficiency
- Hierarchical structure - e.g org structure
- Solution near the leaves
- Traversal along paths
- explore all possible paths

## Real world problems
- find products in a price range
- Dependency resolution
- Syntax tree analysis
- 


# Graphs
- a graph is a non-linear data structure that represents connections between entities.
- in graph theory, entities are represented as vertices(or nodes), and the connections between them are expressed through edges. 

## Basic components/properties of graphs
**Vertex(node):** it is the fundamental unit of a graph, usually represented as a point that holds som information/data
**Edge:** it is a connection between two nodes. t may have a direction as is in a directed graph or none in a undirected graph
**Weight:** each edge has a weight associated with it, which indicates a cost or value associated with the connection
**Degree:** the number of edges incident to a node
**in-degree:** it is the number of edges coming towards a vertex(in directed graphs)
**out-degree:** it is the number of edges going away from the vertex
**Adjacent nodes:** those nodes that are connected to each other through a vertex
**Path:** it is a sequence of nodes where each adjacent pair is connected by an edge
**Cycle:** is a path that starts and ends at the same node

## Types of Graphs
**Undirected Graph:** a graph in which the edges have no direction, representing a two-way relationship between nodes ege mutual following in instagram
**Directed Graph:** a graph in which the edges have a direction, indicating a one-way relationship between nodes
**Weighted Graph:** a graph in which each edges has a numerical value assigned to it, indicating the cost, distance or some other relevant measure associated with that connection. 8 has more weight than 3
**Cyclic graph:** a graph that contains at least one cycle, which is a path that starts and ends at the same node.
**Acyclic graph:** a graph that contains no cycles, i.e, there is no path that starts and ends at the same node.

## Graph representation
**Adjacency List:** 
- A collection of lists, where each list corresponds to a node and contains its neighbors.
- in the case of weighted graphs the weight is stored alongside corresponding nodes otherwise a weight of 1 is assumed and ommited

## Adjacency Matrix
- a 2D arrays where each cell, matrix[i][j], represnet the edge between nodes i and j.
- the value of matrix[i][j] equals 1(or the weight in the case of a weighted graph) if there is an edge between nodes i and j, and 0 otherwise

## Graph Traversal
**Depth first search**
- in DFS, te startegy is to explore as far as possible along one path before turning back
- the algorithm starts with a chosen source node and proceeds to one of its neighbor nodes while marking the source node as visited
- from there, it goes to one of its neighbors and marks this newly traversed node as visited.
- this continues until it reaches a node with no neighbors.
- Now, the algorithm starts backtracking, it goes a step back and checks for the remaining neighbor nodes that are yet to be explored.
- this process continues until all the nodes in the graph, that are reachable from the source node, have been visited
- this algorithm can be implemented using a stack 
- initialize an empty stack and choose a source node
- push it onto the stack and mark it as visited
- while the stack is not empty
  - pop a node
  - explore its unvisited neighbors
  - and push them onto the stack
  - marking them as visited
  - continue this process until reaching a node with no neighbors
  - backtrack by popping from the stack
  - repeat until the stack is empty, ensuring all connected nodes are visted
**Breadth first Search**
- here, the strategy is to explore the graph in layers, one level as at a time
- we begin at a chose source node and visit all its immediate neighbor nodes while marking them as visited.
- it then moves on to visit the neighbors of those nodes before proceeding to the next level of neighbors.
- this process continues until all the nodes in the graph, that are reachable from the source node, have been visited. 
- we can implement this algorithm using a queue

i. initialize an empty queue and choose a source node
ii. enqueue it and then enter a loop
iii. withing this loop,  we dequeue a node from the front of the queue
iv. visits its immediate neighbors and mark them as visited.
v. these neighbors are subsequently enqueued into the queue
- the queue plays a vital role in determining the order of exploration, ensuring that nodes at the current level are processed before proceeding to the next
- this iterative process continues until the queue is empty, signifying that all reachable nodes from the source have been visited.

## Graph Algorithms
**Dijkstra's Algorithm:** find the shortest path between two nodes ina weighted graph
**Bellman-Ford algorithm** finds the shortest path in a weighted graph, even when negative edge weights are present
**Floyd-Warshall algorithm** finds the shortest paths between all pairs of nodes ina weighted graph
**Topological sorting** orders nodes in a directed acyclic graph to satisfy dependencies
**Prim's algorithm** it finds the minimum spanning tree of a connected, undirected graph
**Kruskal's algorithm** it also finds the minimum spanning tree of a connected, undirected graph

## Does your problem match this pattern
**Relationships between elements:** there is a netwrok of interconnected objects with some relationship between them; i.e the data can be represented as a graph

## Real World Problems
1. routing in computer networks
2. flight route optimization
3. epidemic spread modelling
4. Recommendation systems




















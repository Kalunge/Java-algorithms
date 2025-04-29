# Topological Sort
- this is a sorting technique used to organise a collection of items or tasks based on their dependencies.
- it helps figure out the correct sequence of steps to bake a cake efficiently, such that, we are not frosting the cake before baking it.
- the pattern is used to find valid orderings of elements that have dependencies on or priority over each other.
- these elements can be represented as the nodes of a graph, so in technical terms, topological sort is a way of ordering the nodes of a directed graph such that for every directed edge[a,b] from node a to node b, a comes nefore b in the ordering.
- **Nb**: Toppological sort is only applicable to directed acyclic graphs, meaning there should be no cycles present in the graph.
- if we write a recipe fir baking a cake, then the list of tasks goes like first mix the batter, then bake the cake, and finally, frost it.
- these tasks can be organised in a graph, where each task is a node, and the dependencies between tasks are represented by directed edges. 

A ----> B ------> C
A - Mix the batter
B- Bake the cake
C - Frost the cake

this indicates that task A is performed before task B and task B is performed before task C.
- if we mistakenly add a step in our recipe that contradicts any of the existing steps, it introduces a cycle in our graph. 
- ij a graph with a cycle, we cant establish a clear order of tasks, making topological sorting impossible.
- topological sorting is only applicable to Directed Acyclic Graphs where tasks ar organised in a logical sequence without any contradictions or cycles.
- topological sorting is crucial for converting a partial ordering to a complete ordering, especially when certain tasks have defined dependencies while others do not.

# steps to order a given task 
1. calculate the in-degree of each node, representing the number of incoming edges or dependencies.
2. Nodes with ```inDegree = 0``` are added to a queue as they have no dependencies and be processed first.
3. we then process nodes from the queue, adding them to ```topologicalOrder``` and reducing the in-degree of their neighbors.
4. if a neighbor's inDegree becomes 0, it is added to the queue, ensuring propoer ordering.
5. if, in the end the numbe rof processed nodes is less than the total nodes in the graph, a cycle exists, preventing topological sorting as some nodes remain unprocessed

- because topological sort can be applied to DAGs, it is important to convert a non-DAG input to a DAG before solving the problem.

## Does your problem match this pattern
Yes if
- **Dependency relationships**
- **Ordering or sequencing**
No if
- **Presence of Cycles**
- **Dynamic dependencies**


## Real world problems
- **Course scheduling**
- **Recipe planning in cooking**
- **process scheduling in computer systems**














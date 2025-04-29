# Matrices
- a matrix is a group of numbers arranged in rows and columns in a rectangular pattern. 
- in computer science, Matrices are represented by 2D arrays of dimensions m*n whereby m represent the number of rows and n the number of columns.
- each number is represented by the array indexes
- matrix[i][j] represent the number in the i-th row and j-th column

## Matrix transformations
- these are operations performed on matrices that lead to new matrices

**Addition and subtraction**
- Element-wise addition or subraction of matrices of the same dimensions.
- ```[[0, 1, 3], [9, 5, 8]] + [[1,5,9], [11,7,8]] = [[1,6,12], [20, 12, 26]]```

**Multiplication**
- Here, we perform the dot product between the rows of the first matrix with the column of the second matrix.
- after multiplication, then we sum up the products between the elements of the row of the first matrix with the corresponding elements of the first column of the second matrix.
- the number of rows in the first matrix should be equal to the number of the columns in the second matrix
- ```[[0, 1, 3], [9, 5, 8]] * [[1, 5], [11, 7], [4,3]] = [[23, 16], [96, 104]]```
- (2 by 3) * (3 by 2) = (2 by 2)

**Inverse**
- for a square matrix A, if there exists another square matrix B such that ```AB = BA = I```(where I is the identity matrix - a matrix with 1s on the diagonal and zeros elsewhere), then B is called the inverse of A.

**Transpose**
- swapping the rows and columns of a matrix

**Scalar multiplication**
- each element of the matrix is multiplied by a scalar value

**Rotation**
- the elements of a square matrix are rotated an an angle

**Reflection**
- the elements of a matrix are flipped over an axis

## Matrix Traversal
- this refers ot the process of systematically visiting each element of a matrix exactly once.
- this is useful for searching, sorting, pathfinding and data manipulation

1. **Row-major traversal**
- here, we traverse the matrix row by row, moving horizontally first and then vertically. 
- if we have a matrix of m * n dimensions we move from 0,0 -> 0,1 -> 0(n - 1) then move to the next row and proceed until we reach(m - 1)(n - 1)

2. **Column-major traversal**
- this is the opposite pf row-major traversal
- we traverse the matrix column by column 0,0 -> 1,0 -> m-1, n-1.

3. **Spiral traversal**
- This method involves traversing the matrix in a spiral pattern, starting from the outermost elements and moving towards the center
- the traversal direction alternates between right, down, left and up until all elements are visited.

## Does your problem match this pattern
- 2D array input, however spme exceptions to this could be problems that have 2D array as an input but are solved with other patterns, e.g graphs, dp, e.t.c

## Real World problems
- Image processing
- Computer graphics and gaming
- Data analysis and statics
- Machine learning




































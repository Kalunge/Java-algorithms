# Cyclic Sort
- cyclic sort is the repeated swapping of data elements in an array until they are seated in their appropriate positions. 
- it is a simple and efficient in-place sorting algorithm used for sorting arrays with integers in a specific range, most of the time[1 - n].
- it places each element in its correct position by iteratively swapping it with the element at the position where it should be located. 
- we know the correct position of an element because the value of the element - 1 is the correct position for the element.
- - we identify whether a cyclic sort is necessary for a given unsorted array by by identifying cycles which are nothing but the subsequences of numbers that are not in sorted order. 
- a cycle occurs when there is an element that is out of place, and swapping it with the element at its correct position moves another element out of place forming a cycle.
- unsorted arrays with in a range of [1-n] are guaranteed to have one or more cycles in them.
- the cyclic sorting algorithm identifies cycles and performs a cyclic sort as two seamlessly integrated and considered as one cohesive operation
- this pattern achieves a O(n) time complexity unlike nested loops as it manages to iteratively place each element in its correct position in one pass.
- it also does nt require any extra space as it does so in constant time.

## Limitations of cyclic sort
- **Limited range**: works well with known and limited range like [1-100] beyond that its performance is degraded.
- **Not stable**: it sometimes alters order especially with items of same value, thus would be inapporriate to use in instances where e.g priority is given to the first element where two elements are equal in value
- **Not suitable for non integer arrays**: '
- **Not suitable when multiple attributes play a significant role:** Cyclic sort is primarily designed for arrays of integers only, so it may not handle cases where the input has multiple attributes associated with it. For example, given an array containing objects representing employees, where each object has attributes such as name, age, and salary, if we need to sort the objects with respect to all three attributes then using cyclic sort on just salary may not produce the desired outcome. This is because the other two attributes play an equal role in deciding the final order, so we can’t just take one attribute while sorting the array.
- termination of a cyclic sort algorithm may be tricky when an array does not contain all the values in range [1-n]

## Does your problem match this pattern
- Yes if these conditions are fulfilled
**Limited range integer arrays**
**Finding missing or duplicate numbers**

- No if these conditions are fulfilled
**Non-integer values**
**Non-array Format**
**Stability requirement**

## Real world problems
**Computational biology** - find the missing gene in a dna sequence
**Playing card sorting**
**Data validation**
**Package delivery routing**
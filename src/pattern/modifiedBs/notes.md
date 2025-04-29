# Modified Binary Search
- this is an extension of the traditional Bs and can be applied to a variety of problems.

## Classic Binary Search Recap
- bs is an algorithm for searching a target element in a sorted array or Lists that support random access
- it follows a divide and conquer technique, reducing the search space with each iteration
- it proceeds as follows
  - set start and end index to first and last elements of the array respectively
  - calculate the middle index using the above - start + (end - start) / 2;
  - compare target element with the middle element if equal we just found it
  - if target is less that current index adjust end to mid - 1 and vice versa because the array is sorted.
  - proceed like that until element is found or search space is exhausted.
- this takes O(log N) as opossed to brute force which takes O(N);

## Modified Binary Search
- this involves modifying the classic BS discussed above to help solve enhanced/modified set of problems
- A few variations include
  - Binary search on a modified array eg sored and rotated around an unknown pivot. here we modify the BS to detect anormalies
  - Binary search with multiple requirements - eg finding a range or leftmost or rightmost occurrence of an element

## Examples
1. First and last position of an element in a sorted array.
- here we perform two binary searched one to find the left and the other to find the right occurrence

## Does your problem match this pattern
**Yes if**
- Target value in a sorted Data
- Partially sorted segments
**No if**
- Lack of direct addressing
- Unsorted or inappropriately sorted data to criteria relevant to search
- Non-value-based solutions - eg we cannot search for a name of a student in a list of names

## Real world problems
- Dictionary searches
- Range-based filtering
- String searching algorithms






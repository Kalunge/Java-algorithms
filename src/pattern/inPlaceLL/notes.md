- the in-place manipulation of a linked list is a pattern that helps us to manipulate a linked list without any extra memory
- in-place refers to an algorithm that does not need extra memory in proportion t the input size
- for instance in reversing a linked list, the naive approach would involve traversing the entire LL and come up with a new reversed LL which takes O(N) of space
- we can reverse this using this pattern by tracking the current, next and previous node and do this in constant space.


## Does your problem match this pattern
- Linked list restructuring
- In-place modification

## Real World problems
- File system management
- Memory management
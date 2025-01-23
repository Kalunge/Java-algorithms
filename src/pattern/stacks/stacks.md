# Stacks
- a stack is a linear data structure that organizes data in a Last In First out Manner
- the two main operations are pusha and pop - push to add an item to the top and pop to remove and return the said item
- the stack has a predefined capacity that if not well taken care of can lead to stackoverflow or stackunderflow errors
- stack overflow is whereby we try to push an element onto a stack already at capacity while stack underflow is trying to pop an element from an empty stack
- these two lead to memory related issues

| OPeration | Time Complexity | Description                                                       |
|---size----|----O(n)-----------|--------returns the total number of elements in the stack-----------------------------------------------------------|
| Push      | O(1)          | adds the element to the top of the stack                          |
| Pop       | O(1)          | removes and returns an element from the top of the stack          |
| Peek      |O(1)               | returns an element from the top of the stack without removing it  |
| isEmpty   |O(1)               | checks whether the stack is empty and returns appropriate boolean |


## Representations of a stack
**Array Based**
- here a stack is represented by an array of fied size
- elements are added and removed from one end which is the end of the array
- a pointer/index is used to keep track of the top of the stack - the pointer is incremented on pushing and decreemented on popping

**Linked List**
- each stack element is represented by a LL node, containing a data element and a pointer to the next node
- the top is represented by the head of the LL and on removal the head is removed.

## Uses of a Stack
- storage of elements with sequential dependencies these could be algorithms or a math expression where certain operators precedes others
- safe storage without arbitrary modifications from middle positions eg tracking bank transactions
- repeatedly mmodifying a stream of elements depending on predefined conditions - priority

## Does your probem fit this pattern
**Yes if**
- reverse order processing is required
- Nested structures handling
- State tracking or undoing operations
- Expression evaluations required

**No if**
- Order dependency - requires a different order or no order at all
- Random access
- Need for searching -  not efficient at all

## Real world problems
- Function call stack in programming
- Text editing - undo/redo functions
- Browser back and forward operations
- call history in smartphones










# Bitwise Manipulation
- in programming everything is stored in the computers memory in terms of 0s and 1s referred to as bits.
- **Bitwise manipulation** is the process of modifying bits algorithmically using bitwise operations
- these kind of operations are the fastest as processors natively support them
- these operations are the most efficient where we can convert ur input into binary or deal with the bits to get the desired outcome

## Categories of Binary numbers
- **Unsigned**:  these numbers represent nonnegative integers
- **Signed:** represent both positive and negative numbers. they include a sign bit (such as the leftmost bit in two's complement representation) to indicate the sign of the number


- a bitwise operation works on a **bit string**, **bit array**, or a **binary numerical.**
- These operations take bits as their operands and calculate the corresponding bit value in the resul. they include
**Logical NOT**: This is a unary operator that flips the value of the bit, if it is 1 we flip it to 0 and vice versa
**Logical AND**: this is a binary operator that evaluates two bits to 1 if both these bits are also 1, other wise the evaluated result is always 0.
**Logical OR**: this is a binary operator that evaluates two bits to 1 if a at least one bit is also 1, otherwise the evaluated result is always 0.
**Logical XOR**: This is a binary operator that evaluates tow bits to 1 only if both those bits are different. i.e one is 0 and the other is 1, otherwise, the evaluated result is always 0.
**Logical left Shift**: This is a binary operator that shifts all of the bits in an unsigned binary number to the left by specific number of places, filling the vacated bit(s) on the rights with zero(s).
  - each shift to the left will multiply the number by 2, so performing a shift n places to the left on a binary number is equivalent to multiplying the decimal representation of thet number by 2^n.
**Logical right shift**: thuis is a binary operator that shifts all the bits in an unsigned binary number to the right by a specific number of places, filling the vacated but(s) on the left with zero(s).
    - each shift to the right will divide the number by 2, so performing a shift n places to the right on a binary number is equivalent to dividing the decimal representation of that number by 2^n
**Arithmetic SHifts**: This is a binary operator that, unlike, logical shifts, maintains the sign bit(the leftmost bit) by keeping its position unchanged.
    - the remaining bits are shifted and the vacated bits are filled as follows

| Operation              | Sign     | Method                             |
|------------------------|----------|------------------------------------|
| Arithmetic left Shift  | Positive | Fill the vacated bits with zeros   |
| Arithmetic left Shift  | Negative | Fill the vacated bits with zeros   |
| Arithmetic right Shift | Positive | Fill the vacated bits with zeros   |
| Arithmetic right Shift | Negative | Fill the vacated bits with zeros   |
**Cyclic Shifts**: a binary operator where the bits of a binary number are shifted to the left or right , and the vacated bits are reintroduced at the opposite end.


## Does your problem match this pattern
- compression algorithms
- Status register
- Cryptography
- Hash Functions
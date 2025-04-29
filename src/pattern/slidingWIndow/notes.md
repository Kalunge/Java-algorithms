# Sliding Window
- the sliding wndow pattern is used to process sequential data eg arrays and strings to efficiently solve subarray or substring problems
- it involves maintaining a dynamic window that slides through the array or string, adjusting its boundaries as needed to track relevant elements or characters.
- it is a variation of the two pointers in which the pointers are used to set the window boundaries. 


## Does your problem match this pattern
Yes, if all these conditions are met
- **Contiguous data:** input data is stored in a contiguous manner eg an array or a string
- **Processing subsets of elements:** eg subarray or substring, the size of the window may be fixed or  variable depending on problem requirements
- **Efficient computation time complexity:** the computations performed every time the window moves take constant of very small time

## Real World Problems
1. **Telecommunications:** find the maximum number of users connected to a cellular network's base station in every k-milisecond sliding window
2. **Video streaming:** calculate median number of buffering events i each one-minute interval
3. **Social media content mining:** 
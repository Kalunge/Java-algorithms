# Top K Elements
- this is a pattern that hlps us efficiently find a specific number of elements, known as k, from a set of data. 
- it is particularly useful when identifying the largest/smallest or the most/least frequent elements from an unsorted collection
- to solve such tasks the solution that comes to mind would be to sort the collection which takes O(n log(n)) time, and then select the top elements which takes O(k) time
- however this pattern bypasses the need for full sorting , reducing the time complexity t O(n log k) by managing which elements we compare and keep track of
- a heap is the most appropriate data structure to use alongside this pattern, this is because a min/max heap helps us to track and fast access to the smallest or largest elements

## How it works
1. insert the first k elements from the given set of elements into a heap. if we are looking for the largest elements, use a min heap to keep the smallest of the large elements at the top. conversely if looking for the smallest elements, use a max heap to keep the largest of the smallest elements at the top of the heap.
2. iterate through the rest of the elements in the heap
   i. for a min heap, if we find an element larger than the top, remove the top(the smallest of the large elements) and insert the new larger element. This ensures the heap always contains the largest elements seen so far.
    ii. for a max heap, if we find a smaller element tha the top, remove the top element(the largest of the small elements) and insert the new, smaller element, keeping the heap filled with the smallest elements seen so far.
- the effciency of this pattern comes from the ability of the heap to insert and remove elements in O(log k) time. this is because we only maintain k elements in the heap, these operations are quick and we can process all n elements in the given set in O(n log k)
- it is important to note that while accessing the top element of the heap can be done in O(1) time, retreiving all k elements, if necessary, involves removing them one b one. this process takes O(k log k) time because each removal necessitates reorganizing the heap.


## Does My problem match this pattern
**Yes if these conditions are met and fulfiled**
- **Unsorted List analysis**
- **Identifying a specific subset**: when our problem use phrases like top k, kth largest/smallest, k most frequent, k closest, or k highest/lowest

**Not if these conditions are fulfilled**
 - **Presorted input**
 - **Single extreme value**

## Real World Problems
- **Location based services in ride-sharing apps like uber**
- **Performance analysis in financial markets**
- **Social media trend analysis**


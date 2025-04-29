# Knowing What To Track
- how would you know the most popular product to inform your ecommerce portal suggestion to customers?
- this pattern involves counting the frequencies of a data product and using this frequency information to solve the problem efficently
- **Counting hase** - this is whereby we iterate over a data structure like array or hashmap, and count the occurrence of a certain data element. 
- **Utilization Phase** this is whereby we use the frequency information to solve the problem, these problems include but are not limited to
  - find the most frequent element
  - identify elements that only occur once
  - check if two arrays are permutations of each other
  - check if the player wins the game
**Using HashMap**
- we store the elements as keys and their frequencies as values, 
  - if the key is not already in the hashMap we default it to 1 
  - if the key already exists we increment its frequency by 1
**Using Array**
- here, we utilize the array indexes to represent the elements and the corresponding values to those elements represent the frequencies of those elements. 
- we iterate over each element in our data set and we use the value of the element as an index in the array to access corresponding frequency counter. increement the frequency by 1
- as you might have notice we need to know the range beforehand and it needs to be a small range compared to the size of the dataset


## Does your problem match this pattern
- the problem involves frequency tracking
- Pattern recognition eg repetition
- problem involves a fixed set of possibilities e.g valid/invalid true/fasle yes/no

## Real world problems
- DNA sequence analysis
- Video streaming - most watched, revamp continue watching bar
- items recommendations in ecommerce
- clickstream analysis


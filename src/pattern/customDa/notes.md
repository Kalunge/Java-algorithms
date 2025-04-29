# Custom Data structures
- there comes a time when the basic data structures are not sufficient to solve certain problems either due to not fittingng the requirements or due to efficiency issues
- here we can use custom data structures
- these are data structures implemented using basic DSs but and unique features may be incorporated or behaviours added that are specific to the problem domain.
- custom data structures are thus modified basic data structures
- for instance, in building a web crawler we start with a set of seed uls, then visit each page, find linkes on each page, and follow those links to find more pages
- this means dealing with lots of pages and handling many urls
- critical challenges here are managing the urls efficiently while ensuring uniqueness and priority for certain page based on certain criteria.
- these challenges may not be solved using basic data structures like arrays, hash maps
- here, we need a custom data structure like a URL queue.
- this would be responsible for maintaining a queue of URLs to visit, ensuring uniqueness, and potentially prioritizing urls based on various criteria
- a custom data structure can be effectively implemented in class especially in Java.
- a class through its abstraction property is able to expose its functionalities throug methods and properties without users needing to understand the underlying implementation detals.
- implementing using a class moreover allows code reuse.
- commonly used data structures to make CDSs
1. Arrays
2. Linked List
3. Hash Map
4. Tree

## Does your problem match this pattern
- modification of an existing data structure
- Multiple data structures involved

## Real World Problems
**Video games:** custom data structure to store state, levels and other game details
**Customizing Search Engine:** for quick search and display
**Managing Car Parking:** allow efficent tracking of available spots, dynamically allocating spaces, handling reservations payments seamlessly in multi level oarking garages














# Hash Maps
- also known as a hash table, it is a data structure that stores key value pairs
- it allows for efficient retrival of a value associated with a gven key.
- they achieve this by using a hash function behind the hoods to compute keys.
- **Insert(key, value)** - here a hash code is computed based on the key and this determines the location of the key value pair, collisions can be addressed through chaining or open addressing. on average it takes conatsnant time for this operation howvere in cases f collision it may take 0(1)
- **Search(key)** - when we search, a hash for the key is computed to give the idnex which is the exact location, on average this takes constant time, howver in cases of collision and resizing this may take O(n)
- **Remove(key)** - here a hash based on the key is computed to give the location of the pair and the pair in thtat index is removed, this as  well takes an average of O(1) hwowvever in the face of collisions and resizing this may take 0(N)
- in the absence of a hash map, for instance in a case of storing a student and their marks, we would need to use two arrays, one for the names and theother for the marks. this would mean ensuring that they are in the same index in both arrays thus searching for a name would return an index taht would be used to search for the marks
- two important operations happen under the hood in the hashmap, collision resolution and hash computation.

## Does your problem match this pattern
- Data access - when we need frequent and fast data access during algorithm execution
- pair-wise relation - best usd in key word pairing data that is related

## Real world problems
- Telecommunications particulary in ponebook to store a name and a phone number
- Ecommerce - store a product object with its id
- File system - storing the file name against its unique path






















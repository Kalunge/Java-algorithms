# Trie
- A trie is a data structure used for string and locating keys from a set.
- they keys are usually strings that are stored character by character
- each node of the trie corresponds to a particular character rather the entire key

## Characteristics of a Trie
- the order of characters is represented by edges between the adjacent nodes.
- the level of nodes signifies the position of characters within a word. 
  - each level corresponds to a specific index in the word being represented
  - at any given level, each node represents to a distinct character in the words stored in the trie.
  - as we traverse down thr trie from the root to a leaf node, the characters encountered along the path collectively form the word associated with the path.
- it contains end-of-word nodes that mark the conclusion of a word within the trie structure
  - this is crucial for efficient word retrieval and validation operations
  - it allows the trie to distinguish between prefixes and complete words during searches or insertions

- this way of strings ensures that no extra space is required for storing common prefixes of strings.
- we can keep moving down the trie until a new character that is not present in the node's children is encountered and add it a s a new node.
- searches can also be performed using dfs by following the edges between the nodes
- essentially, in a trie, words with the same prefix or stem share the memory area that corresponds to the prefix.

## Staple Metods
**Insert(word)** 
- we start at the root and traverse down the trie, creating new nodes if required for each character for each string. 
- the time complexity for this method is O(m) where m is the length of the word
- this is because we have to traverse the trie through the length of the word

**Search(word)**
- we start at the root and traverse down the trie, following the path that corresponds the characters of the target word.
- if we encounter a null pointer or reach the end of a word before reaching a leaf node, the word is not present in the trie.
- the time complexity of this method id O(m) because we have to traverse the trie through the length of the word.

**Delete(word)**
- we start at the root and traverse down the trie, following the path that corresponds to the characters of the target word
- if found, remove the nodes corresponding to the characters of the string. this operation may also include cleanup to remove any unnecessary nodes to maintain thr trie's efficiency. 
- the time complexity of this method is O(m) because we have to traverse the trie through the length of the word.

## Compare trie to tree

|                 | Trie | Binary Tree     | Quartenary Tree |
|-----------------|--|-----------------|-----------------|---|
| Time complexity |  | O(logN - base 2 | O(logN - base 4 |   |

- there is an improvement in the performance even if it is by a constant factor.
- as out trees become wider and shorter te operations become more efficient as we dnt have to traverse as deep
- if we had an n-ary tree with the fan-out equal to the number of unique values in the given data set? for example, if we are considering Strings in English, the fan-out would be 26
- this makes the tree wider and shorter
- the maximum depth of the trie would be the maximum length of a word or string

## Does your problem match this pattern
- **Partial Matches:** we need to compare two strings to detect partial matches based on the initial characters of one or both strings
- **Space optimization:** storing common prefixes helps with this
- **Can break down the string:** problem statement allows breaking of a string down into characters

## Real World Problems
- **Autocomplete systems:** the suggestions are given based on common queries that users have searched already that match the prefix we have typed
- **Orthographic corrector:** pop-up suggestors or red lines while typing a message.
- **Prefix matching in IP addresses or URLs:** by storing IP prefixes or URL paths in a trie, firewalls and security devices can quickly mathc incoming traffic against a set of allowed or blocked prefixes for filtering purposes.



























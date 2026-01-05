# LRU Cache System (Java)

## Overview
This project implements a Least Recently Used (LRU) Cache in Java. The cache supports constant time get and put operations while maintaining a fixed capacity.

## Problem Statement
In systems with limited memory, frequently accessed data should be retrieved quickly. An LRU Cache removes the least recently used item when the cache reaches its capacity.

## Approach
- HashMap is used for O(1) access to cache entries
- Doubly Linked List is used to maintain usage order
- Most recently used items are moved to the front
- Least recently used items are evicted when capacity is exceeded

## Features
- O(1) get and put operations
- LRU eviction policy
- Cache hit and miss tracking

## How to Run
```
javac LRUCache.java Main.java
java Main
```
## Sample Output
```
10
-1
-1
30
40
Cache Hits: 3
Cache Misses: 2
```
## Learning Outcome
This project helped me understand how multiple data structures can be combined to solve real-world performance problems efficiently.

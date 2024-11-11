# Data Structures and Algorithms (DSA) CE204

This repository contains implementations of various data structures and algorithms in Java.

## Contents
- [Linked List](#linked-list)
- [Queue](#queue)
- [Stack](#stack)
- [Binary Search Tree](#binary-search-tree)
- [Priority Queue](#priority-queue)
- [How to Run](#how-to-run)

## Linked List

- [LinkedList.java](LinkedList/LinkedList.java): A generic implementation of a singly linked list in Java.
- [LinkedListADT.java](LinkedList/LinkedListADT.java): Defines the basic operations for the `LinkedList` interface.

### Operations and Time Complexities

- `add(T data)` - Add element at the end: **O(1)**
- `add(T data, int index)` - Add element at specific index: **O(n)**
- `remove(int index)` - Remove element at index: **O(n)**
- `remove(T data)` - Remove first occurrence of data: **O(n)**
- `get(int index)` - Get element at index: **O(n)**
- `size()` - Get the size of the list: **O(1)**
- `isEmpty()` - Check if the list is empty: **O(1)**
- `isCycle()` - Check if the list has a cycle: **O(n)**
- `makeCycle(int index)` - Create a cycle in the list at index: **O(n)**
- `sort()` - Sort the list: **O(n log n)**
- `print()` - Print the list elements: **O(n)**

## Queue

- [Queue.java](Queue/Queue.java): A generic implementation of a queue in Java.
- [QueueADT.java](Queue/QueueADT.java): Defines the basic operations for the `Queue` interface.

### Operations and Time Complexities

- `add(T data)` - Enqueue element: **O(1)**
- `remove()` - Dequeue element: **O(1)**
- `getBack()` - Get the last element: **O(1)**
- `isEmpty()` - Check if the queue is empty: **O(1)**
- `length()` - Get the length of the queue: **O(1)**
- `print()` - Print the queue elements: **O(n)**

## Stack

- [Stack.java](Stack/Stack.java): A generic implementation of a stack in Java.
- [StackADT.java](Stack/StackADT.java): Defines the basic operations for the `Stack` interface.

### Operations and Time Complexities

- `push(T data)` - Push element onto stack: **O(1)**
- `pop()` - Pop element from stack: **O(1)**
- `isEmpty()` - Check if the stack is empty: **O(1)**
- `length()` - Get the length of the stack: **O(1)**

## Binary Search Tree

- [BinarySearchTree.java](Tree/BinarySearchTree.java): A generic implementation of a binary search tree in Java.
- [TreeADT.java](Tree/TreeADT.java): Defines the basic operations for the `Tree` interface.

### Operations and Time Complexities

- `insert(T data)` - Insert element: **O(log n)** on average, **O(n)** worst-case
- `delete(T data)` - Delete element: **O(log n)** on average, **O(n)** worst-case
- `search(T data)` - Search for an element: **O(log n)** on average, **O(n)** worst-case
- `inOrderTraversal()` - In-order traversal: **O(n)**
- `preOrderTraversal()` - Pre-order traversal: **O(n)**
- `PostOrderTraversal()` - Post-order traversal: **O(n)**
- `isEmpty()` - Check if the tree is empty: **O(1)**
- `size()` - Get the size of the tree: **O(1)**

## Priority Queue

- [PriorityQueue.java](PriorityQueue/PriorityQueue.java): A generic implementation of a priority queue using a min-heap.
- [PriorityQueueADT.java](PriorityQueue/PriorityQueueADT.java): Defines the basic operations for the `PriorityQueue` interface.

### Operations and Time Complexities

- `insert(T item, int priority)` - Insert element with priority: **O(log n)**
- `next()` - Remove and return the element with the highest priority: **O(log n)**
- `isEmpty()` - Check if the priority queue is empty: **O(1)**
- `size()` - Get the size of the priority queue: **O(1)**

## How to Run

1. **Clone the repository:**

   ```bash
   git clone https://github.com/savka777/DSA-CE204.git

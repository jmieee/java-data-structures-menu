# Java Data Structures Menu System

An interactive console-based Java application that demonstrates the implementation and operations of four fundamental data structures: **Stack**, **Queue**, **Linked List**, and **Circular Linked List**.

## 🚀 Features

- **Interactive Menu System** - User-friendly console interface
- **Four Data Structures** implemented from scratch using linked nodes
- **Real-time Operations** - See changes after each operation
- **Input Validation** - Handles invalid inputs gracefully
- **Clean Code Structure** - Well-organized classes and methods

## 📊 Supported Data Structures

### 1. Stack (LIFO - Last In First Out)
- **Push** - Add element to top
- **Pop** - Remove element from top
- **Display** - Show all elements (top to bottom)

### 2. Queue (FIFO - First In First Out)
- **Enqueue** - Add element to rear
- **Dequeue** - Remove element from front
- **Display** - Show all elements (front to rear)

### 3. Singly Linked List
- **Insert at End** - Add element to the end of list
- **Delete at Beginning** - Remove first element
- **Display** - Show all elements (head to tail)

### 4. Circular Linked List
- **Insert** - Add element maintaining circular structure
- **Delete** - Remove element from beginning
- **Display** - Show all elements in circular order

## 💻 How to Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Command line interface or IDE

### Compilation and Execution
1. **Download the source code:**
   ```bash
   git clone https://github.com/yourusername/java-data-structures-menu.git
   cd java-data-structures-menu
   ```

2. **Compile the program:**
   ```bash
   javac MenuDrivenDS.java
   ```

3. **Run the application:**
   ```bash
   java MenuDrivenDS
   ```

## 📝 How the Code Works

### Core Architecture:
- **Node-based Implementation**: Each data structure uses custom node classes for dynamic memory allocation
- **Utility Methods**: Input validation and menu handling for better user experience
- **Encapsulation**: Each data structure is implemented as a separate inner class
- **Error Handling**: Proper handling of empty structures and invalid operations

### Key Components:

#### 1. Node Classes
```java
StackNode, QNode, LNode, CNode - Building blocks for each structure
```

#### 2. Data Structure Classes
- `IntStack` - Linked list implementation of stack
- `IntQueue` - Linked list implementation with head/tail pointers
- `SinglyLinkedList` - Basic linked list with head/tail tracking
- `CircularLinkedList` - Circular structure with tail pointer

#### 3. Menu System
- Input validation with `readInt()` and `menuChoice()`
- Separate menu methods for each data structure
- Clean navigation between different operations

## 📋 Sample Run/Output

```
----------------------------------------

Choose Data Structure:
1. Stack
2. Queue
3. Linked List
4. Circular Linked List
0. Exit
Enter choice: 1

----------------------------------------

--- Stack Operations ---
1. Push
2. Pop
3. Display
0. Back to Main Menu
Enter choice: 1
Enter value to push: 10
Pushed 10 into stack.
Stack contents (top→bottom): 10

--- Stack Operations ---
1. Push
2. Pop
3. Display
0. Back to Main Menu
Enter choice: 1
Enter value to push: 20
Pushed 20 into stack.
Stack contents (top→bottom): 20 10

--- Stack Operations ---
1. Push
2. Pop
3. Display
0. Back to Main Menu
Enter choice: 2
Popped: 20
Stack contents (top→bottom): 10

--- Stack Operations ---
1. Push
2. Pop
3. Display
0. Back to Main Menu
Enter choice: 3
Stack contents (top→bottom): 10
```

### Queue Example Output:
```
--- Queue Operations ---
1. Enqueue
2. Dequeue
3. Display
0. Back to Main Menu
Enter choice: 1
Enter value to enqueue: 5
Enqueued 5 into queue.
Queue contents (front→rear): 5

Enter choice: 1
Enter value to enqueue: 15
Enqueued 15 into queue.
Queue contents (front→rear): 5 15

Enter choice: 2
Dequeued: 5
Queue contents (front→rear): 15
```

## 🏗️ Code Structure

```
MenuDrivenDS.java
├── Utility Methods
│   ├── readInt() - Input validation
│   ├── menuChoice() - Menu selection validation
│   └── printDivider() - UI formatting
├── Data Structure Classes
│   ├── IntStack (with StackNode)
│   ├── IntQueue (with QNode)
│   ├── SinglyLinkedList (with LNode)
│   └── CircularLinkedList (with CNode)
├── Menu Methods
│   ├── stackMenu()
│   ├── queueMenu()
│   ├── linkedListMenu()
│   └── circularListMenu()
└── Main Method - Program entry point
```

## ✨ Key Learning Outcomes

- **Data Structure Implementation** - Understanding how fundamental structures work internally
- **Memory Management** - Dynamic allocation using linked nodes
- **User Interface Design** - Creating intuitive console applications
- **Error Handling** - Robust input validation and edge case management
- **Code Organization** - Clean, modular programming practices

## 👨‍💻 Author

**[Your Name]**  
*[Your Course/Subject]*  
*[Date: September 2025]*

## 📄 License

This project is created for educational purposes as part of academic coursework.
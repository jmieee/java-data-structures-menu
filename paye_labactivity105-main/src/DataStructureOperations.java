import java.util.Scanner;

interface DataStructure {
    void menu(Scanner scanner);
}

// ---------------- STACK ----------------
class Stack implements DataStructure {
    private int[] stack;
    private int top;
    private static final int SIZE = 10;

    public Stack() {
        stack = new int[SIZE];
        top = -1;
    }

    public void push(int value) {
        if (top == SIZE - 1) {
            System.out.println("⚠️ Stack Overflow!");
        } else {
            stack[++top] = value;
            System.out.println("✅ Pushed " + value);
        }
    }

    public void pop() {
        if (top == -1) {
            System.out.println("⚠️ Stack Underflow!");
        } else {
            System.out.println("✅ Popped " + stack[top--]);
        }
    }

    public void display() {
        if (top == -1) {
            System.out.println("📭 Stack is empty.");
        } else {
            System.out.print("📌 Stack: ");
            for (int i = top; i >= 0; i--) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void menu(Scanner scanner) {
        int choice;
        do {
            System.out.println("\n--- STACK ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("0. Back");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter value: ");
                    push(scanner.nextInt());
                }
                case 2 -> pop();
                case 3 -> display();
            }
        } while (choice != 0);
    }
}

// ---------------- QUEUE ----------------
class Queue implements DataStructure {
    private int[] queue;
    private int front, rear;
    private static final int SIZE = 10;

    public Queue() {
        queue = new int[SIZE];
        front = rear = -1;
    }

    public void enqueue(int value) {
        if (rear == SIZE - 1) {
            System.out.println("⚠️ Queue Overflow!");
        } else {
            if (front == -1) front = 0;
            queue[++rear] = value;
            System.out.println("✅ Enqueued " + value);
        }
    }

    public void dequeue() {
        if (front == -1) {
            System.out.println("⚠️ Queue Underflow!");
        } else {
            System.out.println("✅ Dequeued " + queue[front]);
            if (front == rear) {
                front = rear = -1;
            } else {
                front++;
            }
        }
    }

    public void display() {
        if (front == -1) {
            System.out.println("📭 Queue is empty.");
        } else {
            System.out.print("📌 Queue: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void menu(Scanner scanner) {
        int choice;
        do {
            System.out.println("\n--- QUEUE ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("0. Back");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter value: ");
                    enqueue(scanner.nextInt());
                }
                case 2 -> dequeue();
                case 3 -> display();
            }
        } while (choice != 0);
    }
}

// ---------------- LINKED LIST ----------------
class LinkedList implements DataStructure {
    private static class Node {
        int data;
        Node next;
        Node(int d) { data = d; }
    }

    private Node head;

    public void insertAtEnd(int value) {
        Node newNode = new Node(value);
        if (head == null) head = newNode;
        else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
        }
        System.out.println("✅ Inserted " + value);
    }

    public void deleteAtBeginning() {
        if (head == null) {
            System.out.println("⚠️ List is empty.");
        } else {
            System.out.println("✅ Deleted " + head.data);
            head = head.next;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("📭 List is empty.");
        } else {
            System.out.print("📌 LinkedList: ");
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    @Override
    public void menu(Scanner scanner) {
        int choice;
        do {
            System.out.println("\n--- LINKED LIST ---");
            System.out.println("1. Insert at End");
            System.out.println("2. Delete at Beginning");
            System.out.println("3. Display");
            System.out.println("0. Back");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter value: ");
                    insertAtEnd(scanner.nextInt());
                }
                case 2 -> deleteAtBeginning();
                case 3 -> display();
            }
        } while (choice != 0);
    }
}

// ---------------- CIRCULAR LINKED LIST ----------------
class CircularLinkedList implements DataStructure {
    private static class Node {
        int data;
        Node next;
        Node(int d) { data = d; }
    }

    private Node head = null, tail = null;

    public void insert(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        System.out.println("✅ Inserted " + value);
    }

    public void delete() {
        if (head == null) {
            System.out.println("⚠️ List is empty.");
        } else if (head == tail) {
            System.out.println("✅ Deleted " + head.data);
            head = tail = null;
        } else {
            System.out.println("✅ Deleted " + head.data);
            head = head.next;
            tail.next = head;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("📭 List is empty.");
        } else {
            System.out.print("📌 Circular List: ");
            Node temp = head;
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != head);
            System.out.println();
        }
    }

    @Override
    public void menu(Scanner scanner) {
        int choice;
        do {
            System.out.println("\n--- CIRCULAR LINKED LIST ---");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Display");
            System.out.println("0. Back");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter value: ");
                    insert(scanner.nextInt());
                }
                case 2 -> delete();
                case 3 -> display();
            }
        } while (choice != 0);
    }
}

// ---------------- MAIN ----------------
public class DataStructureOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataStructure ds = null;
        int choice;

        do {
            System.out.println("\n==== DATA STRUCTURE MENU ====");
            System.out.println("1. Stack");
            System.out.println("2. Queue");
            System.out.println("3. Linked List");
            System.out.println("4. Circular Linked List");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> ds = new Stack();
                case 2 -> ds = new Queue();
                case 3 -> ds = new LinkedList();
                case 4 -> ds = new CircularLinkedList();
                case 0 -> {
                    System.out.println("👋 Exiting...");
                    return;
                }
                default -> {
                    System.out.println("❌ Invalid choice!");
                    continue;
                }
            }
            ds.menu(scanner);

        } while (choice != 0);
    }
}

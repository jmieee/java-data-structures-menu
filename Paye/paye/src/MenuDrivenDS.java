import java.util.Scanner;

public class MenuDrivenDS {

    // ---------- Utilities ----------
    private static int readInt(Scanner sc, String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. Enter an integer: ");
            sc.next();
        }
        return sc.nextInt();
    }

    private static int menuChoice(Scanner sc, String prompt, int min, int max) {
        int x = readInt(sc, prompt);
        while (x < min || x > max) {
            x = readInt(sc, "Please enter a valid choice (" + min + "-" + max + "): ");
        }
        return x;
    }

    private static void printDivider() {
        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println();
    }

    // ---------- Stack (Singly Linked) ----------
    private static class StackNode {
        int data;
        StackNode next;
        StackNode(int d) { 
            data = d; 
        }
    }
    
    private static class IntStack {
        private StackNode top;

        public void push(int val) {
            StackNode n = new StackNode(val);
            n.next = top;
            top = n;
        }
        
        public Integer pop() {
            if (top == null) return null;
            int v = top.data;
            top = top.next;
            return v;
        }
        
        @SuppressWarnings("unused")
        public boolean isEmpty() { 
            return top == null; 
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            StackNode cur = top;
            while (cur != null) {
                sb.append(cur.data).append(" ");
                cur = cur.next;
            }
            return sb.length() == 0 ? "(empty)" : sb.toString().trim();
        }
    }

    // ---------- Queue (Singly Linked, head/tail) ----------
    private static class QNode {
        int data;
        QNode next;
        QNode(int d) { 
            data = d; 
        }
    }
    
    private static class IntQueue {
        private QNode head; // front
        private QNode tail; // rear

        public void enqueue(int val) {
            QNode n = new QNode(val);
            if (tail == null) {
                head = tail = n;
            } else {
                tail.next = n;
                tail = n;
            }
        }
        
        public Integer dequeue() {
            if (head == null) return null;
            int v = head.data;
            head = head.next;
            if (head == null) tail = null;
            return v;
        }
        
        @SuppressWarnings("unused")
        public boolean isEmpty() { 
            return head == null; 
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            QNode cur = head;
            while (cur != null) {
                sb.append(cur.data).append(" ");
                cur = cur.next;
            }
            return sb.length() == 0 ? "(empty)" : sb.toString().trim();
        }
    }

    // ---------- Singly Linked List (insert at end, delete at beginning) ----------
    private static class LNode {
        int data;
        LNode next;
        LNode(int d) { 
            data = d; 
        }
    }
    
    private static class SinglyLinkedList {
        private LNode head, tail;

        // insert at end
        public void insertEnd(int val) {
            LNode n = new LNode(val);
            if (head == null) {
                head = tail = n;
            } else {
                tail.next = n;
                tail = n;
            }
        }
        
        // delete at beginning
        public Integer deleteBegin() {
            if (head == null) return null;
            int v = head.data;
            head = head.next;
            if (head == null) tail = null;
            return v;
        }
        
        @SuppressWarnings("unused")
        public boolean isEmpty() { 
            return head == null; 
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            LNode cur = head;
            while (cur != null) {
                sb.append(cur.data).append(" ");
                cur = cur.next;
            }
            return sb.length() == 0 ? "(empty)" : sb.toString().trim();
        }
    }

    // ---------- Circular Linked List (tail.next = head) ----------
    private static class CNode {
        int data;
        CNode next;
        CNode(int d) { 
            data = d; 
        }
    }
    
    private static class CircularLinkedList {
        private CNode tail; // if not null, tail.next is head

        // insert at end (after tail)
        public void insertEnd(int val) {
            CNode n = new CNode(val);
            if (tail == null) {
                tail = n;
                tail.next = tail; // single node points to itself
            } else {
                n.next = tail.next; // new node points to head
                tail.next = n;      // old tail points to new node
                tail = n;           // update tail
            }
        }

        // delete at beginning (remove head = tail.next)
        public Integer deleteBegin() {
            if (tail == null) return null;
            CNode head = tail.next;
            int v = head.data;
            if (head == tail) { // one node
                tail = null;
            } else {
                tail.next = head.next; // bypass old head
            }
            return v;
        }

        @SuppressWarnings("unused")
        public boolean isEmpty() { 
            return tail == null; 
        }

        @Override
        public String toString() {
            if (tail == null) return "(empty)";
            StringBuilder sb = new StringBuilder();
            CNode head = tail.next;
            CNode cur = head;
            do {
                sb.append(cur.data).append(" ");
                cur = cur.next;
            } while (cur != head);
            return sb.toString().trim();
        }
    }

    // ---------- Menus ----------
    private static void stackMenu(Scanner sc) {
        IntStack stack = new IntStack();
        while (true) {
            printDivider();
            System.out.println("--- Stack Operations ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("0. Back to Main Menu");
            int choice = menuChoice(sc, "Enter choice: ", 0, 3);

            if (choice == 0) return;

            switch (choice) {
                case 1:
                    int val = readInt(sc, "Enter value to push: ");
                    stack.push(val);
                    System.out.println("Pushed " + val + " into stack.");
                    System.out.println("Stack contents (top→bottom): " + stack);
                    break;
                case 2:
                    Integer popped = stack.pop();
                    if (popped == null) {
                        System.out.println("Stack underflow. Stack is empty.");
                    } else {
                        System.out.println("Popped: " + popped);
                    }
                    System.out.println("Stack contents (top→bottom): " + stack);
                    break;
                case 3:
                    System.out.println("Stack contents (top→bottom): " + stack);
                    break;
            }
        }
    }

    private static void queueMenu(Scanner sc) {
        IntQueue q = new IntQueue();
        while (true) {
            printDivider();
            System.out.println("--- Queue Operations ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("0. Back to Main Menu");
            int choice = menuChoice(sc, "Enter choice: ", 0, 3);

            if (choice == 0) return;

            switch (choice) {
                case 1:
                    int val = readInt(sc, "Enter value to enqueue: ");
                    q.enqueue(val);
                    System.out.println("Enqueued " + val + " into queue.");
                    System.out.println("Queue contents (front→rear): " + q);
                    break;
                case 2:
                    Integer deq = q.dequeue();
                    if (deq == null) {
                        System.out.println("Queue underflow. Queue is empty.");
                    } else {
                        System.out.println("Dequeued: " + deq);
                    }
                    System.out.println("Queue contents (front→rear): " + q);
                    break;
                case 3:
                    System.out.println("Queue contents (front→rear): " + q);
                    break;
            }
        }
    }

    private static void linkedListMenu(Scanner sc) {
        SinglyLinkedList list = new SinglyLinkedList();
        while (true) {
            printDivider();
            System.out.println("--- Linked List Operations ---");
            System.out.println("1. Insert at end");
            System.out.println("2. Delete at beginning");
            System.out.println("3. Display");
            System.out.println("0. Back to Main Menu");
            int choice = menuChoice(sc, "Enter choice: ", 0, 3);

            if (choice == 0) return;

            switch (choice) {
                case 1:
                    int val = readInt(sc, "Enter value to insert at end: ");
                    list.insertEnd(val);
                    System.out.println("Inserted " + val + " at end.");
                    System.out.println("List contents (head→tail): " + list);
                    break;
                case 2:
                    Integer del = list.deleteBegin();
                    if (del == null) {
                        System.out.println("List is empty. Nothing to delete.");
                    } else {
                        System.out.println("Deleted from beginning: " + del);
                    }
                    System.out.println("List contents (head→tail): " + list);
                    break;
                case 3:
                    System.out.println("List contents (head→tail): " + list);
                    break;
            }
        }
    }

    private static void circularListMenu(Scanner sc) {
        CircularLinkedList clist = new CircularLinkedList();
        while (true) {
            printDivider();
            System.out.println("--- Circular Linked List Operations ---");
            System.out.println("1. Insert (at end)");
            System.out.println("2. Delete (at beginning)");
            System.out.println("3. Display");
            System.out.println("0. Back to Main Menu");
            int choice = menuChoice(sc, "Enter choice: ", 0, 3);

            if (choice == 0) return;

            switch (choice) {
                case 1:
                    int val = readInt(sc, "Enter value to insert: ");
                    clist.insertEnd(val);
                    System.out.println("Inserted " + val + " (at end).");
                    System.out.println("Circular list (head→...→head): " + clist);
                    break;
                case 2:
                    Integer del = clist.deleteBegin();
                    if (del == null) {
                        System.out.println("Circular list is empty. Nothing to delete.");
                    } else {
                        System.out.println("Deleted from beginning: " + del);
                    }
                    System.out.println("Circular list (head→...→head): " + clist);
                    break;
                case 3:
                    System.out.println("Circular list (head→...→head): " + clist);
                    break;
            }
        }
    }

    // ---------- Main ----------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            printDivider();
            System.out.println("Choose Data Structure:");
            System.out.println("1. Stack");
            System.out.println("2. Queue");
            System.out.println("3. Linked List");
            System.out.println("4. Circular Linked List");
            System.out.println("0. Exit");
            int choice = menuChoice(sc, "Enter choice: ", 0, 4);

            switch (choice) {
                case 0:
                    System.out.println("Goodbye!");
                    return;
                case 1:
                    stackMenu(sc);
                    break;
                case 2:
                    queueMenu(sc);
                    break;
                case 3:
                    linkedListMenu(sc);
                    break;
                case 4:
                    circularListMenu(sc);
                    break;
            }
        }
    }
}
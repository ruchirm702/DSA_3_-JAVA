/*
Node class represents a node in a singly linked list
Function to get the node at the nth position in the linked list
Function to add a new node with data at the beginning of the linked list
Function to add a new node with data at a specific index in the linked list
Function to remove a node at a specific index in the linked list
Function to get the size of the linked list
Function to display the elements of the linked list
Main function demonstrating the usage of the linked list functions
Main function to start the program
*/


class Main {
    
    // Node class represents a node in a singly linked list
    public static class Node {
        int data;
        Node next;
        
        // Constructor to initialize a node with the given data
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    // Variable to store the size of the linked list
    public static int size;

    // Function to get the node at the nth(index - 1) position in the linked list
    public static Node getNthNode(Node head, int k) {
        // Start with the head of the linked list
        Node temp = head;
    
        // Traverse the linked list until the desired position (k) is reached
        for (int i = 1; i <= k; i++) {
            // Move to the next node in the list
            temp = temp.next;
        }
    
        // Return the node at the desired position (k)
        return temp;
    }
    
    
    // Function to add a new node with data at the beginning of the linked list
    public static Node addFirst(Node head, int data) {
        // Increment the size of the linked list
        size++;
    
        // Create a new node with the provided data
        Node nn = new Node(data);
    
        // Check if the linked list is empty (head is null)
        if (head == null) {
            // If the linked list is empty, set the head to the new node
            head = nn;
        } else {
            // If the linked list is not empty,
            // Make the new node point to the current head
            nn.next = head;
    
            // Update the head to be the new node
            head = nn;
        }
    
        // Return the updated head of the linked list
        return head;
    }
    
    
    // Function to add a new node with data at a specific index in the linked list
    public static Node addAt(Node head, int data, int indx) {
        Node nn = new Node(data);
        size++;
        if (indx == 0) {
            // Add at the beginning
            nn.next = head;
            head = nn;
        } else {
            // Find the (indx-1)th node
            Node temp = getNthNode(head, indx - 1);
            // Make the linkage
            nn.next = temp.next;
            temp.next = nn;
        }
        return head;
    }
    
    // Function to remove a node at a specific index in the linked list
    public static Node removeAt(Node head, int indx) {
        if (indx < 0 || indx >= size) {
            System.out.println("Invalid index. Removal failed.");
            return head;
        }

        if (indx == 0) {
            // Remove the first node
            head = head.next;
        } else {
            // Find the (indx-1)th node
            Node temp = getNthNode(head, indx - 1);
            
            if (temp == null || temp.next == null) {
                System.out.println("Invalid index. Removal failed.");
                return head;
            }

            // Update the linkage
            temp.next = temp.next.next;
        }
        size--;
        System.out.println("Node at index " + indx + " removed successfully.");
        return head;
    }
    
    // Function to get the size of the linked list
    public static int size() {
        return size;
    }
    
    // Function to display the elements of the linked list along with the current size
    public static void display(Node head) {
        Node temp = head;
        System.out.print("Linked List: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
        System.out.println("Size of the Linked List: " + size());
        System.out.println();
    }

    // Main function demonstrating the usage of the linked list functions
    public static void fun() {
        Node head = null;
        size = 0;

        // Add elements to the linked list
        head = addFirst(head, 10);
        head = addFirst(head, 20);
        head = addFirst(head, 30);
        head = addFirst(head, 40);
        head = addFirst(head, 50);
        head = addFirst(head, 60);

        // Display the linked list
        display(head);

        // Add a node at a specific index
        head = addAt(head, 65, 1);
        display(head);

        // Add a node at a different index
        head = addAt(head, 15, 5);
        display(head);

        // Display the size of the linked list
        // System.out.println("Size of the Linked List: " + size()); // Remove this line

        // Remove a node at a specific index
        head = removeAt(head, 3);
        display(head);

        // Remove a node at a different index
        head = removeAt(head, 6);
        display(head);

        // Display the updated size of the linked list
        System.out.println("Updated Size of the Linked List: " + size());
    }

    // Main function to start the program
    public static void main(String args[]) {
        fun();
    }
}

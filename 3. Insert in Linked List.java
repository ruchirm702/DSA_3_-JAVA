/* Problem Description
You are given A which is the head of a linked list. Also given is the value B and position C. 
Complete the function that should insert a new node with the said value at the given position.

Notes:
In case the position is more than length of linked list, simply insert the new node at the tail only.
In case the pos is 0, simply insert the new node at head only.
Follow 0-based indexing for the node numbering.

Problem Constraints
1 <= size of linked list <= 10^5
1 <= value of nodes <= 10^9
1 <= B <= 10^9
0 <= C <= 10^5
Input Format
The first argument A is the head of a linked list.
The second argument B is an integer which denotes the value of the new node
The third argument C is an integer which denotes the position of the new node

Output Format
Return the head of the linked list
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static class ListNode {
        public int val;
        public ListNode next;

        // Constructor to initialize a ListNode
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * Insert a new node with value B at position C in the linked list.
     *
     * @param A Head of the linked list
     * @param B Value of the new node
     * @param C Position where the new node should be inserted
     * @return Head of the updated linked list
     */
    
    public static ListNode insertAtPosition(ListNode A, int B, int C) {
        ListNode newNode = new ListNode(B);

        // Edge case: Insert at the head if position is 0
        if (C == 0) {
            newNode.next = A;
            return newNode;
        } else {
            // Traverse the list to find the (C-1)th node
            ListNode temp = A;
            for (int i = 0; i < C - 1 && temp.next != null; i++) {
                temp = temp.next;
            }

            // Link the new node to the next node and update the links
            newNode.next = temp.next;
            temp.next = newNode;
        }

        return A;
    }

    // Main method to demonstrate the linked list insertion
    
    public static void main(String[] args) {
        
        // Create a linked list: 1 -> 2 -> 3 -> 4
        
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        // Insert value 5 at position 2
        ListNode updatedHead = insertAtPosition(head, 5, 2);

        // Print the updated linked list
        ListNode current = updatedHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}

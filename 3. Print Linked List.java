/* Problem Description
You are given A which is the head of a linked list. Print the linked list in space separated manner.
Note : The last node value must also be succeeded by a space and after printing the entire list you should print a new line

    Problem Constraints
1 <= size of linked list <= 10^5
1 <= value of nodes <= 10^9

    Input Format
The first argument A is the head of a linked list.

Output Format
You dont need to return anything
*/

import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    
    // Definition of ListNode class
    static class ListNode {
        public int val;
        public ListNode next;
        
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // Method to print the linked list
    public static void printLinkedList(ListNode head) {
        ListNode temp = head;

        // Traverse the list and print each node's value followed by a space
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

        // Print a new line after printing the entire list
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        // Example 1
        ListNode head1 = new ListNode(11);
        head1.next = new ListNode(32);
        head1.next.next = new ListNode(43);

        System.out.println("Output 1:");
        printLinkedList(head1);  // Expected Output: 11 32 43 

        // Example 2
        ListNode head2 = new ListNode(4);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(2);
        head2.next.next.next = new ListNode(1);

        System.out.println("Output 2:");
        printLinkedList(head2);  // Expected Output: 4 3 2 1
    }
}

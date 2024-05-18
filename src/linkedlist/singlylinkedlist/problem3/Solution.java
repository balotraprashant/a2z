package linkedlist.singlylinkedlist.problem3;

// Node class definition
class Node {
    int data;
    Node next;
    // Constructor with both data and next pointer
    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
    // Constructor with only data (next pointer set to null)
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
// LinkedList class
public class Solution {
    public static void deleteNode(Node node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }
    // Function to delete the tail of the linked list
    public static Node deleteTail(Node head) {
        // Check if the linked list is empty or has only one node
        if (head == null || head.next == null)
            return null;
        // Create a temporary pointer for traversal
        Node temp = head;
        // Traverse the list until the second-to-last node
        while (temp.next.next != null) {
            temp = temp.next;
        }
        // Nullify the connection from the second-to-last node to delete the last node
        temp.next = null;
        // Return the updated head of the linked list
        return head;
    }
    // Function to print the linked list
    private static void printLL(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    // Main method
    public static void main(String[] args) {
        // Initialize an array with integer values
        int[] arr = {2, 5, 8, 7};
        int[] arr2 = {2, 5, 8, 7};
        // Create the linked list with nodes initialized with array values
        Node head = new Node(arr[0]);
        head.next = new Node(arr[1]);
        head.next.next = new Node(arr[2]);
        head.next.next.next = new Node(arr[3]);
        // Delete the tail of the linked list
        head = deleteTail(head);

        Node head2 = new Node(arr[0]);
        head2.next = new Node(arr[1]);
        head2.next.next = new Node(arr[2]);
        head2.next.next.next = new Node(arr[3]);

        Node node = head2.next;
        deleteNode(node);
        // Print the modified linked list
        printLL(head);
        System.out.println();
        printLL(head2);
    }
}
///**
// * Definition for singly-linked list.
// * public class ListNode {
// *     int val;
// *     ListNode next;
// *     ListNode(int x) { val = x; }
// * }
// */
//class Solution {
//    public void deleteNode(Node node) {
//        node.val = node.next.val;
//        node.next = node.next.next;
//    }
//
//    // Function to delete the tail of the linked list
//    public static Node deleteTail(ListNode head) {
//        // Check if the linked list is empty or has only one node
//        if (head == null || head.next == null)
//            return null;
//        // Create a temporary pointer for traversal
//        ListNode temp = head;
//        // Traverse the list until the second-to-last node
//        while (temp.next.next != null) {
//            temp = temp.next;
//        }
//        // Nullify the connection from the second-to-last node to delete the last node
//        temp.next = null;
//        // Return the updated head of the linked list
//        return head;
//    }
//}

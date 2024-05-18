package linkedlist.singlylinkedlist.problem5;

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }

} 

public class Solution {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            for (int i = 0; i < n - 1; i++) {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            int key = sc.nextInt();
            LinkedList g = new LinkedList();
            boolean ans = g.searchKey(n, head, key);
            System.out.println(ans ? "1" : "0");
            // printList(head);
            t--;
        }
    }
}
// } Driver Code Ends

class LinkedList {
    static boolean searchKey(int n, Node head, int key) {
        // Code here
        while(head!=null){
            if(head.data==key) return true;
            
            head=head.next;
        }
        
        return false;
    }
}

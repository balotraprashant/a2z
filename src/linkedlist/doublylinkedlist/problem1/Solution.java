package linkedlist.doublylinkedlist.problem1;

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int x) {
        data = x;
        next = null;
        prev= null;
    }

} 
public class Solution {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int []arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
                
            }
            
            DoublyLinkedList obj = new DoublyLinkedList();
            Node ans = obj.constructDLL(arr);
            while(ans!=null){
                System.out.print(ans.data+" ");
                ans=ans.next;
            }
            System.out.println();
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class DoublyLinkedList {
    Node constructDLL(int arr[]) {
        // Code here
        Node head = new Node(arr[0]);
        Node temp = head;
        
        for(int i=1; i<arr.length; i++) {
            Node node = new Node(arr[i]);
            temp.next = node;
            node.prev = temp;
            temp = temp.next;
        }
        
        return head;
    }
}

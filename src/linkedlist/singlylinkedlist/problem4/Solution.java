package linkedlist.singlylinkedlist.problem4;

import java.util.*;

class Node{
    int data;
    Node next;
    
    Node(int a){
        data = a;
        next = null;
    }
    
}

class LinkedList
{
    //Function to count nodes of a linked list.
    public static int getCount(Node head)
    {
        int count = 0;
        while(head!=null) {
            head = head.next;
            count++;
        }
        return count;
        //Code here
    }
}
    

//{ Driver Code Starts.
public class Solution{
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            
            LinkedList ob = new LinkedList();
            System.out.println(ob.getCount(head));
        }
    }   
}

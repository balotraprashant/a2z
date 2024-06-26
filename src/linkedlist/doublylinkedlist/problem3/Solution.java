package linkedlist.doublylinkedlist.problem3;

//{ Driver Code Starts
//Initial Template for Java
import java.util.*;

class Node
{
    int data;
    Node next;
    Node prev;
    Node(int d)
    {
        data = d;
        next = prev = null;
    }
}
class Delete_Node_From_DLL
{
    Node head;
    Node tail;

    void addToTheLast(Node node)
    {
        if(head ==  null)
        {
            head = node;
            tail = node;
        }
        else
        {
            tail.next = node;
            tail.next.prev = tail;
            tail = tail.next;
        }
    }

    void printList(Node head)
    {	Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data+" ");
            temp =  temp.next;
        }
        System.out.println();
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int n = sc.nextInt();
            Delete_Node_From_DLL list = new Delete_Node_From_DLL();

            int a1 = sc.nextInt();
            Node head = new Node(a1);
            list.addToTheLast(head);

            for(int i=1;i<n;i++)
            {
                int a = sc.nextInt();
                list.addToTheLast(new Node(a));
            }
            a1 = sc.nextInt();
            Solution g = new Solution();
            //System.out.println(list.temp.data);
            Node ptr = g.deleteNode(list.head, a1);
            list.printList(ptr);
            t--;
        }
    }
}



// } Driver Code Ends


//User function Template for Java

/* Structure of linkedlist node
class Node
{
	int data;
	Node next;
	Node prev;
	Node(int d)
	{
		data = d;
		next = prev = null;
	}
}
*/
public class Solution
{
    // function returns the head of the linkedlist
    Node deleteNode(Node head,int x) {
	    // Your code here
        if(head==null||x==0) {
            return null;
        }
        
        if(x==1) {
            head=head.next;
            head.prev=null;
            return head;
        }
        
        Node curr = head;
        int i=1;
        
        while(i<x) {
            curr = curr.next;
            i++;
        }
        
        Node temp1 = curr.prev!=null ? curr.prev : null;
        Node temp2 = curr.next!=null ? curr.next : null;
        
        if(temp1!=null) {
            temp1.next = temp2;        
        }
        if(temp2!=null) {
            temp2.prev = temp1;   
        }
        
        return head;
    }
}

package linkedlist.easy.problem1;

// Definition for singly-linked list.
class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1==null && list2==null) {
            return list1;
        } else if(list1==null) {
            return list2;
        } else if(list2==null) {
            return list1;
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;

        while(list1 != null && list2 != null) {
            if(list1.val > list2.val) {
                temp.next = new ListNode(list2.val);
                list2 = list2.next;
            } else {
                temp.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            temp = temp.next;
        }

        if(list1 != null) {
            temp.next = list1;
        }

        if(list2 != null) {
            temp.next = list2;
        }

        return dummyNode.next;
    }
}

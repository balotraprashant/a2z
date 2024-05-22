**Problem Statement**: Given a doubly linked list of n elements. Your task is to reverse the doubly linked list in-place.

Link: https://www.geeksforgeeks.org/problems/reverse-a-doubly-linked-list/1

Example 1:
```
Input Format:
DLL: 1 <-> 2 <-> 3 <-> 4
```
![image](https://github.com/balotraprashant/a2z/assets/69639884/e0f1326b-054f-449d-94ca-41ee392b5e89)
```
Result: DLL: 30 <-> 20 <-> 10
```
Explanation: In this case, the doubly linked list is reversed and its former tail is returned as its new head.

--------------------------------------------------------------------------------------------------------------

**Brute Force Approach**

A brute-force approach involves replacing data in a doubly linked list. First, we traverse the list and store node data in a stack. Then, in a second pass, we assign elements from the stack to nodes, ensuring a reverse order replacement since stacks follow the Last-In-First-Out (LIFO) principle.

Algorithm:

**Step 1**: Initialization a temp pointer to the head of the doubly linked list and a stack data structure to store the values from the list.

![image](https://github.com/balotraprashant/a2z/assets/69639884/74d16b97-373b-437e-93d7-604a47c26297)

**Step 2**: Traverse the doubly linked list with the temp pointer and while traversing push the value at the current node temp onto the stack. Move the temp to the next node continuing until temp reaches null indicating the end of the list.

![image](https://github.com/balotraprashant/a2z/assets/69639884/9f81a0a0-6a35-4655-8701-cecd8c7e57c0)

Step 3: Reset the temp pointer back to the head of the list and in thissecond iteration pop the element from the stack, replace the data at the current node with the popped value from the top of the stack and move temp to the next node. Repeat this step until temp reaches null or the stack becomes empty.

![image](https://github.com/balotraprashant/a2z/assets/69639884/1056bbff-dd65-48a1-a293-0c46419bd0f5)

**Time Complexity**: O(2N) During the first traversal, each node's value is pushed into the stack once, which requires O(N) time. Then, during the second iteration, the values are popped from the stack and used to update the nodes. Space Complexity : O(N) This is because we are using an external stack data structure. At the end of the first iteration, the stack will hold all N values of the doubly linked list therefore the space required for stack is directly proportional to the size of the input doubly linked list.

-------------------------------------------------------------------------------------------------------------

**Optimal Approach**

**Reverse the Links in a Single Traversal**

Instead of performing two separate traversals of the linked list and storing its node values in an external data structure, we can optimize our approach by directly modifying the links between the nodes within the doubly linked list in place, as visualized below:

![image](https://github.com/balotraprashant/a2z/assets/69639884/cdb70582-b11c-4091-8cc3-1be7431b9554)

We need to traverse on every node, and for every node change the next pointer and back pointer. If we can do this for all nodes, at the end of traversal, the doubly linked list will be reversed.

![image](https://github.com/balotraprashant/a2z/assets/69639884/6789e315-ee37-4d8d-98e6-2d0cf726a6e3)

**Algorithm:**

Step 1: Initialise two pointers that are needed for the reversal. Initialize a current pointer to the head of the linked list. This pointer will traverse the list as we reverse it. Initialize a second pointer last to null. This pointer will be used for temporary storage during pointer swapping, as we need a third variable while swapping two data.

![image](https://github.com/balotraprashant/a2z/assets/69639884/58600c7c-0077-4456-aa94-9782354eaec7)

Step 2: Traverse through the DLL by looping over all the nodes..

Step 3: While iterating over all nodes in the linked list, we make changes to set the backward pointer of a node to the next changing its previous link. Along with this, the forward pointer is adjusted to point to the previous node, reversing the next link. To prevent losing the last node in this process, we use a reference to the last node to retain it.

![image](https://github.com/balotraprashant/a2z/assets/69639884/8de9cfb5-6cf7-43d4-bf7a-5594879d9e3e)

Update the current node's back pointer to point to the next node (current->back = current->next). This step reverses the direction of the backward pointer.

![image](https://github.com/balotraprashant/a2z/assets/69639884/dc07fce2-84da-4bf9-b44b-b19f95097a04)

Update the current node's next pointer to point to the previous node (current->next = last). This step reverses the direction of the forward pointer.

![image](https://github.com/balotraprashant/a2z/assets/69639884/ed536ac6-28ff-4116-a9fa-b93ee93dd143)

Move the current pointer one step forward (current = current->back). This allows us to continue the reversal process.
Step 4: After completing the traversal, the last node ends up at the second node in the reversed doubly linked list. To obtain the new head of the reversed list, we simply use the backward pointer of the last node, which points to the new head.

To ensure that we handle the case where the traversal ended at the original list's end (i.e., the last pointer is not null), we update the head pointer to point to the new head of the reversed list, which is stored in the last pointer.

Finally, we return the head pointer, now pointing to the head of the fully reversed doubly linked list.

![image](https://github.com/balotraprashant/a2z/assets/69639884/89be5a6a-6906-46fe-9681-faf79719470d)

**Time Complexity**: O(N) We only have to traverse the doubly linked list once, hence our time complexity is O(N).

**Space Complexity**: O(1), as the reversal is done in place.

**Problem Statement**: Given two sorted arrays, arr1, and arr2 of size n and m. Find the union of two sorted arrays.

Link: https://www.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1

The union of two arrays can be defined as the common and distinct elements in the two arrays.

NOTE: Elements in the union should be in ascending order.

Example 1:
```
Input: 
n = 5, arr1[] = {1, 2, 3, 4, 5}  
m = 5, arr2 [] = {1, 2, 3, 6, 7}
Output: 
1 2 3 4 5 6 7
Explanation: 
Distinct elements including both the arrays are: 1 2 3 4 5 6 7.
```

--------------------------------------------------------------------------------------------------------------------------------------

## Solution 1: Using Map
Our aim is to find the common elements in arr1 and arr2, and the distinct elements of arr1,arr2. Use a Single map to find the frequencies of elements in arr1 and arr2.

As we are using only a single map the common element in arr1 and arr2 are treated as a single element for finding frequency, so there would be no duplicates.

## Solution 2: Using Set
Suppose we consider arr1 and arr2 as a single array say arr,  then the union of arr1 and arr2 is the distinct elements in arr.

## Solution 3: Two Pointers

Solution 1 and 2 work for the unsorted arrays also, The arrays arr1 and arr2 are sorted, can we use this property to reduce the time Complexity?

Using the property that the arrays are sorted we can bring down the time complexity from

O((m+n)log(m+n))    TO    O(m+n).

Approach:

- Take two pointers let’s say i,j pointing to the 0th index of arr1 and arr2.
- Create an empty vector for storing the union of arr1 and arr2.
- From solution 2 we know that the union is nothing but the distinct elements in arr1 + arr2 
- Let’s traverse the arr1 and arr2 using pointers i and j and insert the distinct elements found into the union vector.
- While traversing we may encounter three cases.

1. arr1[ i ] == arr2[ j ] 

   Here we found a common element, so insert only one element in the union. Let’s insert arr[i] in union and increment i.

   NOTE: There may be cases like the element to be inserted is already present in the union, in that case, we are inserting duplicates which is not desired. So while inserting always check whether the last element in the union vector is equal or not to the element to be inserted. If equal we are trying to insert duplicates, so don’t insert the element, else insert the element in the union. This makes sure that we are not inserting any duplicates in the union because we are inserting elements in sorted order.

3. arr1[ i ]  < arr2[ j ]

   arr1[ i ] < arr2[ j ] so we need to insert arr1[ i ] in union.IF last element in  union vector is not equal to arr1[ i ],then insert in union else don’t insert. After checking Increment I.

5. arr1[ i ] > arr2[ j ]

   arr1[ i ] > arr2[ j ] so we need to insert arr2[ j ] in union. IF the last element in the union vector is not equal to arr2[ j ], then insert in the union, else don’t insert. After checking Increment j. After traversing if any elements are left in arr1 or arr2 check for condition and insert in the union.

package org.example;

/*
Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
The test cases are generated such that there are no cycles anywhere in the entire linked structure.
Note that the linked lists must retain their original structure after the function returns.
* */

public class LinkedList {

    public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
            }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // If either list is entirely empty, they cannot possibly intersect.
        if (headA == null || headB == null) {
            return null;
        }

        // Initialize two pointers starting at the heads of the two respective lists.
        // The goal is to make both pointers travel the exact same total distance.
        ListNode ptrA = headA;
        ListNode ptrB = headB;

        // This loop continues until ptrA and ptrB point to the exact same node in memory.
        // If there is no intersection, the loop will eventually terminate when both
        // ptrA and ptrB become null at the exact same time.
        while (ptrA != ptrB) {
            // If ptrA reaches the end of list A, redirect it to the head of list B.
            // Otherwise, simply move it to the next node in its current list.
            // By swapping lists, ptrA will traverse a total length of Length(A) + Length(B).
            if (ptrA == null) {
                ptrA = ptrB;
            } else {
                ptrA = ptrA.next;
            }

            // Similarly, if ptrB reaches the end of list B, redirect it to the head of list A.
            // Otherwise, move it to the next node.
            // ptrB will traverse a total length of Length(B) + Length(A).
            if (ptrB == null) {
                ptrB = headA;
            } else {
                ptrB = ptrB.next;
            }

            // WHY THIS WORKS:
            // Let the length of list A before the intersection be 'a'.
            // Let the length of list B before the intersection be 'b'.
            // Let the length of the shared intersection part be 'c'.
            //
            // ptrA travels: a + c + b
            // ptrB travels: b + c + a
            // Because (a + c + b) == (b + c + a), both pointers will land on the
            // intersection node at the exact same step on their second pass.
            //
            // If there is no intersection (c = 0), both pointers will travel a total
            // of (a + b) nodes and both will hit 'null' simultaneously, ending the loop.

        }
        return ptrA;
    }
}

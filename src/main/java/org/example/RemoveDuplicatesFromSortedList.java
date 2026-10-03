package org.example;

public class RemoveDuplicatesFromSortedList {

    /*
     * Node of a singly linked list.
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /*
     * Removes duplicate values from a sorted linked list.
     *
     * Example:
     *
     * 1 -> 1 -> 2 -> 3 -> 3 -> null
     *
     * becomes:
     *
     * 1 -> 2 -> 3 -> null
     */
    public static ListNode deleteDuplicates(ListNode head) {

        // Empty list: there is nothing to remove.
        if (head == null) {
            return null;
        }

        /*
         * Start at the first node.
         *
         * We don't need another list because we can modify
         * the "next" references directly.
         */
        ListNode current = head;

        /*
         * Continue while there is a next node available.
         *
         * We need current.next because we compare:
         *
         * current.val
         *
         * with
         *
         * current.next.val
         */
        while (current.next != null) {

            /*
             * Because the list is sorted, equal values
             * will always be next to each other.
             *
             * Example:
             *
             * current
             *   |
             *   v
             *   1 -> 1 -> 2
             *
             * current.val == current.next.val
             */
            if (current.val == current.next.val) {

                /*
                 * Duplicate found.
                 *
                 * Skip the duplicate node.
                 *
                 * BEFORE:
                 *
                 * current
                 *   |
                 *   v
                 *   1 -> 1 -> 2
                 *        ^
                 *     duplicate
                 *
                 *
                 * AFTER:
                 *
                 * current
                 *   |
                 *   v
                 *   1 ------> 2
                 *
                 *
                 * We simply make current.next point to
                 * the node after the duplicate.
                 */
                current.next = current.next.next;

            } else {

                /*
                 * Values are different.
                 *
                 * Example:
                 *
                 * 1 -> 2
                 *
                 * So the current node is already unique.
                 *
                 * Move forward.
                 */
                current = current.next;
            }
        }

        /*
         * The original head remains the beginning of the list.
         */
        return head;
    }

    /*
     * Helper method only for demonstration/testing.
     */
    public static void printList(ListNode head) {

        ListNode current = head;

        while (current != null) {
            System.out.print(current.val);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println(" -> null");
    }

    /*
     * Example tests.
     */
    public static void main(String[] args) {

        // ----------------------------------------
        // Example 1
        //
        // [1,1,2]
        // Expected: [1,2]
        // ----------------------------------------

        ListNode list1 =
                new ListNode(1,
                        new ListNode(1,
                                new ListNode(2)));

        System.out.println("Example 1:");

        System.out.print("Before: ");
        printList(list1);

        list1 = deleteDuplicates(list1);

        System.out.print("After:  ");
        printList(list1);


        // ----------------------------------------
        // Example 2
        //
        // [1,1,2,3,3]
        // Expected: [1,2,3]
        // ----------------------------------------

        ListNode list2 =
                new ListNode(1,
                        new ListNode(1,
                                new ListNode(2,
                                        new ListNode(3,
                                                new ListNode(3)))));

        System.out.println("\nExample 2:");

        System.out.print("Before: ");
        printList(list2);

        list2 = deleteDuplicates(list2);

        System.out.print("After:  ");
        printList(list2);


        // ----------------------------------------
        // Example 3
        //
        // []
        // Expected: []
        // ----------------------------------------

        ListNode list3 = null;

        System.out.println("\nExample 3:");

        System.out.print("Before: ");
        printList(list3);

        list3 = deleteDuplicates(list3);

        System.out.print("After:  ");
        printList(list3);


        // ----------------------------------------
        // Extra Example
        //
        // [1,1,1,1,2,2,3]
        // Expected: [1,2,3]
        // ----------------------------------------

        ListNode list4 =
                new ListNode(1,
                        new ListNode(1,
                                new ListNode(1,
                                        new ListNode(1,
                                                new ListNode(2,
                                                        new ListNode(2,
                                                                new ListNode(3)))))));

        System.out.println("\nExample 4:");

        System.out.print("Before: ");
        printList(list4);

        list4 = deleteDuplicates(list4);

        System.out.print("After:  ");
        printList(list4);
    }
}
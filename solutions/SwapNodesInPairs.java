package org.moozeh;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        var prev = head; // simply references for linking
        var current = head;
        var next = head.next;

        // swap
        current.next = next.next;
        next.next = current;
        head = next;

        prev = head.next;
        current = prev.next;
        if (current == null) return head;
        next = current.next;

        while(current != null && next != null) {
            // swap
            current.next = next.next;
            next.next = current;
            prev.next = next;

            prev = prev.next.next;
            current = prev.next;
            if (current == null) break;
            next = current.next;

        }

        return head;
    }
}

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
    if (head == null || left == right) return head;

    ListNode dummy = new ListNode(0); // dummy before head
    dummy.next = head;
    ListNode prev = dummy;

    // Step 1: move prev to node before 'left'
    for (int i = 1; i < left; i++) {
        prev = prev.next;
    }

    // Step 2: reverse sublist from left to right
    ListNode curr = prev.next;
    ListNode next = null;
    ListNode subPrev = null;

    for (int i = 0; i <= right - left; i++) {
        next = curr.next;
        curr.next = subPrev;
        subPrev = curr;
        curr = next;
    }

    // Step 3: reconnect
    prev.next.next = curr;   // tail of reversed part connects to next segment
    prev.next = subPrev;     // prev connects to new head of sublist

    return dummy.next;
    }
}
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
    public ListNode swapNodes(ListNode head, int k) {
                ListNode first = head;
        ListNode second = head;
        ListNode temp = head;
        
       
        for (int i = 1; i < k; i++) {
            first = first.next;
        }
        
       
        ListNode kthFromStart = first;
        

        for (int i = 0; i < k; i++) {
            temp = temp.next;
        }
        
        
        while (temp != null) {
            temp = temp.next;
            second = second.next;
        }
        
        
        int swapTemp = kthFromStart.val;
        kthFromStart.val = second.val;
        second.val = swapTemp;
        
        return head;
    }
}
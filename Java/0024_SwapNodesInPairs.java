/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (head != null && head.next != null && head.next.next != null) {
            ListNode p1 = head.next;
            ListNode p2 = head.next.next;
            p1.next = p2.next;
            p2.next = p1;
            head.next = p2;
            head = p1;
        }
        return dummy.next;
    }
}

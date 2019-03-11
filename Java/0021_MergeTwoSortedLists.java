/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode head = ans;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                head.next = l2;
                break;
            }
            if (l2 == null) {
                head.next = l1;
                break;
            }
            if (l1.val < l2.val) {
                head.next = new ListNode(l1.val);
                head = head.next;
                l1 = l1.next;
            } else {
                head.next = new ListNode(l2.val);
                head = head.next;
                l2 = l2.next;
            }
        }
        return ans.next;
    }
}

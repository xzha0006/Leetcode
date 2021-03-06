/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode tmp = l3;
        int extra = 0;
        while (l1 != null || l2 != null || extra != 0)
        {
            if (l1 == null)
                l1 = new ListNode(0);
            if (l2 == null)
                l2 = new ListNode(0);
            tmp.val = (l1.val + l2.val + extra) % 10;
            extra = (l1.val + l2.val + extra) / 10;
            if(l1.next != null || l2.next !=null || extra != 0)
                tmp.next = new ListNode(0);
            tmp = tmp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        return l3;
    }
}
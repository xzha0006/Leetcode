/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while(headA != null) {
            stack1.push(headA);
            headA = headA.next;
        }
        
        while(headB != null) {
            stack2.push(headB);
            headB = headB.next;
        }
        ListNode res = null;
        while (!stack1.empty() && !stack2.empty()) {
            if (stack1.peek() != stack2.peek()) {
                break;
            } else {
                res = stack1.pop();
                stack2.pop();
            }
        }
        
        return res;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        if (head == null) return new int[0];
        Deque<Integer> stack = new ArrayDeque<>();
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next; 
        }
        
        int[] ans = new int[len];
        int[] res = new int[len];
        p = head;
        int i = 0;
        while (p != null) {
            ans[i] = p.val;
            ++i;
            p = p.next; 
        }
        
        Deque<Integer> stack2 = new ArrayDeque<>();
        for (int j = len - 1; j > -1; --j) {
            int cur = ans[j]; 
            res[j] = getClosedMax(stack2, cur);
            stack2.push(cur);
        }
        return res;
    }
    private int getClosedMax(Deque<Integer> stack, int cur) {
        while (!stack.isEmpty()) {
            int val = stack.pop();
            if (cur < val) {
                stack.push(val);
                return val;
            }
        }
        return 0;
    }
}

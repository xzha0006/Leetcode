/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//in-order traverse should be sorted. [1,2,3,4,5]
//incorrect BST [1,5,3,4,2] larger number at the beginning, smaller number at the end.
class Solution {
    TreeNode first = null, second = null, prev = null;
    public void recoverTree(TreeNode root) {
        recover(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
    private void recover(TreeNode node) {
        if (node == null) return;
        recover(node.left);
        if (first == null && prev != null && prev.val > node.val) {
            first = prev;
        }
        if (first != null && prev.val > node.val) {
            second = node;
        }
        prev = node;
        recover(node.right);
    }
}

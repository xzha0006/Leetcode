/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int count, res;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
       inOrderTraversal(root);
        return res;
    }
    private void inOrderTraversal(TreeNode root) {
        if (root.left != null) inOrderTraversal(root.left);
        count--;
        if (count == 0) {
            res = root.val;
            return;
        }
        if (root.right != null) inOrderTraversal(root.right);
    }
}

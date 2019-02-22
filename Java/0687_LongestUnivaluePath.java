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
    int ans;
    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        longestUnivaluePathFromRoot(root);
        return ans;
    }
    public int longestUnivaluePathFromRoot(TreeNode root) {
        int leftLength = 0, rightLength = 0;
        if (root == null) {
            return 0;
        }
        leftLength = longestUnivaluePathFromRoot(root.left);
        rightLength = longestUnivaluePathFromRoot(root.right);
        
        int validLeft = 0, validRight = 0;
        if (root.left != null && root.left.val == root.val) {
            validLeft = leftLength + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            validRight = rightLength + 1;
        }
        ans = Math.max(ans, validRight + validLeft);
        return Math.max(validLeft, validRight);
    }
}

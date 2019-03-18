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
    TreeNode prev = null;
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        else if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode head = root.right;
                while (head.left != null) head = head.left;
                root.val = head.val;
                root.right = deleteNode(root.right, head.val);
                return root;
            }
        }
    }
}

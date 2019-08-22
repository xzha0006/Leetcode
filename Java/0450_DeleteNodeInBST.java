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
            if (root.left == null && root.right == null) return null;
            else if (root.left != null && root.right != null) {
                int min = findMinValue(root.right);
                root.val = min;
                root.right = deleteNode(root.right, min);
            } else if (root.left != null) {
                return root.left;
            } else {
                return root.right;
            }
        }
        
        return root;
    }
    
    private int findMinValue(TreeNode root) {
        if (root == null) return -1;
        if (root.left == null) return root.val;
        return findMinValue(root.left);
    }
}

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
    int curDup = 1, maxDup = 0;
    List<Integer> ans;
    public int[] findMode(TreeNode root) {
        ans = new ArrayList<>();
        inOrderTraverse(root);
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); ++i) {
            res[i] = ans.get(i);
        }
        return res;
    }
    private void inOrderTraverse(TreeNode root) {
        if (root == null) return;
        inOrderTraverse(root.left);
        if (prev == null || prev.val != root.val) {
            curDup = 1;
        } else {
            curDup++;
        }
        if (curDup > maxDup) {
            maxDup = curDup;
            ans.clear();
        }
        if (curDup == maxDup) {
            ans.add(root.val);
        }
        prev = root;
        inOrderTraverse(root.right);
    }
}

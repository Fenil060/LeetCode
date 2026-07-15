/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxPath = 0;

    static class Pair {
        int val;
        int len;

        public Pair(int v, int l) {
            this.val = v;
            this.len = l;
        }
    }

    public int longestUnivaluePath(TreeNode root) {
        calculate(root);
        return maxPath;
    }

    public Pair calculate(TreeNode root) {

        if (root == null) {
            return new Pair(-1, 0);
        }

        Pair left = calculate(root.left);
        Pair right = calculate(root.right);

        int leftLen = 0;
        int rightLen = 0;

        if (root.left != null && root.val == left.val) {
            leftLen = left.len + 1;
        }

        if (root.right != null && root.val == right.val) {
           rightLen = right.len + 1;
        }
        maxPath = Math.max(maxPath, leftLen+rightLen);

        return new Pair(root.val, Math.max(leftLen, rightLen));
    }
}
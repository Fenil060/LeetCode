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
    int ans = 0;

    class Pair {
        int sum;
        int count;

        Pair(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }

    public int averageOfSubtree(TreeNode root) {
        calculate(root);
        return ans;
    }

    public Pair calculate(TreeNode root) {
        if (root == null) {
            return new Pair(0, 0);
        }

        Pair left = calculate(root.left);
        Pair right = calculate(root.right);

        int totalnode = 1 + left.count + right.count;
        if (root.val == (left.sum + right.sum + root.val) / totalnode) {
            ans++;
        }
        return new Pair(left.sum + right.sum + root.val, totalnode);
    }
}
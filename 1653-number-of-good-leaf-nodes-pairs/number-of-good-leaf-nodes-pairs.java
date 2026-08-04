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

    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return ans;
    }

    public List<Integer> dfs(TreeNode root, int d) {
        if (root == null) {
            return new ArrayList<>();
        }

        if (root.left == null && root.right == null) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            return list;
        }

        List<Integer> left = dfs(root.left, d);
        List<Integer> right = dfs(root.right, d);

        for (int l : left) {
            for (int r : right) {
                if (l + r <= d) {
                    ans++;
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int l : left) {
            if (l + 1 <= d) {
                res.add(l + 1);
            }
        }

        for (int r : right) {
            if (r + 1 <= d) {
                res.add(r + 1);
            }
        }
        return res;
    }
}
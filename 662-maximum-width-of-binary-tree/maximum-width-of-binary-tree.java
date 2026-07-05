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
    static class Pair {
        TreeNode node;
        long val;

        public Pair(TreeNode n, long v) {
            this.node = n;
            this.val = v;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {

        if (root == null)
            return 0;

        Queue<Pair> q = new LinkedList<>();
        int maxWidth = 0;

        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();

            long first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair curr = q.poll();
                long currIdx = curr.val;
                if (i == 0)
                    first = curr.val;
                if (i == size - 1)
                    last = curr.val;

                if (curr.node.left != null) {
                    q.add(new Pair(curr.node.left, 2 * currIdx + 1));
                }
                if (curr.node.right != null) {
                    q.add(new Pair(curr.node.right, 2 * currIdx + 2));
                }
            }
            maxWidth = Math.max(maxWidth, (int) (last - first + 1));
        }
        return maxWidth;
    }
}
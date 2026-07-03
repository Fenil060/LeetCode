class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> li = new ArrayList<>();

        preorder(root, li);
        return li;
    }

    public void preorder(TreeNode root, List<Integer> li){
        if(root == null){
            return;
        }

        li.add(root.val);
        preorder(root.left, li);
        preorder(root.right, li);
    }
}
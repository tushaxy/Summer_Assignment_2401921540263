class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        
        int rootVal = root.val;
        
        if (p.val < rootVal && q.val < rootVal) {
            return lowestCommonAncestor(root.left, p, q);
        }
        
        if (p.val > rootVal && q.val > rootVal) {
            return lowestCommonAncestor(root.right, p, q);
        }
        
        return root;
    }
}

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftPath = maxDepth(root.left);
        int rightPath = maxDepth(root.right);
        
        return 1 + Math.max(leftPath, rightPath);
    }
}

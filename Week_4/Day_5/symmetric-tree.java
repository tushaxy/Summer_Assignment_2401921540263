class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return mirrorVerify(root.left, root.right);
    }
    
    private boolean mirrorVerify(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }
        if (leftNode == null || rightNode == null) {
            return false;
        }
        if (leftNode.val != rightNode.val) {
            return false;
        }
        
        boolean outerMatch = mirrorVerify(leftNode.left, rightNode.right);
        boolean innerMatch = mirrorVerify(leftNode.right, rightNode.left);
        
        return outerMatch && innerMatch;
    }
}

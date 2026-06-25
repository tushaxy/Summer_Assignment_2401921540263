class Solution {
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        calculateHeight(root);
        return maxDiameter;
    }
    
    private int calculateHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int leftSubtreeHeight = calculateHeight(node.left);
        int rightSubtreeHeight = calculateHeight(node.right);
        
        if (leftSubtreeHeight + rightSubtreeHeight > maxDiameter) {
            maxDiameter = leftSubtreeHeight + rightSubtreeHeight;
        }
        
        return 1 + Math.max(leftSubtreeHeight, rightSubtreeHeight);
    }
}

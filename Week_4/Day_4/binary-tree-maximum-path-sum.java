class Solution {
    private int overallMaxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        findMaxGain(root);
        return overallMaxSum;
    }
    
    private int findMaxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int leftGain = Math.max(0, findMaxGain(node.left));
        int rightGain = Math.max(0, findMaxGain(node.right));
        
        int currentPathSum = node.val + leftGain + rightGain;
        if (currentPathSum > overallMaxSum) {
            overallMaxSum = currentPathSum;
        }
        
        return node.val + Math.max(leftGain, rightGain);
    }
}

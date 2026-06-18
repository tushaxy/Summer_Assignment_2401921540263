import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        
        Stack<Integer> boundaryStack = new Stack<>();
        int maxRegion = 0;
        int totalBars = heights.length;
        
        for (int i = 0; i <= totalBars; i++) {
            int currentHeight = (i == totalBars) ? 0 : heights[i];
            
            while (!boundaryStack.isEmpty() && currentHeight < heights[boundaryStack.peek()]) {
                int targetHeight = heights[boundaryStack.pop()];
                int width = boundaryStack.isEmpty() ? i : i - boundaryStack.peek() - 1;
                
                int currentArea = targetHeight * width;
                if (currentArea > maxRegion) {
                    maxRegion = currentArea;
                }
            }
            boundaryStack.push(i);
        }
        
        return maxRegion;
    }
}

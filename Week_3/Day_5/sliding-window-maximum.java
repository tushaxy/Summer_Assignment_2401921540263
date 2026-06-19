import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        
        int totalElements = nums.length;
        int[] finalMaxArray = new int[totalElements - k + 1];
        int targetIndex = 0;
        
        Deque<Integer> indexDeque = new ArrayDeque<>();
        
        for (int i = 0; i < totalElements; i++) {
            if (!indexDeque.isEmpty() && indexDeque.peekFirst() < i - k + 1) {
                indexDeque.pollFirst();
            }
            
            while (!indexDeque.isEmpty() && nums[indexDeque.peekLast()] < nums[i]) {
                indexDeque.pollLast();
            }
            
            indexDeque.offerLast(i);
            
            if (i >= k - 1) {
                finalMaxArray[targetIndex] = nums[indexDeque.peekFirst()];
                targetIndex++;
            }
        }
        
        return finalMaxArray;
    }
}

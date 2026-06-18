import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] daysToWait = new int[len];
        Stack<Integer> indexStack = new Stack<>();
        
        for (int i = 0; i < len; i++) {
            while (!indexStack.isEmpty() && temperatures[i] > temperatures[indexStack.peek()]) {
                int previousDayIndex = indexStack.pop();
                daysToWait[previousDayIndex] = i - previousDayIndex;
            }
            indexStack.push(i);
        }
        
        return daysToWait;
    }
}

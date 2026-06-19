import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {
    private Queue<Integer> slideWindow;

    public RecentCounter() {
        slideWindow = new LinkedList<>();
    }
    
    public int ping(int t) {
        slideWindow.add(t);
        int lowLimit = t - 3000;
        
        while (!slideWindow.isEmpty() && slideWindow.peek() < lowLimit) {
            slideWindow.poll();
        }
        
        return slideWindow.size();
    }
}

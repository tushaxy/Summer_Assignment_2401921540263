class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        
        int start = 0;
        int end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int oddLength = stretchCenter(s, i, i);
            int evenLength = stretchCenter(s, i, i + 1);
            
            int maxValidLength = Math.max(oddLength, evenLength);
            
            if (maxValidLength > end - start) {
                start = i - (maxValidLength - 1) / 2;
                end = i + maxValidLength / 2;
            }
        }
        
        return s.substring(start, end + 1);
    }
    
    private int stretchCenter(String src, int left, int right) {
        while (left >= 0 && right < src.length() && src.charAt(left) == src.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}

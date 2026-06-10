class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        String combined = s + s;
        String internalSequence = combined.substring(1, (2 * n) - 1);
        
        return internalSequence.contains(s);
    }
}

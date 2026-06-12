class Solution {
    public int compress(char[] chars) {
        int writer = 0;
        int reader = 0;
        
        while (reader < chars.length) {
            char targetChar = chars[reader];
            int groupLength = 0;
            
            while (reader < chars.length && chars[reader] == targetChar) {
                groupLength++;
                reader++;
            }
            
            chars[writer++] = targetChar;
            
            if (groupLength > 1) {
                for (char digit : Integer.toString(groupLength).toCharArray()) {
                    chars[writer++] = digit;
                }
            }
        }
        return writer;
    }
}

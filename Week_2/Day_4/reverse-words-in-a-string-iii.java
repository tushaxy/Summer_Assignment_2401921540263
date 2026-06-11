class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        String result = "";
        
        for (int i = 0; i < words.length; i++) {
            result += recursiveReverse(words[i]);
            if (i < words.length - 1) {
                result += " ";
            }
        }
        return result;
    }
    
    private String recursiveReverse(String word) {
        if (word.isEmpty()) return word;
        return word.charAt(word.length() - 1) + recursiveReverse(word.substring(0, word.length() - 1));
    }
}

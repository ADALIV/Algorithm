import java.util.ArrayList;
import java.util.List;

class Solution {
    public static final char[] ch = "AEIOU".toCharArray();
    public static List<String> dict = new ArrayList<>();
    
    public int solution(String word) {
        generate("");
        return dict.indexOf(word);
    }
    
    public void generate(String word) {
        dict.add(word);
        if (word.length() == 5) return;
        
        for (char c : ch) {
            generate(word + c);
        }
    }
}
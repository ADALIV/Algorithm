import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
    public static final String[][] precedences = {
        "+-*".split(""),
        "+*-".split(""),
        "-+*".split(""),
        "-*+".split(""),
        "*+-".split(""),
        "*-+".split(""),
    };
    public long cal(long x, long y, String op) {
        return switch (op) {
            case "+" -> x+y;
            case "-" -> x-y;
            case "*" -> x*y;
            default -> 0;
        };
    }
    public long cal(List<String> tokens, String[] precedences) {
        for (String op : precedences) {
            for (int i=0; i<tokens.size(); i++) {
                if (tokens.get(i).equals(op)) {
                    long x = Long.parseLong(tokens.get(i-1));
                    long y = Long.parseLong(tokens.get(i+1));
                    long result = cal(x, y, op);
                    tokens.remove(i+1);
                    tokens.remove(i);
                    tokens.remove(i-1);
                    tokens.add(i-1, String.valueOf(result));
                    i -= 2; // i++
                }
            }
        }
        return Long.parseLong(tokens.get(0));
    }
    public long solution(String expression) {
        StringTokenizer st = new StringTokenizer(expression, "+-*", true);
        List<String> tokens = new ArrayList<>();
        while (st.hasMoreTokens()) {
            tokens.add(st.nextToken());
        }
        
        long max = 0;
        for (String[] precedence : precedences) {
            long value = Math.abs(cal(new ArrayList<>(tokens), precedence));
            if (value > max) max = value;
        }
        return max;
    }
}
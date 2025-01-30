class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        int i = 0;
        int[] x = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] y = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        
        while (true) {
            if (i >= X.length() && i >= Y.length()) break;
            if (i < X.length()) {
                x[X.charAt(i) - '0']++;
            }
            if (i < Y.length()) {
                y[Y.charAt(i) - '0']++;
            }
            i++;
        }
        
        for (int j=9; j>-1; j--) {
            for (int k=0; k<Math.min(x[j], y[j]); k++) {
                answer.append(j);
            }
        }
        if ("".equals(answer.toString())) return "-1";
        if (answer.toString().charAt(0) == '0') return "0";
        return answer.toString();
    }
}
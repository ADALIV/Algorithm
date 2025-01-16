class Solution {
    public String solution(int[] food) {
        String answer = "";
        for (int i=1; i<food.length; i++) {
            for (int j=1; j<=food[i]/2.0; j++) {
                answer += Integer.toString(i);
            }
        }
        StringBuffer SB = new StringBuffer(answer);
        String temp = SB.reverse().toString();
        answer += 0 + temp;
        return answer;
    }
}
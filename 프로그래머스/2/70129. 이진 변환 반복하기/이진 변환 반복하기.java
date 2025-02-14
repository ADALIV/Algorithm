class Solution {
    int[] answer = new int[2];
    public int[] solution(String s) {
        while (!s.equals("1")) {
            answer[0]++;
            s = two_convert(s);
        }
        return answer;
    }
    public String two_convert(String s) {
        int cnt_1 = 0;
        int cnt_0 = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '1') cnt_1++;
            else cnt_0++;
        }
        answer[1] += cnt_0;
        return Integer.toString(cnt_1, 2);
    }
}
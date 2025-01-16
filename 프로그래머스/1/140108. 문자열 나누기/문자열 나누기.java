class Solution {
    public int solution(String s) {
        int answer = 0;
        int cnt = 0, num = 0;
        char ch = 'a';
        for (int i=0; i<s.length(); i++) {
            if (cnt == 0) {
                cnt++;
                ch = s.charAt(i);
            }
            else if (cnt != 0 && s.charAt(i) != ch) {
                num++;
            }
            else if (cnt != 0 && s.charAt(i) == ch) {
                cnt++;
            }
            else {}
            
            if (cnt == num && cnt != 0) {
                answer++;
                cnt = 0;
                num = 0;
            }
        }
        if (cnt != num) answer++;
        return answer;
    }
}
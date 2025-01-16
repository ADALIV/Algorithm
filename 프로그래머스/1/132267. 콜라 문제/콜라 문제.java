class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int temp = 0;
        int i;
        while (true) {
            if (n < a) break;
            for (i=a; i<=n; i+=a) {
                temp += b;
            }
            answer += temp;
            n += temp - i + a;
            temp = 0;
        }
        return answer;
    }
}
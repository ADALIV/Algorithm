import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int cnt = 0;
        int[] answer = new int[score.length];
        LinkedList<Integer> LL = new LinkedList<Integer>();
        
        for (int i : score) {
            LL.add(i);
            Collections.sort(LL);
            if (LL.size() > k) {
                answer[cnt++] = LL.get(LL.size() - k);
            }
            else {
                answer[cnt++] = LL.get(0);
            }
        }
        return answer;
    }
}
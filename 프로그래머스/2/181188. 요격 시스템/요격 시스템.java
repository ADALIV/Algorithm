import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        Arrays.sort(targets, (o1, o2) -> {
            if (o2[1] == o1[1]) return o1[0] - o2[0];
            else return o1[1] - o2[1];
        });
        int temp = targets[0][1];
        for (int[] arr : targets) {
            if (arr[0] >= temp) {
                temp = arr[1];
                answer++;
            }
        }
        return answer;
    }
}
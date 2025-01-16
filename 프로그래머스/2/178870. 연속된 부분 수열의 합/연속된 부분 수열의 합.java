import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int temp = 0;
        int sum = 0;
        int L = 0, R = 1000000;
        for (int i=0; i<sequence.length; i++) {
            while (temp < sequence.length && sum < k) {
                sum += sequence[temp++];
            }
            if (sum == k) {
                if (temp-i-1 < R-L) {
                    L = i;
                    R = temp-1;
                }
            }
            sum -= sequence[i];
            answer[0] = L;
            answer[1] = R;
        }
        return answer;
    }
}

/*
public class seq {
    int sum;
    public seq() {
        this.sum = 0;
    }
}
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int cnt = 0;
        int start = 0;
        int end = 1000000;
        List<seq> seqs = new ArrayList<>();
        
        for (int i=0; i<sequence.length; i++) {
            seqs.add(new seq());
            for (int j=cnt; j<=i; j++) {
                seqs.get(j).sum += sequence[i];
                if (seqs.get(j).sum > k) cnt++;
                else if (seqs.get(j).sum == k) {
                    if (end-start > i-cnt) {
                        end = i;
                        start = cnt;
                    }
                }
            }
        }
        answer[0] = start;
        answer[1] = end;
        return answer;
    }
}
*/
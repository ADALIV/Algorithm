import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int answer = 0;
        for (int i : tangerine) {
            if (hm.get(i) != null) {
                hm.put(i, hm.get(i)+1);
            }
            else {
                hm.put(i, 1);
            }
        }
        List<Map.Entry<Integer, Integer>> l = new LinkedList<>(hm.entrySet());
        l.sort(((o1, o2) -> hm.get(o2.getKey()) - hm.get(o1.getKey())));
        for (Map.Entry<Integer, Integer> en : l) {
            k -= en.getValue();
            answer++;
            if (k <= 0) break;
        }
        return answer;
    }
}
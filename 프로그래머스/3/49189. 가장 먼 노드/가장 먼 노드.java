import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        LinkedList<Integer> LL = new LinkedList<Integer>();
        ArrayList<Integer>[] list = new ArrayList[n+1];
        boolean visit[] = new boolean[n+1];
        int arr[] = new int[n+1];
        int answer = 0;
        
        for (int i=1; i<n+1; i++) {
            list[i] = new ArrayList<Integer>();
        }
        
        for (int i=0; i<edge.length; i++) {
            list[edge[i][0]].add(edge[i][1]);
            list[edge[i][1]].add(edge[i][0]);
        }
        LL.add(1);
        visit[1] = true;
        while (!LL.isEmpty()) {
            int a = LL.poll();
            for (int b : list[a]) {
                if (visit[b]) continue;
                LL.add(b);
                visit[b] = true;
                arr[b] = arr[a] + 1;
            }
        }
        int max = 0;
        for (int i=2; i<n+1; i++) {
            if (max < arr[i]) max = arr[i];
        }
        for (int i=2; i<n+1; i++) {
            if (max == arr[i]) answer++;
        }
        return answer;
    }
}
import java.util.*;

public class node {
    int sub; int val; int L; int R;
    public node(int a, int b) {
        this.sub = a; this.val = b; this.L = -1; this.R = -1;
    }
}
class Solution {
    static int answer = -1;
    static node[] N;
    public int solution(int[] info, int[][] edges) {
        N = new node[info.length];
        for (int i=0; i<info.length; i++) {
            N[i] = new node(info[i], i);
        }
        for (int i=0; i<edges.length; i++) {
            if (N[edges[i][0]].L == -1) N[edges[i][0]].L = edges[i][1];
            else N[edges[i][0]].R = edges[i][1];
        }
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(0, 0, 0, list);
        return answer;
    }
    public static void dfs(int sheep, int wolf, int num, List<Integer> l) {
        if (N[num].sub == 0) sheep++;
        else wolf++;
        
        if (wolf >= sheep) return;
        answer = Math.max(sheep, answer);
        
        List<Integer> list  = new ArrayList<>();
        list.addAll(l);
        list.remove(Integer.valueOf(num));
        if (N[num].L != -1) list.add(N[num].L);
        if (N[num].R != -1) list.add(N[num].R);
        
        for (int i : list) {
            dfs(sheep, wolf, i, list);
        }
    }
}
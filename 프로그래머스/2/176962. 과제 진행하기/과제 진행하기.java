import java.util.*;

class plan{
    String name;
    int h;
    int m;
    int time;
    public plan(String name, int h, int m, int time) {
        this.name = name;
        this.h = h;
        this.m = m;
        this.time = time;
    }
}
class Solution {
    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        List<plan> Plans = new ArrayList<>();
        Stack<plan> stop = new Stack<>();
        plan tmp;
        
        for (String[] i : plans) {
            Plans.add(new plan(i[0], Integer.parseInt(i[1].substring(0, 2)), Integer.parseInt(i[1].substring(3, 5)), Integer.parseInt(i[2])));
        }
        Comparator<plan> cp = new Comparator<>() {
            @Override
            public int compare(plan a, plan b) {
                if (a.h == b.h) return a.m - b.m;
                else return a.h - b.h;
            }
        };
        Collections.sort(Plans, cp);
        
        for (int i=0; i<Plans.size()-1; i++) {
            plan a = Plans.get(i);
            plan b = Plans.get(i+1);
            int remain = (b.h-a.h)*60 + (b.m-a.m) - a.time;
            if (remain >= 0) {
                answer.add(a.name);
                while (!stop.isEmpty()) {
                    if (remain == 0) break;
                    tmp = stop.peek();
                    if (tmp.time <= remain) {
                        remain -= tmp.time;
                        answer.add(tmp.name);
                        stop.pop();
                    }
                    else {
                        tmp.time -= remain;
                        remain = 0;
                    }
                }
            }
            else {
                a.time = 0-remain;
                stop.push(a);
            }
        }
        answer.add(Plans.get(Plans.size()-1).name);
        while (!stop.isEmpty()) {
            tmp = stop.pop();
            answer.add(tmp.name);
        }
        return answer.toArray(new String[answer.size()]);
    }
}
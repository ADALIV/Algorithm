import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> HM = new HashMap<>();
        
        int date = getDate(today);
        for (String i : terms) {
            String[] t = i.split(" ");
            HM.put(t[0], Integer.parseInt(t[1]));
        }
        
        for (int i=0; i<privacies.length; i++) {
            String[] pri = privacies[i].split(" ");
            if (getDate(pri[0]) + (HM.get(pri[1]) * 28) <= date) {
                answer.add(i+1);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public int getDate(String today) {
        String[] date = today.split("\\.");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        return (year * 12 * 28) + (month * 28) + day;
    }
}
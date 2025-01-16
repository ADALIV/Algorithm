import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        HashMap<String, Integer> HM1 = new HashMap<String, Integer>();
        HashMap<Integer, String> HM2 = new HashMap<Integer, String>();
        for (int i=0; i<players.length; i++) {
            HM1.put(players[i], i);
            HM2.put(i, players[i]);
        }
        
        for (String i : callings) {
            int num = HM1.get(i);
            String temp = HM2.get(num-1);
            HM2.put(num-1, i);
            HM2.put(num, temp);
            HM1.put(i, num-1);
            HM1.put(temp, num);
        }
        
        for (int i=0; i<players.length; i++) {
            answer[i] = HM2.get(i);
        }
        return answer;
    }
}
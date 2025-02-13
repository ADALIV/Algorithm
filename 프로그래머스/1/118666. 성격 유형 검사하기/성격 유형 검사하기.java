import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int cnt = 0;
        int temp;
        HashMap<Character, Integer> HM = new HashMap<Character, Integer>();
        HM.put('R', 0); HM.put('T', 0); HM.put('C', 0); HM.put('F', 0);
        HM.put('J', 0); HM.put('M', 0); HM.put('A', 0); HM.put('N', 0);
        
        for (int i : choices) {
            if (i == 4) {}
            else if (i > 4) {
                temp = HM.get(survey[cnt].charAt(1));
                HM.put(survey[cnt].charAt(1), temp + i - 4);
            }
            else if (i < 4) {
                temp = HM.get(survey[cnt].charAt(0));
                HM.put(survey[cnt].charAt(0), temp + 4 - i);
            }
            cnt++;
        }
        
        answer += (HM.get('R') >= HM.get('T'))? 'R' : 'T';
        answer += (HM.get('C') >= HM.get('F'))? 'C' : 'F';
        answer += (HM.get('J') >= HM.get('M'))? 'J' : 'M';
        answer += (HM.get('A') >= HM.get('N'))? 'A' : 'N';
        return answer;
    }
}
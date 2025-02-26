import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        id temp;
        String name;
        int[] answer = new int[id_list.length];
        HashMap<String, id> user = new HashMap<>();
        for (int i=0; i<id_list.length; i++) {
            user.put(id_list[i], new id(i, 0, new Vector<String>()));
        }
        
        for (String s : report) {
            String[] arr = s.split(" ");
            temp = user.get(arr[1]);
            if (temp.v.contains(arr[0])) {}
            else {
                temp.v.add(arr[0]);
                temp.reported++;
            }
        }
        for (int i=0; i<id_list.length; i++) {
            temp = user.get(id_list[i]);
            if (temp.reported >= k) {
                Vector<String> vector = temp.v;
                for (int j=0; j<vector.size(); j++) {
                    name = vector.get(j);
                    answer[user.get(name).num]++;
                }
            }
        }
        return answer;
    }
    public class id {
        int num;
        int reported;
        Vector<String> v;
        public id(int num, int reported, Vector<String> v) {
            this.num = num;
            this.reported = reported;
            this.v = v;
        }
    }
}
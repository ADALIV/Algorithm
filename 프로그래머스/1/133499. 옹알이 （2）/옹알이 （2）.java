class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        int check = 1;
        int start = 0;
        String last = "";
        
        for (int i=0; i<babbling.length; i++) {
            while (true) {
                if (start >= babbling[i].length()) break;
                else if (start < babbling[i].length()-2 && babbling[i].substring(start, start + 3).equals("aya") && !last.equals("aya")) {
                    last = "aya";
                    start += 3;
                }
                else if (start < babbling[i].length()-1 && babbling[i].substring(start, start + 2).equals("ye") && !last.equals("ye")) {
                    last = "ye";
                    start += 2;
                }
                else if (start < babbling[i].length()-2 && babbling[i].substring(start, start + 3).equals("woo") && !last.equals("woo")) {
                    last = "woo";
                    start += 3;
                }
                else if (start < babbling[i].length()-1 && babbling[i].substring(start, start + 2).equals("ma") && !last.equals("ma")) {
                    last = "ma";
                    start += 2;
                }
                else {
                    check = 0;
                    break;
                }
            }
            if (check == 1) answer++;
            else check = 1;
            start = 0;
            last = "";
        }
        return answer;
    }
}
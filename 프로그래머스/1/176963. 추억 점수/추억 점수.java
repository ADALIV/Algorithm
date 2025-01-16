class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        int num = 0;
        int cnt = 0;
        for (int i=0; i<photo.length; i++) {
            for (int j=0; j<photo[i].length; j++) {
                for (int k=0; k<name.length; k++) {
                    if (name[k].equals(photo[i][j])) {
                        num += yearning[k];
                    }
                }
            }
            answer[cnt++] = num;
            num = 0;
        }
        return answer;
    }
}
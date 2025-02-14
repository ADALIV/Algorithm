class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        char[][] place = new char[5][5];
        
        for (int i=0; i<5; i++) {
            // 각 대기실에 대하여
            for (int j=0; j<5; j++) {
                place[j] = places[i][j].toCharArray();
            }
            answer[i] = check_distancing(place);
        }
        return answer;
    }
    public static int check_distancing(char[][] place) {
        for (int i=0; i<5; i++) {
            for (int j=0; j<5; j++) {
                if (place[i][j] == 'P') {
                    if (i<4 && j<4 && place[i+1][j+1] == 'P') {
                        // 맨해튼 거리 2
                        if (place[i+1][j]=='X' && place[i][j+1]=='X') {}
                        else return 0;
                    }
                    if (i<4 && j>0 && place[i+1][j-1] == 'P') {
                        // 맨해튼 거리 2
                        if (place[i+1][j]=='X' && place[i][j-1]=='X') {}
                        else return 0;
                    }
                    if (j<4 && place[i][j+1] == 'P') {
                        // 맨해튼 거리 1
                        return 0;
                    }
                    if (i<4 && place[i+1][j] == 'P') {
                        // 맨해튼 거리 1
                        return 0;
                    }
                    if (j<3 && place[i][j+2] == 'P') {
                        // 맨해튼 거리 2
                        if (place[i][j+1] == 'X') {}
                        else return 0;
                    }
                    if (i<3 && place[i+2][j] == 'P') {
                        // 맨해튼 거리 2
                        if (place[i+1][j] == 'X') {}
                        else return 0;
                    }
                    // 아래쪽과 오른쪽에 대해서 체크
                }
            }
        }
        return 1;
    }
}
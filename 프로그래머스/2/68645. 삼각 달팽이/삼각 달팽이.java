class Solution {
    public int[] solution(int n) {
        int size = (n+1)*n/2;
        int[] answer = new int[size];
        int[][] arr = new int[n][n];
        int direction = 1;
        int y = 0;
        int x = 0;
        
        for (int i=1; i<=size; i++) {
            arr[y][x] = i;
            if (direction == 1) {
                if (y == n-1 || arr[y+1][x] != 0) {
                    direction = 2;
                    x++;
                } else y++;
            } else if (direction == 2) {
                if (x == n-1 || arr[y][x+1] != 0) {
                    direction = 3;
                    y--;
                    x--;
                } else x++;
            } else if (direction == 3) {
                if (arr[y-1][x-1] != 0) {
                    direction = 1;
                    y++;
                } else {
                    y--;
                    x--;
                }
            }
        }
        
        int cnt = 0;
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[0].length; j++) {
                if (arr[i][j] != 0) {
                    answer[cnt++] = arr[i][j];
                }
            }
        }
        return answer;
    }
}
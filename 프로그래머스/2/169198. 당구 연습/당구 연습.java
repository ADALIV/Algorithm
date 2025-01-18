class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        int cnt = 0;
        int num = 0;
        double temp;
        for (int[] ball : balls) {
            int x = ball[0];
            int y = ball[1];
            if (startX == x) {
                double line = Math.min(Math.pow(x, 2), Math.pow(m-x, 2)) + Math.pow((double)(startY-y)/2, 2);
                num = (int)(line * 4);
                if (startY > y) {
                    temp = Math.pow(2*n-startY-y, 2);
                }
                else {
                    temp = Math.pow(startY+y, 2);
                }
                if (temp < num) num = (int)temp;
            }
            else if (startY == y) {
                double line = Math.min(Math.pow(y, 2), Math.pow(n-y, 2)) + Math.pow((double)(startX-x)/2, 2);
                num = (int)(line * 4);
                if (startX > x) {
                    temp = Math.pow(2*m-startX-x, 2);
                }
                else {
                    temp = Math.pow(startX+x, 2);
                }
                if (temp < num) num = (int)temp;
            }
            else {
                double minx = Math.pow(startX-x, 2) + Math.pow(startY+y, 2);
                double maxx = Math.pow(startX-x, 2) + Math.pow(2*n-startY-y, 2);
                double miny = Math.pow(startY-y, 2) + Math.pow(startX+x, 2);
                double maxy = Math.pow(startY-y, 2) + Math.pow(2*m-startX-x, 2);
                num = (int)Math.min(Math.min(minx, maxx), Math.min(miny, maxy));
            }
            answer[cnt++] = num;
        }
        return answer;
    }
}
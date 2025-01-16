class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int max;
        for (int i=1; i<triangle.length; i++) {
            for (int j=0; j<triangle[i].length; j++) {
                if (j == 0) triangle[i][j] += triangle[i-1][0];
                else if (j == triangle[i].length-1) triangle[i][j] += triangle[i-1][triangle[i-1].length-1];
                else {
                    max = (triangle[i-1][j-1] > triangle[i-1][j])? triangle[i-1][j-1] : triangle[i-1][j];
                    triangle[i][j] += max;
                }
            }
        }
        for (int i=0; i<triangle[triangle.length-1].length-1; i++) {
            if (answer < triangle[triangle.length-1][i]) answer = triangle[triangle.length-1][i];
        }
        return answer;
    }
}
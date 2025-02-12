import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();
        // 직선 중 2개 선택
        for (int i=0; i<line.length; i++) {
            for (int j=i+1; j<line.length; j++) {
                Point point = crossLine(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
                if (point != null) points.add(point);
            }
        }
        
        Point min = getMin(points);
        Point max = getMax(points);
        
        char[][] arr = new char[(int)(max.y-min.y+1)][(int)(max.x-min.x+1)];
        for (char[] row : arr) {
            Arrays.fill(row, '.');
        }
        
        for (Point p : points) {
            int x = (int)(p.x - min.x);
            int y = (int)(max.y - p.y);
            arr[y][x] = '*';
        }
        String[] result = new String[arr.length];
        
        for (int i=0; i<result.length; i++) {
            result[i] = new String(arr[i]);
        }
        return result;
    }
    
    public Point crossLine(long a, long b, long e, long c, long d, long f) {
        // 교차 점 구하기
        long deno = a*d - b*c;
        if (deno == 0) return null;
        double x = (double)(b*f - e*d)/deno;
        double y = (double)(e*c - a*f)/deno;
        
        if (x%1 != 0 || y%1 != 0) return null;
        return new Point((long)x, (long)y);
    }
    public Point getMin(List<Point> points) {
        long x = points.get(0).x;
        long y = points.get(0).y;
        
        for (Point p : points) {
            if (p.x < x) x = p.x;
            if (p.y < y) y = p.y;
        }
        return new Point(x, y);
    }
    public Point getMax(List<Point> points) {
        long x = points.get(0).x;
        long y = points.get(0).y;
        
        for (Point p : points) {
            if (p.x > x) x = p.x;
            if (p.y > y) y = p.y;
        }
        return new Point(x, y);
    }
    public static class Point {
        public final long x, y;
        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}
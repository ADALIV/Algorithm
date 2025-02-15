class Solution {
    public static class Count {
        public final int cnt_0;
        public final int cnt_1;
        
        public Count(int cnt_0, int cnt_1) {
            this.cnt_0 = cnt_0;
            this.cnt_1 = cnt_1;
        }
        
        public Count add(Count other) {
            return new Count(cnt_0+other.cnt_0, cnt_1+other.cnt_1);
        }
    }
    public int[] solution(int[][] arr) {
        Count answer = count(0, 0, arr.length, arr);
        return new int[]{answer.cnt_0, answer.cnt_1};
    }
    public Count count(int x, int y, int size, int[][] arr) {
        int unit = size/2;
        for (int X=x; X<x+size; X++) {
            for (int Y=y; Y<y+size; Y++) {
                if (arr[Y][X] != arr[y][x]) {
                    return count(x, y, unit, arr)
                        .add(count(x+unit, y, unit, arr))
                        .add(count(x, y+unit, unit, arr))
                        .add(count(x+unit, y+unit, unit, arr));
                }
            }
        }
        if (arr[y][x] == 1) return new Count(0, 1);
        return new Count(1, 0);
    }
}
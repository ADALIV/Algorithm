class Solution {
    public String convert(String s, int numRows) {
        // numRows가 1일 경우, 변환할 필요가 없으므로 바로 반환
        if (numRows == 1) return s;

        // 각 행을 StringBuilder로 관리
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        // 주어진 문자열을 한 문자씩 처리
        for (int i = 0; i < s.length(); i++) {
            rows[currentRow].append(s.charAt(i));

            // 방향 전환 처리
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;  // 방향을 반대로 바꿈
            }

            // 행을 위나 아래로 이동
            currentRow += goingDown ? 1 : -1;
        }

        // 모든 행을 합쳐서 최종 결과를 반환
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}

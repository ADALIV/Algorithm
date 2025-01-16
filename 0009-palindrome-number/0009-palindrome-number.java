class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int value = x;
        int result = 0;
        while (x != 0) {
            int digit = x % 10;  // 마지막 자릿수 추출
            x /= 10;  // 마지막 자릿수 제거
            result = result * 10 + digit;  // 자릿수 추가
        }
        return (result == value);
    }
}
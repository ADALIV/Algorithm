class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        
        int start = 0, end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // 중심이 한 문자인 경우 팰린드롬 확장 (예: "aba")
            int len1 = expandAroundCenter(s, i, i);
            // 중심이 두 문자인 경우 팰린드롬 확장 (예: "bb")
            int len2 = expandAroundCenter(s, i, i + 1);
            
            // 더 긴 팰린드롬을 찾으면 시작 인덱스와 끝 인덱스를 업데이트
            int len = Math.max(len1, len2);
            if (len > (end - start)) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        
        return s.substring(start, end + 1);
    }
    
    // 팰린드롬 확장을 위한 함수
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // 확장된 팰린드롬의 길이 리턴
        return right - left - 1;
    }
}
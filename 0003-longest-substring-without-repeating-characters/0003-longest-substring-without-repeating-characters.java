class Solution {
    public int lengthOfLongestSubstring(String s) {
        Queue<Character> queue = new LinkedList<>();
        int max = 0;

        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (queue.contains(ch)) {
                max = (max < queue.size()) ? queue.size() : max;
                while (queue.contains(ch)) {
                    queue.remove();
                }
            }
            queue.add(ch);
        }
        max = (max < queue.size()) ? queue.size() : max;
        return max;
    }
}
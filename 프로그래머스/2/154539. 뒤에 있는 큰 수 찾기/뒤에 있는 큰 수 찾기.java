import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        int num;
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i=numbers.length-1; i>-1; i--) {
            if (stack.isEmpty()) {
                stack.push(numbers[i]);
                list.add(-1);
            }
            else {
                if (stack.peek() <= numbers[i]) {
                    while (!stack.isEmpty()) {
                        if (stack.peek() > numbers[i]) break;
                        stack.pop();
                    }
                    if (stack.isEmpty()) list.add(-1);
                    else list.add(stack.peek());
                    stack.push(numbers[i]);
                }
                else {
                    num = stack.peek();
                    stack.push(numbers[i]);
                    list.add(num);
                }
            }
        }
        Collections.reverse(list);
        answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}
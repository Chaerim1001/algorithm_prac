import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        char[] answer = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < number.length(); i++) {
            char temp = number.charAt(i);
            while(!stack.isEmpty() && stack.peek() < temp && k-- > 0) stack.pop();
            stack.push(temp);
        }
        
        for(int i = 0; i < answer.length; i++) {
            answer[i] = stack.get(i);
        }
        return new String(answer);
    }
}
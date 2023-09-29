import java.util.Stack;

class Solution {
    boolean solution(String s) {
        if(s.length() % 2 != 0) return false;
        
        Stack<Character> stack = new Stack<>();
        int n = 0;
        for(int i=0; i<s.length(); i++) {
            stack.push(s.charAt(i));
        }
        
        while(!stack.isEmpty()) {
            char c = stack.pop();
            if(c == '(') {
                if(n <= 0) return false;
                else n--;
            } else {
                if(stack.size() == 0) return false;
                else n++;
            }
        }
        
        return true;
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            String str = br.readLine(); // 100글자 이하
            if(str.equals(".")) break;

            if(isPossibleSentence(str)) System.out.println("yes");
            else System.out.println("no");
        }

        br.close();
    }

    static boolean isPossibleSentence(String str) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(c == '(' || c == '[') {
                stack.push(c);
            } else if(c == ')') {
                if(stack.isEmpty() || stack.peek() != '(') return false;
                else stack.pop();
            } else if(c == ']') {
                if(stack.isEmpty() || stack.peek() != '[') return false;
                else stack.pop();
            }
        }

        if(!stack.isEmpty()) return false;
        return true;
    }
}

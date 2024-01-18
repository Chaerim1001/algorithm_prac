import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());

        while(cases-->0) {
            char[] target = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();
            boolean result = true;

            for(char c: target) {
                if(c=='(') stack.push(c);
                else {
                    if(stack.isEmpty()) {
                        result = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            if(stack.isEmpty() && result) System.out.println("YES");
            else System.out.println("NO");
        }
        
        br.close();
    }
}

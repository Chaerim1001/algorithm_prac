import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        for(int i=0; i<N; i++) {
            String target = br.readLine();
            if(target.length() % 2 != 0) {
                System.out.println("NO");
                continue;
            } 
            isVPS(target);
        }
        
        br.close();
    }
    
    private static void isVPS(String target) {
        Stack<Character> stack = new Stack<>();
        for(char c: target.toCharArray()) {
            stack.push(c);
        }
        
        int n = 0;
        while(!stack.isEmpty()) {
            char c = stack.peek();
            if(c=='(') {
                if(n<=0) break;
                stack.pop();
                n--;
            } else {
                stack.pop();
                n++;
            }
        }
        
        if(n!=0 || !stack.isEmpty()) System.out.println("NO");
        else System.out.println("YES");
    }
}
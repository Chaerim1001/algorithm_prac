import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int number = 1;
        Stack<Integer> stack = new Stack<>();
        while(n>0) {
            int target = Integer.parseInt(br.readLine());

            if(target>=number) {
                for(int i=number; i<=target; i++) {
                    stack.push(i);
                    sb.append("+").append('\n');
                }
                number = target+1;
            } else if(stack.peek() != target) {
                System.out.println("NO");
                return;
            } 
            
            stack.pop();
            sb.append("-").append('\n');
            n--;
        }

        System.out.println(sb);
    }
}

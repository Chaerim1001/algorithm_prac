import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<N; i++) {
            int temp = Integer.parseInt(br.readLine());
            while (!stack.isEmpty() && stack.peek() <= temp) {
                stack.pop();
            }
            stack.push(temp);
            answer += stack.size() - 1;
        }
        
        System.out.println(answer);
        br.close();
    }
}
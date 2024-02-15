import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        
        Stack<Integer> stack = new Stack<>();
        long sum = 0;
        
        for(int i=0; i<K; i++) {
            int money = Integer.parseInt(br.readLine());
            if(money == 0 && !stack.isEmpty()) {
                sum -= stack.pop();
            } else {
                stack.add(money);
                sum += money;
            }
        }
        
        System.out.println(sum);
        br.close();
    }
}
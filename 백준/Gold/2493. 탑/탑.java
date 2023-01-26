import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<int[]> stack = new Stack<>();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            while(!stack.empty()) {
                if(stack.peek()[1] > arr[i]) {
                    System.out.print(stack.peek()[0] + " ");
                    break;
                } else {
                    stack.pop();
                }
            }
            if(stack.empty()) {
                System.out.print("0 ");
            }
            stack.push(new int[] {i+1, arr[i]});
        }
        br.close();
    }
}
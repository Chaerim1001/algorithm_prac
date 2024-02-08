import java.util.*;
import java.io.*;

public class Main {
    static Stack<Integer> stack = new Stack<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            if(st.countTokens() != 1) {
                String f = st.nextToken();
                if(f.equals("push")) {
                    int n = Integer.parseInt(st.nextToken());
                    stack.push(n);
                }
            } else {
                String f = st.nextToken();
                switch(f) {
                        case("pop"):
                            if(stack.isEmpty()) bw.write(-1 + "\n");
                            else bw.write(stack.pop() + "\n");
                            break;
                        case("size"):
                            bw.write(stack.size() + "\n");
                            break;
                        case("empty"):
                            if(stack.isEmpty()) bw.write(1 + "\n");
                            else bw.write(0 + "\n");
                            break;
                        case("top"):
                            if(stack.isEmpty()) bw.write(-1 + "\n");
                            else bw.write(stack.peek() + "\n");
                            break;
                }
            }
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}

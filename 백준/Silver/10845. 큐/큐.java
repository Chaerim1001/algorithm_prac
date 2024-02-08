import java.util.*;
import java.io.*;

public class Main {
    static List<Integer> queue = new LinkedList<>();
    
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
                    queue.add(n);
                }
            } else {
                String f = st.nextToken();
                switch(f) {
                        case("pop"):
                            if(queue.isEmpty()) bw.write(-1 + "\n");
                            else bw.write(queue.remove(0) + "\n");
                            break;
                        case("size"):
                            bw.write(queue.size() + "\n");
                            break;
                        case("empty"):
                            if(queue.isEmpty()) bw.write(1 + "\n");
                            else bw.write(0 + "\n");
                            break;
                        case("front"):
                            if(queue.isEmpty()) bw.write(-1 + "\n");
                            else bw.write(queue.get(0) + "\n");
                            break;
                        case("back"):
                            if(queue.isEmpty()) bw.write(-1 + "\n");
                            else bw.write(queue.get(queue.size()-1) + "\n");
                            break;
                }
            }
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}

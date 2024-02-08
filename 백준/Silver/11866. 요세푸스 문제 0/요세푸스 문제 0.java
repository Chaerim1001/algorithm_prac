import java.util.*;
import java.io.*;

public class Main {
    static List<Integer> queue = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> list = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            list.add(i);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("<");

        int idx = K-1;
        while(list.size() != 1) {
            if(list.size() <= idx) {
                idx %= list.size();
            }
            int target = list.remove(idx);
            bw.write(target+", ");
            idx += (K-1);
            
        }
        bw.write(list.get(0) + ">");
        
        bw.flush();
        br.close();
        bw.close();
    }
}
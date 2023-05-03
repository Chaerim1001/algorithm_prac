import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            Set<Integer> set = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                set.add(Integer.parseInt(st.nextToken()));
            }
            
            int M = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                sb.append(set.contains(Integer.parseInt(st.nextToken()))? 1 : 0).append("\n");
            }
            
            System.out.print(sb);
        }
        br.close();
    }
}
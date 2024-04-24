import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<N; i++) {
            q.add(Integer.parseInt(st.nextToken()));
        }
        
        int time = 0;
        while(!q.isEmpty()) {
            if(time>1440) break;
            
            if(q.size() == 1) {
                int h = q.poll();
                time += h;
                break;
            }
            
            int h1 = q.poll();
            int h2 = q.poll();
            
            if(h1-1 > 0) q.add(h1-1);
            if(h2-1 > 0) q.add(h2-1);
            
            time++;
        }
        
        if(time > 1440) time = -1;
        System.out.println(time);
        br.close();
    }
}
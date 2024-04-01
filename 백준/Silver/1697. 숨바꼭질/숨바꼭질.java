import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] time;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        if(N==K) {
            System.out.println(0);
            return;
        }
        
        time = new int[100_001];
        bfs(N);
        
        System.out.println(time[K]);
        br.close();
    }
    
    static void bfs(int point) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(point);
        time[point] = 0;
        
        int now = 0;
        while(!q.isEmpty()) {
            now = q.poll();
            if(now == K) break;
            
            for(int i=0; i<3; i++) {
                int next;
                
                if(i==0) next = now-1;
                else if(i==1) next = now+1;
                else next = now*2;
                
                if(next>=0 && next<time.length && time[next]==0) {
                    q.add(next);
                    time[next] = time[now] + 1;
                }
            }
        }
    }
}
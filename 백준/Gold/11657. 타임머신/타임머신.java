import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static Edge[] edges;
    static long[] result;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new Edge[M];
        result = new long[N+1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[1] = 0;
        
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start, end, time);
        }
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                Edge e = edges[j];
                if(result[e.start] != Integer.MAX_VALUE && result[e.end] > (result[e.start] + e.time)) 
                    result[e.end] = result[e.start] + e.time;
            }
        }
        
        boolean isCycle = false;
        for(int i=0; i<M; i++) {
            Edge e = edges[i];
            if(result[e.start] != Integer.MAX_VALUE && result[e.end] > (result[e.start] + e.time)) 
                isCycle = true;
        }
        
        if(isCycle) {
            System.out.println("-1");
        } else {
            for(int i=2; i<N+1; i++) {
                if(result[i] == Integer.MAX_VALUE) System.out.println("-1");
                else System.out.println(result[i]);
            }
        }
        
        br.close();
    }
}

class Edge {
    int start, end, time;
    
    public Edge(int start, int end, int time) {
        this.start = start;
        this.end = end;
        this.time = time;
    }
}
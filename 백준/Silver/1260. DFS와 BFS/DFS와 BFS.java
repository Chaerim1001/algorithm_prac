import java.util.*;
import java.io.*;

public class Main {
    static int N, M, V;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        
        arr = new ArrayList[N+1];
        visited = new boolean[N+1];
        
        for(int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<Integer>();
        }
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            
            arr[s].add(e);
            arr[e].add(s);
        }

        dfs(V);
        System.out.println();
        visited = new boolean[N+1];
        bfs(V);
        
        br.close();
    }
    
    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start); 
        visited[start] = true;
        
        while(!queue.isEmpty()) {
            int i = queue.poll();
            Collections.sort(arr[i]);
            System.out.print(i + " ");
            for(int q : arr[i]) {
                if(!visited[q]) {
                    visited[q] = true;
                    queue.add(q);
                }                
            }
        }
    }
    
    static void dfs(int start) {
        visited[start] = true;
        System.out.print(start + " ");
        Collections.sort(arr[start]);
        for(int i : arr[start]) {
            if(!visited[i]) dfs(i);
        }
    }
}
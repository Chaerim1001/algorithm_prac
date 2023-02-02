import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] arr;
    static boolean visited[];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        arr = new ArrayList[N+1];
        visited = new boolean[N+1];
        
        for(int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<Integer>();
        }
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            // 방향이 없는 그래프이므로
            arr[u].add(v);
            arr[v].add(u);
        }
        
        int cnt = 0;
        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                cnt++;
                DFS(i);
            }
        }
        System.out.println(cnt);
    }
    
    static void DFS(int v) {
        if(visited[v]) return;
        visited[v] = true;
        
        for(int i: arr[v]) {
            if(!visited[i]) DFS(i);
        }
    }
}
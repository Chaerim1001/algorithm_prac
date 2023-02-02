import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] arr;
    static boolean visited[];
    static boolean arrive;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        arr = new ArrayList[N];
        visited = new boolean[N];
        arrive = false;
        
        for(int i = 0; i < N; i++) {
            arr[i] = new ArrayList<Integer>();
        }
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }
        
        for(int i = 0; i < N; i++) {
            DFS(i,1);
            if(arrive) break;
        }
        
        if(arrive) System.out.println("1");
        else System.out.println("0");
    }
    
    static void DFS(int v, int depth) {
        if(depth == 5 || arrive) {
            arrive = true;
            return;
        }
        visited[v] = true;
        for(int i: arr[v]) {
            if(!visited[i]) DFS(i, depth+1);
        }
        visited[v] = false;
    }
}
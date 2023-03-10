import java.util.*;
import java.io.*;

public class Main {
    static int K,V,E;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static boolean result;
    static int[] check;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            arr = new ArrayList[V+1];
            check = new int[V+1];
            visited = new boolean[V+1];
            result = true;
          
            for(int j=1; j<V+1; j++) {
                arr[j] = new ArrayList<Integer>();
            }
            int v1,v2;
            for(int k=0; k<E; k++) {
                st = new StringTokenizer(br.readLine());
                v1 = Integer.parseInt(st.nextToken());
                v2 = Integer.parseInt(st.nextToken());
                arr[v1].add(v2);
                arr[v2].add(v1);
            }
            
            for(int j=1; j<V+1; j++) {
                if(result) dfs(j);
                else break;
            }
            
            if(result) System.out.println("YES");
            else System.out.println("NO");
        }
    }
        
    private static void dfs(int node) {
        visited[node] = true;
        for(int n: arr[node]) {
            if(!visited[n]) {
                visited[n] = true;
                check[n] = (check[node] + 1) % 2;
                dfs(n);
            } else if(check[n] == check[node]) result = false;
        }
    }
}
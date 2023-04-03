import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int ans = 0;
    static int deleteNode = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N];
        visited = new boolean[N];
        int root = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            tree[i] = new ArrayList<Integer>();
        }
        
        for(int i=0; i<N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if(temp != -1) {
                tree[i].add(temp);
                tree[temp].add(i);
            } else {
                root = i;
            }
        }
        
        deleteNode = Integer.parseInt(br.readLine());
        if(deleteNode == root) System.out.println(0);
        else {
            dfs(root);
            System.out.println(ans);
        }
    }
    
    static void dfs(int node) {
        visited[node] = true;
        int child = 0;
        for(int i: tree[node]) {
            if(!visited[i] && i != deleteNode) {
                child++;
                dfs(i);
            } 
        }
        if(child == 0) ans++;
    }
}
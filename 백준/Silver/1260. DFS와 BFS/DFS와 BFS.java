import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());

        graph = new List[node+1];
        for(int i=1; i<node+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<edge; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        visited = new boolean[node+1];
        dfs(startNode);

        System.out.println();

        visited = new boolean[node+1];
        bfs(startNode);
       
        br.close();
    }

    static void bfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode] = true;

        while(!queue.isEmpty()) {
            int currentNode = queue.poll();
            System.out.print(currentNode + " ");

            Collections.sort(graph[currentNode]);
            for(int node: graph[currentNode]) {
                if(!visited[node]) {
                    queue.add(node);
                    visited[node] = true;
                }
            }
        }
    }

    static void dfs(int startNode) {
        if(visited[startNode]) return;

        visited[startNode] = true;
        System.out.print(startNode + " ");
    
        Collections.sort(graph[startNode]);
        for(int node: graph[startNode]) {
            if(!visited[node]) dfs(node);
        }
    }
}
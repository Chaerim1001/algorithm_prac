import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Node>[] arr;
    static boolean[] visited;
    static int[] answer;
    static int V,E,K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        arr = new ArrayList[V+1];
        visited = new boolean[V+1];
        answer = new int[V+1];
        
        for(int i=1; i<V+1; i++) {
            arr[i] = new ArrayList<Node>();
            answer[i] = Integer.MAX_VALUE;
        }
        answer[K] = 0;
        
        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine()); 
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[u].add(new Node(v, w));
        }
        bfs();
        for(int i=1; i<V+1; i++) {
            if(!visited[i]) System.out.println("INF");
            else System.out.println(answer[i]);
        }
        br.close();
    }
    
    static void bfs() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(K, 0));
        while(!queue.isEmpty()) {
            Node now = queue.poll();
            if(visited[now.v]) continue;
            visited[now.v] = true;
            for(Node node: arr[now.v]) {
                if(answer[node.v] > answer[now.v] + node.w) {
                    answer[node.v] = answer[now.v] + node.w;
                    queue.add(new Node(node.v, answer[node.v]));
                }
            }
        }
    }
}

class Node implements Comparable<Node>{
    int v, w;

    public Node(int v, int w) {
        this.v = v;
        this.w = w;
    }
    
    @Override
    public int compareTo(Node o) {
        return w - o.w;
    }
}
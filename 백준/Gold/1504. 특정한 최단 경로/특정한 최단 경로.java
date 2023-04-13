import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Node>[] map;
    static boolean[] visited;
    static int[] distance;
    static final int INF = 200000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        map = new ArrayList[N+1];
        visited = new boolean[N+1];
        distance = new int[N+1];
        
        for(int i=1; i<=N; i++) {
            map[i] = new ArrayList<Node>();
            distance[i] = INF;
        }
        
        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            map[node1].add(new Node(node2, w));
            map[node2].add(new Node(node1, w));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        
        int result1 = 0;
        result1 += dijkstra(1, v1);
        result1 += dijkstra(v1, v2);
        result1 += dijkstra(v2, N);
        
        int result2 = 0;
        result2 += dijkstra(1, v2);
        result2 += dijkstra(v2, v1);
        result2 += dijkstra(v1, N);
        
        if(result1 >= INF && result2 >= INF) System.out.println("-1");
        else System.out.println(Math.min(result1, result2));
        
        br.close();
    }
    
    private static int dijkstra(int start, int end) {
        Arrays.fill(visited, false);
        Arrays.fill(distance, INF);
        
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        distance[start] = 0;
       
        while(!queue.isEmpty()) {
            Node now = queue.poll();
            if(!visited[now.node]) {
                visited[now.node] = true;
                for(Node n: map[now.node]) {
                    if(!visited[n.node] && distance[n.node] > distance[now.node] + n.w) {
                        distance[n.node] = distance[now.node] + n.w;
                        queue.add(new Node(n.node, distance[n.node]));
                    }
                }
            }
        }
        
        return distance[end];
    }
}

class Node implements Comparable<Node> {
    int node, w;
    
    public Node(int node, int w) {
        this.node = node;
        this.w = w;
    }
    
    @Override
    public int compareTo(Node o) {
        return w - o.w;
    }
}
import java.util.*;
import java.io.*;

public class Main {
    static int N, M, start, end;
    static int[] distance;
    static ArrayList<Node>[] map;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        distance = new int[N+1];
        map = new ArrayList[N+1];
        visited = new boolean[N+1];
        
        for(int i=1; i<N+1; i++) {
            map[i] = new ArrayList<Node>();
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            map[s].add(new Node(e, w));
        }
        
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        for(int i=1; i<N+1; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        
        int answer = dijkstra(start, end);
        System.out.println(answer);
        br.close();
    }
    
    static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distance[start] = 0;
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            if(!visited[now.end]) {
                visited[now.end] = true;
                for(Node n: map[now.end]) {
                    if(!visited[n.end] && distance[n.end] > distance[now.end] + n.w) {
                        distance[n.end] = distance[now.end] + n.w;
                        pq.add(new Node(n.end, distance[n.end]));
                    }
                }
            }
        }
        return distance[end];
    }
}
class Node implements Comparable<Node> {
    int end, w;
    
    public Node(int end, int w) {
        this.end = end;
        this.w = w;
    }
    
    @Override
    public int compareTo(Node n) {
        return w - n.w;
    }
}
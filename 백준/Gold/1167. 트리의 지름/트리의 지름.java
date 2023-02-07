import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Node>[] arr;
    static boolean[] visited;
    static int[] distance;
  
    public static void main(String[] args) throws IOException {      
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        arr = new ArrayList[V+1];
        for(int i=1; i<=V; i++) {
            arr[i] = new ArrayList<Node>();
        }
        visited = new boolean[V+1];
        distance = new int[V+1];
        
        StringTokenizer st;
        
        int num1, num2;
        for(int i=0; i<V; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            num1 = Integer.parseInt(st.nextToken());
            while(num1 != -1) {
                num2 = Integer.parseInt(st.nextToken());
                arr[v].add(new Node(num1, num2));
                num1 = Integer.parseInt(st.nextToken());
            }
        }       
        
        bfs(1);
        int max = 1;
        for(int i=2; i<=V; i++) {
            if(distance[i] > distance[max]) max = i;
        }
        visited = new boolean[V+1];
        distance = new int[V+1];
        bfs(max);
        Arrays.sort(distance);
        System.out.print(distance[V]);
    }
    
    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()) {
            int index = queue.poll();
            for(Node n: arr[index]) {
                int e = n.e;
                int value = n.value;
                if(!visited[e]) {
                    visited[e] = true;
                    queue.add(e);
                    distance[e] = distance[index] + value;
                }
            }
        }
    }
}

class Node {
    int e;
    int value;
    
    public Node(int e, int value) {
        this.e = e;
        this.value = value;
    }
}
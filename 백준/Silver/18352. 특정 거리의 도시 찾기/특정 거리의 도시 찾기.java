import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] arr;
    static int[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        
        arr = new ArrayList[N+1];
        visited = new int[N+1];
     
        for(int i=1; i<=N; i++) {
            arr[i] = new ArrayList<Integer>();
            visited[i] = -1;
        }
        
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start].add(end);
        }
        
        bfs(X);
        int count = 0;
        for(int i=1; i<=N; i++) {
            if(visited[i] == K) {
                count++;
                System.out.println(i);
            }
        }
        if(count == 0) System.out.println(-1);
        br.close();
    }
    
    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        if(visited[start] == -1) {
            queue.add(start);
            visited[start] = 0;
        }
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            for(int num: arr[temp]) {
                if(visited[num] == -1) {
                    queue.add(num);
                    visited[num] = visited[temp] + 1;
                }
            }
        }
    }
}
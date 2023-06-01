import java.io.*;
import java.util.*;

public class Main {
    static int max, start, startLink, up, down;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        max = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        startLink = Integer.parseInt(st.nextToken());
        up = Integer.parseInt(st.nextToken());
        down = Integer.parseInt(st.nextToken());
        
        visited = new int[max+1];
        
        System.out.println(bfs());
       
        br.close();
    }
    
    static String bfs() {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        visited[start] = 1;
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            if(now == startLink) return String.valueOf(visited[now]-1);
            
            if(now + up <= max) {
                if(visited[now+up] == 0) {
                    visited[now+up] = visited[now] + 1;
                    queue.add(now+up);
                }
            }
            
            if(now - down > 0) {
                if(visited[now-down] == 0) {
                    visited[now-down] = visited[now] + 1;
                    queue.add(now-down);
                }
            }
        }
        
        return "use the stairs";
    }
}
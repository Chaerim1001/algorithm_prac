import java.io.*;
import java.util.*;

public class Main {
    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static List<Queue<Node>> list;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        boolean open = true;
        int day = 0;
        while(open) {
            visited = new boolean[N][N];
            list = new ArrayList<>();
            List<Integer> count = new ArrayList<>();
            int idx = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(!visited[i][j]) {
                        list.add(new LinkedList<>());
                        int result = bfs(new Node(i, j), idx);
                        count.add(result);
                        idx++;
                    }
                }
            }
            
            open = false;
            for(int i=0; i<list.size(); i++) {
                Queue<Node> q = list.get(i);
                int size = q.size();
                if(size<=1) continue;
                
                open = true;
                int cnt = count.get(i);
                int result = (cnt / size);

                while(!q.isEmpty()) {
                    Node n = q.poll();
                    map[n.x][n.y] = result;
                }
            }
            if(!open) break;
            
            day++;
        }
        System.out.println(day);
        br.close();
    }
        
    
    static int bfs(Node start, int idx) { // 연합 찾기
        Queue<Node> q = new LinkedList<>();
        q.offer(start);
        visited[start.x][start.y] = true; 
        
        int count = map[start.x][start.y];
        list.get(idx).offer(start);
        
        while(!q.isEmpty()) {
            Node n = q.poll();
            
            for(int i=0; i<4; i++) {
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];
                
                if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
                if(!visited[nx][ny]) {
                    int gap = Math.abs(map[n.x][n.y] - map[nx][ny]);
                    if(gap>=L && gap<=R) {
                        Node next = new Node(nx, ny);
                        visited[nx][ny] = true;
                        count += map[nx][ny];
                        list.get(idx).offer(next);
                        q.offer(next);
                    }
                }
            }
        }
        
        return count;
    }
    
    static class Node {
        int x;
        int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
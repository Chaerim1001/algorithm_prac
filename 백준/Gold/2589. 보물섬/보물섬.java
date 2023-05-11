import java.io.*;
import java.util.*;
 
public class Main {
    static int R,C;
    static int dx[] = {0,1,0,-1};
    static int dy[] = {-1,0,1,0};
    static char arr[][];
    static boolean visited[][];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        visited = new boolean[R][C];
        
        for(int i=0; i<R; i++) {
            String str = br.readLine();
            for(int j=0; j<C; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        int result = 0;
        
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(arr[i][j] == 'L') {
                    visited = new boolean[R][C];
                    int temp = bfs(i,j);
                    result = Math.max(result, temp);   
                }
            }
        }
        
        System.out.println(result);
        br.close();
    }
    
    static int bfs(int i, int j) {
        Queue<Node> queue = new LinkedList<>();
        int val = 0;
        visited[i][j] = true;
        queue.add(new Node(j,i,0));
        
        while(!queue.isEmpty()) {
            Node p = queue.poll();
            for(int d=0; d<4; d++) {
                int newX = p.x + dx[d];
                int newY = p.y + dy[d];
                if(0<=newX && newX<C && 0<=newY && newY<R && !visited[newY][newX] && arr[newY][newX]=='L') {
                    visited[newY][newX] = true;
                    queue.add(new Node(newX, newY, p.cnt+1));
                    val = Math.max(val, p.cnt+1);
                }
            }
        }
        return val;
    }
    
    static class Node{
        int x;
        int y;
        int cnt;
        
        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
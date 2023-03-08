import java.util.*;
import java.io.*;

public class Main {
    static int N, min, max, count;
    static int[][] map;
    static boolean[][] visited;
    static List<Integer> result;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        min = 101;
        max = 0;
        result = new ArrayList<Integer>();
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num > max) max = num;
                if(num < min) min = num;
                map[i][j] = num;
            }
        }
        
        for(int height=min; height<=max; height++) {
            visited = new boolean[N][N];
            count = 0;
            for(int x=0; x<N; x++) {
                for(int y=0; y<N; y++) {
                    if(!visited[x][y] && map[x][y] > height) {
                        count += dfs(x, y, height);
                    }
                }
            }
            result.add(count);
        }
        result.add(1);
        Collections.sort(result, Comparator.reverseOrder());
        System.out.println(result.get(0));
        br.close();
    }
    
    static int dfs(int x, int y, int height) {
        visited[x][y] = true;
        for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                
                if(nx < 0 || ny < 0 || nx > N-1 || ny > N-1) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] > height) dfs(nx, ny, height);
            }
        }
        return 1;
    }
}
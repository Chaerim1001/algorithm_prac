import java.io.*;
import java.util.*;

public class Main {
    static int n, m, h, ans;
    static int[][] map;
    static boolean result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h+1][n+1];

        int x, y;
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
            map[x][y + 1] = 2;
        }

        for (int i=0; i<=3; i++) {
            ans = i;
            dfs(1, 0);
            if (result) break;
        }

        System.out.println((result) ? ans : -1);
    }

    static void dfs(int x, int count) {
        if (result) return;
        
        if (ans == count) {
            if (check()) result = true;
            return;
        }

        for (int i=x; i<h+1; i++) {
            for (int j=1; j<n; j++) {
                if (map[i][j] == 0 && map[i][j+1] == 0) {
                    map[i][j] = 1;
                    map[i][j+1] = 2;
                    
                    dfs(i, count + 1);
                    
                    map[i][j] = map[i][j+1] = 0;
                }
            }
        }
    }

    static boolean check() {
        for (int i=1; i<=n; i++) {
            int x = 1;
            int y = i;
            
            for (int j=0; j<h; j++) {
                if (map[x][y] == 1) y++;
                else if (map[x][y] == 2) y--;
                
                x++;
            }
            if (y!=i) return false;
        }
        return true;
    }
}
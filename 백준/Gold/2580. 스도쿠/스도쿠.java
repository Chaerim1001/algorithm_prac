import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[9][9];
        
        for(int i=0; i<9; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0, 0);
        
        br.close();
    }
    
    static void dfs(int x, int y) {   
        if(y == 9) {
            dfs(x+1, 0);
            return;
        }
        
        if(x == 9) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<9; i++) {
                for(int j=0; j<9; j++) {
                    sb.append(map[i][j]).append(' ');
                }
                sb.append('\n');
            }
            System.out.println(sb);
            System.exit(0);       
        }
        
        if(map[x][y] == 0) {
            for(int i=1; i<=9; i++) {
                if(!checkDuplicatedNumber(x, y, i)) {
                    map[x][y] = i;
                    dfs(x, y+1);
                }
            }
            map[x][y] = 0;
            return;
        }
        
        dfs(x, y+1);
    }
    
    static boolean checkDuplicatedNumber(int x, int y, int number) {
        // 숫자가 같은 행에 있는지 체크
        for(int i=0; i<9; i++) {
            if(number == map[x][i]) return true;
        }
        
        // 숫자가 같은 열에 있는지 체크
        for(int i=0; i<9; i++) {
            if(number == map[i][y]) return true;
        }
        
        int start_x = (x/3) * 3;
        int start_y = (y/3) * 3;
        
        // 숫자가 같은 구역 안에 있는지 체크
        for(int i=start_x; i<start_x+3; i++) {
            for(int j=start_y; j<start_y+3; j++) {
                if(number == map[i][j]) return true;
            }    
        }
        
        return false;
    }
}
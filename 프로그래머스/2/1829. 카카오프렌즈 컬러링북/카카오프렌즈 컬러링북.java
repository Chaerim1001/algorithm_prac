import java.util.*;

class Solution {
    static boolean[][] visited;
    static int[] dh = {-1, 1, 0, 0};
    static int[] dw = {0, 0, -1, 1};
    static int M, N;
    static int result = 0;
    static PriorityQueue<Integer> area = new PriorityQueue<>(Collections.reverseOrder());
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        M = m;
        N = n;
        visited = new boolean[m][n];
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j] && picture[i][j] != 0) {
                    result = 0;
                    dfs(i, j, picture[i][j], picture);
                    numberOfArea++;
                    area.add(result);
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = area.remove();
        return answer;
    }
    
    static public void dfs(int h, int w, int color, int[][] picture) {
        for(int i=0; i<4; i++) {
            int nextH = h + dh[i];
            int nextW = w + dw[i];
            if(nextW<0 || nextH<0 || nextH>=M || nextW>=N) continue;
            
            if(picture[nextH][nextW] == color && !visited[nextH][nextW]) {
                visited[nextH][nextW] = true;
                result++;
                dfs(nextH, nextW, color, picture);
            }
        }
    }
}
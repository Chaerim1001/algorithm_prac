import java.util.*;

class Solution {
    static int[] visited;
    static ArrayList<Integer>[] arr;
    static int count;
    public int solution(int n, int[][] computers) {
        visited = new int[n];
        arr = new ArrayList[n];
        count = 0;
        for(int i=0; i<n; i++) {
            arr[i] = new ArrayList<Integer>();
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i!=j && computers[i][j] == 1) arr[i].add(j);
            }
        }
        
        for(int i=0; i<n; i++) {
            if(visited[i] == 0) {
                dfs(i);
                count++;
            }
        }
        
        return count;
    }
    
    public void dfs(int start) {
        visited[start] = 1;
        
        for(int n: arr[start]) {
            if(visited[n] == 0) {
                dfs(n);
            }
        }
    }
}
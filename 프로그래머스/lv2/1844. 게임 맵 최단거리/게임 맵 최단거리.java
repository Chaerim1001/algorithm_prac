import java.util.*;

class Solution {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] visited;
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        visited = new int[n][m]; 
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,0));
        visited[0][0] = 1;
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            for(int i=0; i<4; i++) {
                int x = node.x + dx[i];
                int y = node.y + dy[i];
                if(x>=0 && y>=0 && x<n && y<m && maps[x][y] == 1 && visited[x][y] == 0) {
                    queue.add(new Node(x,y));
                    visited[x][y] = visited[node.x][node.y] + 1;
                }
            }
        }
        
        return visited[n-1][m-1] > 0 ? visited[n-1][m-1] : -1;
    }
}

class Node {
    int x;
    int y;
    
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
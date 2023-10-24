import java.util.*;

class Solution {
    static char map[][];
    static boolean visited[][];
    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,1,0,-1};
    static ArrayList<Integer> list = new ArrayList<>();
    
    public int[] solution(String[] maps) {
        visited = new boolean[maps.length][maps[0].length()];
        map = new char[maps.length][maps[0].length()];
       
        for(int a=0;a<maps.length ; a++){
            for(int i =0;i<maps[a].length();i++){
                map[a][i] = maps[a].charAt(i);
            }
        }
    
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[i].length;j++){
                if(!visited[i][j] && map[i][j] != 'X') list.add(bfs(i,j,map.length,map[i].length));
            }
        }
        int temp[] = list.stream()
                .mapToInt(Integer::intValue)
                .sorted()
                .toArray();
        
        return temp.length == 0 ? new int[]{-1} : temp;
    }
    
    static int bfs(int x,int y,int height,int width){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x,y));
        visited[x][y] = true;
        int sum = 0;
        while(!queue.isEmpty()){
            Node now = queue.poll();
            
            sum += map[now.x][now.y] - '0';
            for(int i=0;i<4;i++){
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];
                
                if(nextX < 0 || nextY < 0 || nextX >= height || nextY >= width) continue;
                else {
                    if(!visited[nextX][nextY] && map[nextX][nextY] != 'X'){
                        queue.add(new Node(nextX,nextY));
                        visited[nextX][nextY] = true;                    
                    }
                }
            }
        }
        return sum;
    }
}

class Node {
    int x;
    int y;
     
    public Node(int x,int y) {
        this.x = x;
        this.y = y;
    }
}
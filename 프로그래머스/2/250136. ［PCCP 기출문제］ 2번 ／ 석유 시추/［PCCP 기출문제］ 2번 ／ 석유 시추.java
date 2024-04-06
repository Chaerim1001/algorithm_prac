import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Map<Integer, List<Integer>> map;
    public int solution(int[][] land) {
        map = new HashMap<>();
        for(int i=0; i<land[0].length; i++) {
            map.put(i, new ArrayList<>());
        }
        
        for(int i=0; i<land.length; i++) {
            for(int j=0; j<land[0].length; j++) {
                if(land[i][j] == 1) {
                    bfs(land, i, j);
                }
            }
        }
        
        int answer = Integer.MIN_VALUE;
        for(int i=0; i<land[0].length; i++) {
            int count = 0;
            for(int n: map.get(i)) {
                count+=n;
            }
            answer = Math.max(count, answer);
        }

        return answer;
    }
    
    public void bfs(int[][] land, int x, int y) {
        Set<Integer> set = new HashSet<>();
        
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        
        int count = 0;
        land[x][y] = -1;
        set.add(y);
        
        while(!q.isEmpty()) {
            Node now = q.poll();    
            count++;
            
            for(int i=0; i<4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx<0 || ny<0 || nx>=land.length || ny>=land[0].length) continue;
                if(land[nx][ny] == 1) {
                    set.add(ny);
                    land[nx][ny] = -1;
                    q.offer(new Node(nx, ny));
                }
            }
        }

        for(int n: set) {
            map.get(n).add(count);
        }
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
import java.io.*;
import java.util.*;

public class Main {
    static final int ROW = 12;
    static final int COLUMN = 6;
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {-1, 1, 0, 0};
    
    static char[][] map = new char[ROW][COLUMN];
    static boolean[][] visited = new boolean[ROW][COLUMN];
    static List<Field> list;
    
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<ROW; i++) {
            String s = br.readLine();
            for(int j=0; j<COLUMN; j++) {
                map[i][j] = s.charAt(j); 
            }
        }
        
        while(true) {
            boolean finished = true;
            visited = new boolean[ROW][COLUMN];

            for(int i=0; i<ROW; i++) {
                for(int j=0; j<COLUMN; j++) {
                    if(map[i][j] != '.') {
                        list = new ArrayList<>();
                        bfs(new Field(i, j, map[i][j]));
                        
                        if(list.size() >= 4) {
                            finished = false;
                            for(int k=0; k<list.size(); k++) {
                                Field f = list.get(k);
                                map[f.r][f.c] = '.';
                            }
                        }
                    }
                }
            }
                            
            if(finished) break;
            moveDown();
            answer++;
        }

        System.out.println(answer);   
        br.close();
    }
    
    private static void bfs(Field start) {
        Queue<Field> q = new LinkedList<>();
        q.offer(start);
        list.add(start);
        visited[start.r][start.c] = true;

        while(!q.isEmpty()) {
            Field f = q.poll();
            
            for(int i=0; i<4; i++) {
                int nx = f.r + dx[i];
                int ny = f.c + dy[i];
                if(nx >= ROW || ny >= COLUMN || nx<0 || ny<0 || visited[nx][ny]) continue;
                if(map[nx][ny] == start.type && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    list.add(new Field(nx, ny, map[nx][ny]));
                    q.add(new Field(nx, ny, map[nx][ny]));
                }     
            }
        }
    }
                          
    private static void moveDown() {
        for (int i = 0; i < COLUMN; i++) {
            for (int j = ROW - 1; j > 0; j--) {
                if (map[j][i] == '.') {
                    for (int k = j - 1; k >= 0; k--) {
                        if (map[k][i] != '.') {
                            map[j][i] = map[k][i];
                            map[k][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }

    static class Field {
        int r;
        int c;
        char type;
        
        public Field(int r, int c, char type) {
            this.r = r;
            this.c = c;
            this.type = type;
        }
    }
}
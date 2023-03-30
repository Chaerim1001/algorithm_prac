import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Point> points;
    static ArrayList<ArrayList<Integer>> map;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testNum = Integer.parseInt(br.readLine());
        int x, y;
        
        while(testNum-- > 0){
            N = Integer.parseInt(br.readLine());
            points = new ArrayList<>();
            for(int j=0; j<N+2; j++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                points.add(new Point(x, y));
            }
            
            map = new ArrayList<>();
            for(int i=0; i<N+2; i++) {
                map.add(new ArrayList<>());
            }
            
            for(int i=0; i<N+2; i++) {
                for(int j=i+1; j<N+2; j++) {
                    if(getDistance(points.get(i), points.get(j)) <= 1000) {
                        map.get(i).add(j);
                        map.get(j).add(i);
                    }
                }
            }
            if(bfs()) System.out.println("happy");
            else System.out.println("sad");
            
        }
    }
    
    private static int getDistance(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);   
    }
    
    private static boolean bfs() {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N+2];
        queue.add(0);
        visited[0] = true;
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            if(now == N+1) return true;
            
            for(int next: map.get(now)) {
                if(!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        return false;
    }
}

class Point {
    int x, y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Point> list = new ArrayList<>();
        
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Point(x, y));
        }
        
        Collections.sort(list, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if(p1.y == p2.y) return p1.x - p2.x;
                return p1.y - p2.y;
            }
        });
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(Point p: list) {
            bw.append(p.x + " " + p.y);
            bw.append("\n");
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
    
    static class Point {
        int x;
        int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

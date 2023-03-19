import java.util.*;
import java.io.*;

public class Main {
    static int[] map;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        map = new int[N+1];
        for(int i=0; i<N+1; i++) {
            map[i] = i;
        }
        
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if(q==0) union(a, b);
            else {
                if(checkSame(a, b)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
        br.close();
    }
    
    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) map[b] = a;
    }
    
    private static int find(int a) {
        if(a == map[a]) return a;
        else return map[a] = find(map[a]);
    }
    
    private static boolean checkSame(int a, int b) {
        a = find(a);
        b = find(b);
        return a==b;
    }
}
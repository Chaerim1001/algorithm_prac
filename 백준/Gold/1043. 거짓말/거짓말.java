import java.io.*;
import java.util.*;

public class Main {
    static int[] p;
    static List<Integer> know_p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        if(k == 0) {
            System.out.println(M);
            return;
        }
        
        know_p = new ArrayList<>();
        for(int i=0; i<k; i++) {
            know_p.add(Integer.parseInt(st.nextToken()));
        }
        
        p = new int[N+1];
        for(int i=1; i<N+1; i++) {
            p[i] = i;
        }
        
        List<Integer>[] party = new ArrayList[M+1];
        for(int i=1; i<M+1; i++) {
            party[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            party[i].add(l);
            for(int j=1; j<n; j++) {
                int m = Integer.parseInt(st.nextToken());
                union(l, m);
                party[i].add(m);
            }
        }
        
        int result = 0;
        for(int i=1; i<M+1; i++) {
            boolean flag = true;
            for(int n: party[i]) {
                if(know_p.contains(find(p[n]))) {
                    flag = false;
                    break;
                }
            }
            
            if(flag) result++;
        }
        
        System.out.println(result);
        br.close();
    }
    
    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        
        if(know_p.contains(y)) {
            int temp = x;
            x = y;
            y = temp;
        }
        
        p[y] = x;
    }
    
    static int find(int x) {
        if(p[x] == x) return x;
        return p[x] = find(p[x]);
    } 
}
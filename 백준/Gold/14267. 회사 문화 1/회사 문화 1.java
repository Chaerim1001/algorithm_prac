import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] result;
    static ArrayList<Integer>[] people;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        people = new ArrayList[N+1];
        result = new int[N+1];
        
        for(int i=1; i<N+1; i++) {
            people[i] = new ArrayList<Integer>();
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if(temp != -1) {
                people[temp].add(i);
            }
        }
        
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            result[p] += w;
        }
        dfs(1);
        for(int i=1; i<N+1; i++) {
            System.out.print(result[i] + " ");
        }
        
        br.close();
    }
    
    static void dfs(int p) {
        for(int n: people[p]) {
            result[n] += result[p];
            dfs(n);
        }
    }
}
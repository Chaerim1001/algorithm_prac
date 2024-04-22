import java.io.*;
import java.util.*;

public class Main {
    static int L, C;
    static char[] arr;
    static boolean[] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        arr = new char[C];
        visited = new boolean[C];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++) { 
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        
        combination(0, L);

        bw.flush();
        br.close();
        bw.close();
    }
    
    static void combination(int idx, int r) throws IOException {
        if(r == 0) {
            print();
            return;
        }

        if(idx == C) return;

        visited[idx] = true;
        combination(idx+1, r-1 );

        visited[idx] = false;
        combination(idx+1, r);
    }
    
    static void print() throws IOException {
        StringBuilder sb = new StringBuilder();
        int c = 0;
        int v = 0;
        for(int i=0; i<C; i++) {
            if(visited[i]) {
               sb.append(arr[i]);
               if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i'|| arr[i] == 'o'|| arr[i] == 'u') v++;
               else c++;
            }
        }

        if(v>=1 && c>=2) bw.append(sb + "\n");
    }
}
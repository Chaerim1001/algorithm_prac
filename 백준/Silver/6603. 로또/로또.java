import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            if(k==0) break;

            int[] arr = new int[k];
            boolean[] visited = new boolean[k];
            
            for(int i=0; i<k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                visited[i] = false;
            }
            
            combination(arr, visited, 0, k, 6);
            System.out.print("\n");
        }

        br.close();
    }
    
    static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if(r==0) {
            for(int i=0; i<visited.length; i++) {
                if(visited[i]) System.out.print(arr[i] + " ");
            }
            System.out.print("\n");
            return;
        }
        
        for(int i=start; i<n; i++) {
            visited[i] = true;
            combination(arr, visited, i+1, n, r-1);
            visited[i] = false;
        }
    }
}

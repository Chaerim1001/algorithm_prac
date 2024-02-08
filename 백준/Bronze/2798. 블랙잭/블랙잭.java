import java.io.*;
import java.util.*;

public class Main {
    static int N, M, result;
    static boolean[] visited;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        visited = new boolean[N];
        arr = new int[N];
        
        result = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[3];
        find(0,  answer);
        
        System.out.println(result);
        br.close();
    }
    
    static void find(int depth, int[] answer) {
        if(depth == 3) {
            int sum = 0;
            for(int n: answer) {
                sum += n;
            }

            if(sum <= M) {
                if((M-sum) < (M-result)) result = sum;
            }
            return;
        }
        
        for(int i=depth; i<N; i++) {
            if(!visited[i]) {
                answer[depth] = arr[i];
                visited[i] = true;
                find(depth+1, answer);
                visited[i] = false;
            }
        }
    }
}

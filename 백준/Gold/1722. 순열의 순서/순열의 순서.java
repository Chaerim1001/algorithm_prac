import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int Q = Integer.parseInt(st.nextToken());
        long F[] = new long[21];
        F[0] = 1;
        int S[] = new int[21];
        boolean[] visited = new boolean[21];
        for(int i=1; i<=N; i++) {
            F[i] = F[i-1] * i;
        }
        if(Q == 1) {
            long K = Long.parseLong(st.nextToken());
            for(int i=1; i<=N; i++) {
                for(int j=1, count=1; j<=N; j++) {
                    if(visited[j]) continue;
                    if(K <= count*F[N-i]) {
                        K -= ((count-1)* F[N-i]);
                        S[i] = j;
                        visited[j] = true;
                        break;
                    }
                    count++;
                }
            }
            for(int i=1; i<=N; i++) {
                System.out.print(S[i] + " ");
            }
        } else {
            long K = 1;
            for(int i=1; i<=N; i++) {
                S[i] = Integer.parseInt(st.nextToken());
                long count = 0;
                for(int j=1; j<S[i]; j++) {
                    if(!visited[j]) count++;
                }
                K += count * F[N-i];
                visited[S[i]] = true;
            }
            System.out.println(K);
        }
        
    }
}
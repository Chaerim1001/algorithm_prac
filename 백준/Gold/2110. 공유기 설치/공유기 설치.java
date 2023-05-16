import java.io.*;
import java.util.*;

public class Main {
    static int N, C;
    static int[] home;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        home = new int[N+1];
        
        for(int i=1; i<=N; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(home);
        
        int max = 0;
        int start = 0;
        int end = home[N] - home[1];
        int d = 0;
        int answer = 0;
        
        while(start <= end) {
            int mid = (start + end) / 2;
            int s = home[1];
            int cnt = 1;
            for(int i=1; i<=N; i++) {
                d = home[i] - s;
                if(d >= mid) {
                    cnt++;
                    s = home[i];
                }
            }
            
            if(cnt >= C) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        System.out.println(answer);
        br.close();
    }
}
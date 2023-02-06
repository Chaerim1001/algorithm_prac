import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] minute;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        minute = new int[N];
        st = new StringTokenizer(br.readLine());
        
        int start = 0;
        int end = 0;
        
        for(int i = 0; i < N; i++) {
            minute[i] = Integer.parseInt(st.nextToken());
            if(start < minute[i]) start = minute[i];
            end += minute[i];
        }
        
        while(start <= end) {
            int mid = (start+end) / 2;
            int count = 0;
            int sum = 0;
            for(int i = 0; i < N; i++) {
                sum += minute[i];
                if(sum > mid) {
                    count++;
                    sum = minute[i];
                }
            }
            if(sum != 0) count++;
            
            if(count <= M) end = mid - 1;
            else start = mid + 1;
        }
        System.out.println(start);
    }
}
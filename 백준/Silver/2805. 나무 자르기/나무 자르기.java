import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] tree = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(tree); 
        
        long start = 0;
        long end = tree[N-1];
        
        while(start <= end) {
            long mid = (start+end)/2;
            long sum = 0;
            for(int t: tree) {
                if(t>mid) sum += t-mid;
            }
            
            if(sum>=M) start = mid+1;
            else end = mid-1;
        }
        
        System.out.println(end);
    }
}
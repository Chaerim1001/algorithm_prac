import java.io.*;
import java.util.*;

public class Main {
    static List<Long> list;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        list = new ArrayList<>();
        long sum = 0;
        for(int i=0; i<K; i++) {
            long length = Long.parseLong(br.readLine());
            list.add(length);
            sum += length;
        }
        
        long min = 0;
        long mid = 0;
        long max = sum / N;
        max++;
        
        while(min<max) {
            mid = (min+max)/2;
            long count = 0;
            for(long n: list) {
                count += (n / mid);
            }
        
            if(count < N) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        
        System.out.println(max-1);
        br.close();
    }
}
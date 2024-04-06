import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());    
        }
        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken()); 
        int C = Integer.parseInt(st.nextToken()); 
        
        long count = 0;
        for(int number: arr) {
            count += 1;
            if(number-B>0) count += Math.ceil(((double)(number-B)/(double)C));
        }
        
        System.out.println(count);
        br.close();
    }
}
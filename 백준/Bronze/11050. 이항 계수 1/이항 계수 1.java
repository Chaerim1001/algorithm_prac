import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int idx = 0;
        int n1 = 1;
        
        while(idx < K) {
            n1 *= (N-idx);
            idx++;
        }    
        
        int n2 = 1;
        while(K>1) {
            n2 *= K;
            K--;
        } 

        System.out.println(n1/n2);
        br.close();
    }
}

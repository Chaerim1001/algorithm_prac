import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int gcd_num = gcd(a, b);
            System.out.println(a*b/gcd_num);
        }
        br.close();
    }
    
    static int gcd(int a, int b) {
        if(b == 0) return a;
        else return gcd(b, a%b);
    }
}
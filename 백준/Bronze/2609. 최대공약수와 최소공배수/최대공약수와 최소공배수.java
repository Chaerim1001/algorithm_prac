import java.io.*;
import java.util.*;

public class Main {
    static int gcd = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        
        if(n1>n2) gcd = GCD(n1, n2);
        else gcd = GCD(n2, n1);

        int lcm = (n1 * n2) / gcd;

        System.out.println(gcd);
        System.out.println(lcm);

        br.close();
    }
    
    // 최대 공약수
    static int GCD(int n1, int n2) {
        if(n2 == 0) return n1;
         
        return GCD(n2, n1%n2);
    }
}

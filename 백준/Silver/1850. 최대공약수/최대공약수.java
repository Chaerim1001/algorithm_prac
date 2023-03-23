import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        
        long gcd_length = gcd(a, b);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(gcd_length > 0) {
            bw.write("1");
            gcd_length--;
        }
        bw.flush();
        bw.close();
        br.close();
    }
    
    static long gcd(long a, long b) {
        if(b == 0) return a;
        else return gcd(b, a%b);
    }
}
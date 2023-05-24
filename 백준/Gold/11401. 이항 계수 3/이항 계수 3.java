import java.io.*;
import java.util.*;
 
public class Main {
	final static long P = 1000000007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long N = Long.parseLong(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		
		long numer = fac(N);
		long denom = fac(K) * fac(N - K) % P;	
	
		System.out.println(numer * pow(denom, P - 2) % P);
		br.close();
	}
	
	public static long fac(long N) {
		long f = 1L;
		
		while(N > 1) {
			f = (f * N) % P;
			N--;
		}
		return f;
	}
	
	public static long pow(long base, long expo) {
		if(expo == 1) return base % P;
        
		long temp = pow(base, expo / 2);
		if(expo % 2 == 1) return (temp * temp % P) * base % P;
        
		return temp * temp % P;
    }
}
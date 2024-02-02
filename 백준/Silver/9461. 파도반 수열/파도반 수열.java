import java.io.*;

public class Main {
    static long[] P = new long[101];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        calculateP();
        
        for(int i=0; i<T; i++) {
            int target = Integer.parseInt(br.readLine());
            System.out.println(P[target]);
        }
        
        br.close();
    }
    
    static void calculateP() {
		P[0] = 0;
        P[1] = 1;
        P[2] = 1;
        P[3] = 1;
        
        for(int i=4; i<=100; i++) {
            P[i] = P[i-2] + P[i-3];
        }        
    }
}

import java.io.*;

public class Main {
    static final int M = 1_234_567_891;
    static final int R = 31;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        String str = br.readLine();
        
        System.out.println(hash(length,str));
        br.close();
    }
    
    static long hash(int length, String str) {
        long sum = 0;
        long k = 1;
        
        char[] arr = str.toCharArray();
        for(int i=0; i<length; i++) {
            int n = arr[i] - 96;
            sum += (n*k)%M;
            k = (k*R)%M;
        }
        
        return sum%M;
    }
}
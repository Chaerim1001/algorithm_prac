import java.io.*;

public class Main {
    static final int max = 1_000_000_001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 1;
        int range = 2;
        
        if(N==1) System.out.println(1);
        else {
            while(range<=N) {
                range = range + (6*count);
                count++;
            }        
            System.out.println(count);    
        }
        
        br.close();
    }
}

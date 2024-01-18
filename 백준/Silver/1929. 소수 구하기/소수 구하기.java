import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        boolean[] numbers = new boolean[end+1];
        
        numbers[0] = numbers[1] = true;
        for(int i=2; i*i<=end; i++) {
            if(!numbers[i]) {
                for(int j=i*i; j<=end; j+=i) {
                    numbers[j] = true;
                }
            }
        }
        
        for(int i=start; i<=end; i++) {
            if(!numbers[i]) System.out.println(i);
        }
        
        br.close();
    }
}

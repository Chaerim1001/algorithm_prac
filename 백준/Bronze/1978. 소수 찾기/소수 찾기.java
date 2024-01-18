import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        boolean[] numbers = new boolean[1001];
        numbers[0] = numbers[1] = true;
        
        for(int i=2; i*i<=1000; i++) {
            if(!numbers[i]) {
                for(int j=i*i; j<=1000; j+=i) {
                    numbers[j] = true;
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;
        for(int i=0; i<n; i++) {
            int target = Integer.parseInt(st.nextToken());
            if(!numbers[target]) result++;
        }

        System.out.println(result);
        br.close();
    }
}
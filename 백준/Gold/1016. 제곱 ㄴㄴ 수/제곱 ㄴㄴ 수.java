import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();
        
        boolean[] check = new boolean[(int)(max-min+1)];
        
        for(long i=2; i*i <= max; i++) {
            long p = i*i;
            long start_idx = min / p;
            if(min % p != 0) start_idx++;
            
            for(long j=start_idx; p*j <= max; j++) {
                check[(int)((j*p)-min)] = true;
            }
        }
        
        int count = 0;
        for(int i=0; i<=max-min; i++) {
            if(!check[i]) count++;
        }
        
        System.out.println(count);
    }
}
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int max_length = 10000001;
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        
        long[] arr = new long[max_length];
        for(int i=2; i<max_length; i++) {
            arr[i] = i;
        }
        
        for(int i=2; i<=Math.sqrt(max_length); i++) {
            if(arr[i] == 0) continue;
            for(int j=i+i; j<max_length; j+=i) {
                arr[j] = 0;
            }
        }
        
        int count = 0;
        for(int i=2; i<max_length; i++) {
            if(arr[i] != 0) {
                long temp = arr[i];
                while((double)arr[i] <= (double)B/(double)temp) {
                    if((double)arr[i] >= (double)A/(double)temp) count++;
                    temp = temp * arr[i];
                }
            }
        }
        
        System.out.println(count);
    }
}
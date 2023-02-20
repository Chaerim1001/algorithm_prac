import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[246913];
        Arrays.fill(arr, 0);
        arr[1] = 1;
        for(int i=2; i<246913; i++) {
            if(arr[i] == 1) continue;
            for(int j=2*i; j<246913; j+=i) arr[j] = 1;
        }
        
        while(true) {
            int n = sc.nextInt();
            if(n == 0) break;
            
            int count = 0;
            for(int i=n+1; i < 2*n+1; i++) {
                if(arr[i] == 0) count++;
            }
            System.out.println(count);
        }
    }
}
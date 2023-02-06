import java.util.Scanner;

public class Main {
    static int N, K;
    static int[] arr; 
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        arr = new int[N];
        
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        
        int count = 0;
        while(K > 0) {
            for(int i = N-1; i >= 0; i--) {
                if(arr[i] <= K) {
                    count += (K / arr[i]);
                    K %= arr[i];
                }
            }
        }
        System.out.print(count);
    }
}
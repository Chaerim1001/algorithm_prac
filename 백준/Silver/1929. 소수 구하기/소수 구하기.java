import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        
        int[] arr = new int[N+1];
        for(int i=2; i<N+1; i++) {
            arr[i] = i;
        }
        
        for(int i=2; i<=Math.sqrt(N); i++) {
            if(arr[i] == 0) continue;
            for(int j=i+i; j<N+1; j+=i) {
                arr[j] = 0;
            }
        }
        
        for(int i=M; i<N+1; i++) {
            if(arr[i] != 0) System.out.println(arr[i]);
        }
    }
}
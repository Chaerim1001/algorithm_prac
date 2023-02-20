import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[1001];
        Arrays.fill(arr, 0);
        arr[1] = 1;
        for(int i=2; i<1001; i++) {
            if(arr[i] == 1) continue;
            for(int j= 2*i; j<1001; j+=i) arr[j] = 1;
        }
        
        int count = 0;
        for(int i=0; i<N; i++) {
            int num = sc.nextInt();
            if(arr[num] == 0) count++;
        }
        
        System.out.print(count);
        sc.close();
    }
}
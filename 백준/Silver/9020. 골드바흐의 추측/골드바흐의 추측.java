import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int[] arr = new int[10001];
        Arrays.fill(arr, 0);
        arr[1] = 1;
        
        for(int i=2; i<10001; i++) {
            if(arr[i] == 1) continue;
            for(int j=2*i; j<10001; j+=i) arr[j] = 1;
        }
       
        for(int i=0; i<N; i++) {
            int num = sc.nextInt();
            int start = num / 2;
            int end = num / 2;
            
            while(true) {
                if(arr[start] == 0 && arr[end] == 0) break;
                start--;
                end++;
            }
            System.out.println(start + " " + end);
        }   
    }
}
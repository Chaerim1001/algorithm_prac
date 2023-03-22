import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[1000001];
        for(int i=2; i<arr.length; i++) {
            arr[i] = i;
        }
        for(int i=2; i<Math.sqrt(arr.length); i++) {
            if(arr[i] == 0) continue;
            for(int j=i+i; j<arr.length; j+=i) {
                arr[j] = 0;
            }
        }
        
        int N = Integer.parseInt(br.readLine());
        while(N != 0) {
            boolean isProve = false;
            for(int i=2; i<=N/2; i++) {
                if(arr[i]!=0 && arr[N-i]!=0) {
                    System.out.println(N + " = " + i + " + " + (N-i));
                    isProve = true;
                    break;
                }
            }
            if(!isProve) System.out.println("Goldbach's conjecture is wrong.");
            N = Integer.parseInt(br.readLine());
        }
    }
}
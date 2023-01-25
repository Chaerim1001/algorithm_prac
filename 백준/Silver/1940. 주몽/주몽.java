import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        int count = 0;
        int i = 0;
        int j = N - 1;
        
        while(i < j) {
            if(arr[i] + arr[j] > M) {
                j--;
            } else if (arr[i] + arr[j] < M) {
                i++;
            } else {
                count++;
                i++;
                j--;
            }
        }
        System.out.println(count);    
        bf.close();
    }
}
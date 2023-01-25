import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        long[] arr = new long[N];
        
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        int count = 0;
        int i = 0;
        int j = 1;
        
        for (int k = 0; k < N; k++) {
            i = 0;
            j = N - 1;
            while(i < j) {
                if(arr[i] + arr[j] == arr[k]) {
                    if(i != k && j != k) {
                        count++;
                        break;
                    } else if (i==k) {
                        i++;
                    } else if (j==k) {
                        j--;
                    }
                } else if(arr[i] + arr[j] < arr[k]) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        System.out.print(count);
        bf.close();
    }
}
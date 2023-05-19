import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int arr[] = new int[M];

        int sum;
        int start = 1, end = 0, mid = 0, answer = 0;

        for (int i=0; i<M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            end = Math.max(end, arr[i]);
        }

        while (start <= end) {
            mid = (start + end) / 2;
            sum = 0;

            for (int i=0; i<M; i++) {
                sum += arr[i] / mid;
                if (arr[i] % mid != 0) sum++;
            }

            if (sum > N) start = mid + 1;
            else {
                end = mid - 1;
                answer = mid;
            }
        }

        System.out.println(answer);
        br.close();
    }    
}
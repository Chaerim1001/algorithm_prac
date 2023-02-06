import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] values;
       
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        M = Integer.parseInt(br.readLine());
        values = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int value: values) {
            boolean find = false;
            
            int start = 0;
            int end = arr.length - 1;
            while(start <= end) {
                int midIndex = (start+end) / 2;
                int midValue = arr[midIndex];
                if(value > midValue) start = midIndex + 1;
                else if(value < midValue) end = midIndex - 1;
                else {
                    find = true;
                    break;
                }
            }
            
            if(find) System.out.println("1");
            else System.out.println("0");
        }  
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
 
        int N = Integer.parseInt(br.readLine());
        int[] port = new int[N];
 
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<port.length; i++) {
            port[i] = Integer.parseInt(st.nextToken());
        }
 
        int[] arr = new int[N];
        arr[0] = port[0];
        
        int idx = 1;
        int temp = 0;
        
        for (int i=1; i<N; i++) {
            if (arr[idx-1] < port[i]) arr[idx++] = port[i];
            else if (arr[0] > port[i]) arr[0] = port[i];
            else { 
                temp = Arrays.binarySearch(arr, 0, idx, port[i]);
                arr[temp<0 ? (-temp - 1) : temp] = port[i];
            }
        }
 
        bw.write(idx + "\n");
        bw.flush();
        bw.close();
        
        br.close();
    }
}
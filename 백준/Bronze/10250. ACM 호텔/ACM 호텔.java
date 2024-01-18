import java.io.*;
import java.util.*;

public class Main {
    static int H, W, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while(--test>=0) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            int floor = N % H;
            int room = (N / H) + 1;
            if(floor == 0) {
                floor = H;
                room -= 1;
            }
            
            String s = ""; 
            if(room<10) {
                s = "0";
            }

            System.out.println(floor + s + room);
        }
        br.close();
    }
}

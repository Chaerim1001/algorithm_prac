import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }
        int count = 0;
        int result = 0;
        while(!pq.isEmpty()) {
            int now = pq.poll();
            count++;
            result = Math.max(result, now*count);
        }

        System.out.println(result);
        br.close();
    }
}
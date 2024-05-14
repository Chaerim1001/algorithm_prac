import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 0;

        int[] arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        LinkedList<Integer> dq = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            dq.offer(i);
        }

        for(int i=0; i<M; i++) {
            int target = arr[i];
            int target_idx = dq.indexOf(target);
            
            if(target_idx == 0) {
                dq.pollFirst();
                continue;
            }
            
            int half = 0;
            if(dq.size()%2==0) {
                half = dq.size()/2 - 1;
            } else {
                half = dq.size()/2;
            }
            
            if(target_idx>half) {
                for(int j=0; j<dq.size()-target_idx; j++) {
                    int temp = dq.pollLast();
                    dq.offerFirst(temp);
                    count++;
                }
            } else {
                for(int j=0; j<target_idx; j++) {
                    int temp = dq.pollFirst();
                    dq.offerLast(temp);
                    count++;
                }
            }
            dq.pollFirst();
        }
        
        System.out.println(count);
        br.close();
    }
}
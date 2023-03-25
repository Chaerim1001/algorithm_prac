import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> student = new ArrayList<>();
        for(int i=0; i<N+1; i++) {
            student.add(new ArrayList<>());
        }
        
        int[] in_degree = new int[N+1];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            student.get(a).add(b);
            in_degree[b]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<N+1; i++) {
            if(in_degree[i] == 0) queue.offer(i);
        }
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");
            for(int next: student.get(now)) {
                in_degree[next]--;
                if(in_degree[next] == 0) queue.offer(next);
            }
        }
        br.close();
    }
}
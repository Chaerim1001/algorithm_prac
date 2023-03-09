import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N+1];
        
        for(int i=1; i<N+1; i++) {
            arr[i] = new ArrayList<Integer>();
        }
        
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            arr[n2].add(n1);
        }
        int max = 0;
        List<Integer> result = new ArrayList<>();
        for(int i=1; i<N+1; i++) {
            if(arr[i].size() == 0) continue;
            visited = new boolean[N+1];
            int count = bfs(i);
            if(count > max) { 
                max = count;
                result.clear();
                result.add(i);
            } else if(count == max) {
                result.add(i);
            }
        }
        
        Collections.sort(result);
        for(int i: result) {
            System.out.print(i + " ");
        }
    }
    
    static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        int cnt = 0;
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()) {
            int num = queue.poll();
            for(int i: arr[num]) {
                if(!visited[i]) {
                    cnt++;
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        return cnt;
    } 
}
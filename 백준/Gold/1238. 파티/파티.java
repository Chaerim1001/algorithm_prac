import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 987654321;
    static ArrayList<ArrayList<Town>> arr, re_arr;
    static int N, X;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
 
        arr = new ArrayList<>(); 
        re_arr = new ArrayList<>(); 
 
        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
            re_arr.add(new ArrayList<>());
        }
 
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
 
            arr.get(start).add(new Town(end, weight));
            re_arr.get(end).add(new Town(start, weight));
        }
 
        int[] dist = dijkstra(arr); 
        int[] dist_reverse = dijkstra(re_arr); 
 
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, dist[i] + dist_reverse[i]);
        }
 
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static int[] dijkstra(ArrayList<ArrayList<Town>> a) {
        PriorityQueue<Town> pq = new PriorityQueue<>();
        pq.offer(new Town(X, 0));
        
        boolean[] check = new boolean[N + 1];
        int[] d = new int[N + 1];
        Arrays.fill(d, INF);
        d[X] = 0;
 
        while (!pq.isEmpty()) {
            Town curTown = pq.poll();
            int cur = curTown.end;
 
            if (!check[cur]) {
                check[cur] = true;
 
                for (Town town : a.get(cur)) {
                    if (!check[town.end] && d[town.end] > d[cur] + town.weight) {
                        d[town.end] = d[cur] + town.weight;
                        pq.add(new Town(town.end, d[town.end]));
                    }
                }
            }
        }
        return d;
    }
}

class Town implements Comparable<Town> {
    int end;
    int weight;
 
    Town(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
 
    @Override
    public int compareTo(Town arg0) {
        return weight - arg0.weight;
    }
}

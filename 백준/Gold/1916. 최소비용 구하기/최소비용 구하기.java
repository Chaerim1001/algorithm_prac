import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<City>[] bus;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        bus = new List[N+1];
        for(int i=1; i<N+1; i++) {
            bus[i] = new ArrayList<>();
        }

        StringTokenizer st; 
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); 
            int b = Integer.parseInt(st.nextToken()); 
            int c = Integer.parseInt(st.nextToken()); 

            bus[a].add(new City(b, c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()); 
        int end = Integer.parseInt(st.nextToken());

        long[] arr = new long[N+1];
        boolean[] visited = new boolean[N+1];

        Arrays.fill(arr, Long.MAX_VALUE);
        arr[start] = 0;

        PriorityQueue<City> q = new PriorityQueue<>();
        q.add(new City(start, 0));

        while(!q.isEmpty()) {
            City c = q.poll();
            if(!visited[c.number]) {
                visited[c.number] = true;
                for(City next : bus[c.number]) {
                    if(!visited[next.number] && arr[next.number] > c.cost+next.cost) {
                        arr[next.number] = c.cost+next.cost;
                        q.add(new City(next.number, arr[next.number]));
                    }                    
                }
            }
            
        }

        System.out.println(arr[end]);
        br.close();
    }

    static class City implements Comparable<City>{
        int number;
        long cost;

        public City(int number, long cost) {
            this.number = number;
            this.cost = cost;
        }

        @Override
        public int compareTo(City c) {
            return Long.compare(this.cost, c.cost);
        }
    }
}
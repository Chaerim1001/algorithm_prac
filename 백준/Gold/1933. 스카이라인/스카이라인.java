import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static PriorityQueue<Building> pq = new PriorityQueue<>();
    static Building building;
    static ArrayList<Building> answer = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.add(new Building(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())));
        }
        
        building = pq.poll();
        while(pq.size() != 0) {
            Building now = pq.poll();
            if((building.l <= now.l) && (building.r > now.l)) {
                if(building.h >= now.h) {
                    if(building.r < now.r) pq.add(new Building(building.r, now.h, now.r));
                } else {
                    if(building.l == now.l) {
                        if(building.r > now.r) pq.add(new Building(now.r, building.h, building.r));
                    } else {
                        if(building.r > now.r) pq.add(new Building(now.r, building.h, building.r));
                        
                        answer.add(new Building(building.l, building.h, now.l));
                    }
                    
                    building = now;
                }
            } else if(building.r == now.l && building.h == now.h) {
                building.r = now.r;
            } else {
                answer.add(building);
                building = now;
            }
        }
        
        answer.add(building);
        for(int i=0; i<answer.size(); i++) {
            str_append(answer.get(i).l, answer.get(i).h);
            if(i != answer.size() - 1) {
                if(answer.get(i).r != answer.get(i+1).l) str_append(answer.get(i).r, 0);
            } else {
                str_append(answer.get(i).r, 0);
            }
        }
        
        System.out.println(sb.toString());
        br.close();
    }

    static class Building implements Comparable<Building> {
        long l;
        long h;
        long r;

        public Building(long l, long h, long r) {
            this.l = l;
            this.h = h;
            this.r = r;
        }

        public int compareTo(Building b) {
            long d = this.l - b.l;

            if(d > 0) return 1;
            else if(d < 0) return -1;

            return 0;
        }
    }
    
    static void str_append(long x, long h) {
        sb.append(x);
        sb.append(" ");
        sb.append(h);
        sb.append(" ");
    }
}
import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        PriorityQueue<Lecture> q = new PriorityQueue<>();
        PriorityQueue<Integer> endTime = new PriorityQueue<>();
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            q.add(new Lecture(start, end));
        }

        while(!q.isEmpty()) {
            Lecture now = q.poll();

            if(endTime.size() == 0 || now.start<endTime.peek()) {
                endTime.add(now.end);
                answer++;
            } else {
                endTime.poll();
                endTime.add(now.end);
            }
        }

        
		System.out.println(answer);
		br.close();
    }
    
    
    static class Lecture implements Comparable<Lecture>{
        int start;
        int end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture l) {
            if(this.start == l.start) {
                return Integer.compare(this.end, l.end);
            }

            return Integer.compare(this.start, l.start);
        }
    }
}
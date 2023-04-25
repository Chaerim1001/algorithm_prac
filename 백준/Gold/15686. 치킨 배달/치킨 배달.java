import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Node> house = new ArrayList<>();
    static ArrayList<Node> chicken = new ArrayList<>();
    static ArrayList<Node> choice = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                 
                if(temp == 1) { // house인 경우
                    house.add(new Node(i, j));
                } else if(temp == 2) { // chicken인 경우
                    chicken.add(new Node(i, j));
                }
            }
        }
        
        dfs(0, 0);
        System.out.println(answer);
    }
    
    static void dfs(int start, int depth) {
        if(depth == M) {
            int sum = 0;
            for(Node h: house) {
                int min = Integer.MAX_VALUE;
                for(Node c: choice) {
                    int distance = Math.abs(h.x - c.x) + Math.abs(h.y - c.y);
                    min = Math.min(distance, min);
                }
                sum += min;
            }
            answer = Math.min(answer, sum);
            return;
        }
        
        for(int i=start; i<chicken.size(); i++) {
            choice.add(chicken.get(i));
            dfs(i+1, depth+1);
            choice.remove(choice.size()-1);
        }
    }
    
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
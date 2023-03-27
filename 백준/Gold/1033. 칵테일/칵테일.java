import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static ArrayList<Node>[] arr;
    static boolean[] visited;
    static long lcm;
    static long[] D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList[N];
        visited = new boolean[N];
        D = new long[N];
        for(int i=0; i<N; i++) {
            arr[i] = new ArrayList<Node>();
        }
        
        lcm = 1;
        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            
            arr[a].add(new Node(b, p, q));
            arr[b].add(new Node(a, q, p));
            lcm *= (p*q/(gcd(p, q))); 
        }
        D[0] = lcm;
        dfs(0);
        
        long max = D[0];
        for(int i=1; i<N; i++) {
            max = gcd(max, D[i]);
        }
        for(int i=0; i<N; i++) {
            System.out.print(D[i]/max + " ");
        }
        br.close();
    }
    
    static void dfs(int start) {
        visited[start] = true;
        for(Node n: arr[start]) {
            int next = n.getB();
            if(!visited[next]) {
                D[next] = D[start] * n.getQ() / n.getP();
                dfs(next);
            }
        }
    }
    
    static long gcd(long n1, long n2) {
        if(n2 == 0) return n1;
        return gcd(n2, n1%n2);
    }
}

class Node {
    int b, p, q;
    
    public Node(int b, int p, int q) {
        this.b = b;
        this.p = p;
        this.q = q;
    }
    
    public int getB() {
        return this.b;
    }
    
    public int getP() {
        return this.p;
    }
    
    public int getQ() {
        return this.q;
    }
}
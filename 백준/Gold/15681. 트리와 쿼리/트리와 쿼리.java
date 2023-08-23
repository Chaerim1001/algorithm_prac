import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class Main {
	static ArrayList<Integer>[] list, tree;
	static int parent[], size[];
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(stk.nextToken());
		int R = Integer.parseInt(stk.nextToken());
		int Q = Integer.parseInt(stk.nextToken());
		
		parent = new int [N+1];
		size = new int[N+1];
		list = new ArrayList[N+1];
		tree = new ArrayList[N+1];
		
		for(int i=0; i<list.length; i++) {
			list[i] = new ArrayList<>();
			tree[i] = new ArrayList<>();
		}
		
		for(int i=1; i<N; i++) {
			stk = new StringTokenizer(br.readLine());
			int U = Integer.parseInt(stk.nextToken());
			int V = Integer.parseInt(stk.nextToken());
			
			list[U].add(V);
			list[V].add(U);
		}
		
		tree(R, -1);
		count(R);
        
		StringBuffer sb = new StringBuffer();
		while(Q-- > 0) {
			int q = Integer.parseInt(br.readLine());
			sb.append(size[q]).append("\n");
		}
        
		System.out.println(sb);
	}
	
	public static void tree(int node, int p) {
		for(int n : list[node]) {
			if(n != p) {
				tree[node].add(n);
				parent[n] = node;
				tree(n, node);
			}
		}
	}

	public static void count(int node) {
		size[node] = 1;
		
		for(int n : tree[node]) {
			count(n);
			size[node] += size[n];
		}
	}
}
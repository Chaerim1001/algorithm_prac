import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K, inDegree[], buildCnt[];
	static List<List<Integer>> list = new ArrayList<>();
	static List<Set<Integer>> remove = new ArrayList<>();
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		inDegree = new int[N+1]; 
		buildCnt = new int[N+1]; 
        
		for (int i=0;i<=N;i++) {
			list.add(new ArrayList<>());
			remove.add(new HashSet<>());
		}
        
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list.get(from).add(to); 
			inDegree[to]++;
		}
		
		for (int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st.nextToken());
			int now = Integer.parseInt(st.nextToken());
            
			if ((order == 1 && inDegree[now] != 0) || (order == 2 && buildCnt[now] == 0)) { 
				System.out.println("Lier!");
				System.exit(0);
			}
            
			if (order == 1) { 
				buildCnt[now]++;
				for (int next : list.get(now)) {
					if (!remove.get(next).contains(now)) { 
						remove.get(next).add(now); 
                        
						if (inDegree[next] == 0) continue;
						inDegree[next]--; 
					}
				}
			} else if (order == 2) {
				buildCnt[now]--; 
				if (buildCnt[now] == 0) { 
					for (int next : list.get(now)) {
						remove.get(next).clear();
						inDegree[next]++; 
					}
				}
			}
		}
        
		System.out.println("King-God-Emperor");
        br.close();
	}
}
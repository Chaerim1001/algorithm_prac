import java.util.*;

public class Main {
	static int N, K;
	static final int INF=(int)1e9;
	static int[][] graph;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		graph = new int[N+1][N+1];
		
		for(int i=0; i<=N; i++) {
			Arrays.fill(graph[i],INF);
        }
        
		for(int i=0; i<K; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			graph[a][b] = graph[b][a] = 1;
		}
		
		for(int k=1; k<=N; k++) {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    graph[i][j]=Math.min(graph[i][j],graph[i][k]+graph[k][j]);
                }
            }
        }
		      
		if(isSmall()) System.out.println("Small World!");
		else System.out.println("Big World!");
	}

	static boolean isSmall() {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if((graph[i][j]==INF && i!=j) || graph[i][j]>6) return false;
			}
		}
		return true;
	}
}
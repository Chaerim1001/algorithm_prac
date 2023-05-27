import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static ArrayList<Node> cheese;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		cheese = new ArrayList<>();
        
		for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					cheese.add(new Node(i, j));
					count += 1;
				}
			}
		}

		int time = 0;

		while(count != 0) {
			time++;
			visited = new boolean[N][M];
			dfs(0, 0); 
			melt(); 
		}

		System.out.println(time);
        br.close();
	}

	static void melt() {
		for(int i=0; i<cheese.size(); i++) {
			int x = cheese.get(i).x;
			int y = cheese.get(i).y;
			int cnt = 0;

			for(int j=0; j<4; j++) {
				int nx = x+dx[j];
				int ny = y+dy[j];

				if(map[nx][ny]==2) cnt++;
			}

			if(cnt>=2) { 
				map[x][y] = 0;
				count--;
				cheese.remove(i);
				i--;
			}
		}
	}

	static void dfs(int x, int y) {
		visited[x][y] = true;
		map[x][y] = 2; 

		for (int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];

			if (nx<0 || ny<0 || nx>=N || ny>=M || visited[nx][ny] || map[nx][ny]==1) continue;

			dfs(nx, ny); 
		}
	}
}

class Node {
	int x;
	int y;

	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
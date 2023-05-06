import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static ArrayList<Integer>[] child;
	static boolean[] visited;
	static int[] dp;
	static int[] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
        
		StringTokenizer st = new StringTokenizer(br.readLine());
		st.nextToken();
        
		child = new ArrayList[N];
        dp = new int[N];
		visited = new boolean[N];
		arr = new int[N];
        
		for (int i=0; i<N; i++) {
            child[i] = new ArrayList<>();
        }
		for (int i=1; i<N; i++) {
            child[Integer.parseInt(st.nextToken())].add(i);
        }

		Arrays.fill(dp, -1);
        
		System.out.print(solution(0));
        
        br.close();
	}
	
	static int solution(int n) {
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int num: child[n]) {
			list.add(solution(num));
		}
		
		int result = 0;
		Collections.sort(list, Collections.reverseOrder());
        
		for (int i=0; i<child[n].size(); i++) {
			result = Math.max(result, i + 1 + list.get(i));
		}
        
		return result;
	}
}
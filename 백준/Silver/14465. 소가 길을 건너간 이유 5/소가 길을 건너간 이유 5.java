import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		boolean[] off = new boolean[N+1];
		for(int i=0; i<B; i++) {
			off[Integer.parseInt(br.readLine())] = true;
		}

		int answer = 100000;
		int count = 0;
		int l = 1;
		int r = K;
		
		for(int i=l; i<=K; i++) {
			if(off[i]) count++;
		}
		l++;
		r++;
		
		for(;l<=N-K+1; l++,r++) {
			if(off[l-1] && !off[r]) count--;
			else if(!off[l-1] && off[r]) count++;
			answer = Math.min(answer, count);
		}
		
		System.out.println(answer);
        
		br.close();
	}
}
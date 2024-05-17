import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K, arr[], max = 0;
	static String str[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		str = new String[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			str[i] = st.nextToken();
		}
        
		st = new StringTokenizer(br.readLine());
		K = Integer.valueOf(st.nextToken());
		int oddEven=K%2;
        
		if(K>50) K=50;
		
		int max =0;
		int idx=-1;
		for(int i=0; i<N; i++) {
			int zeroNum=0;
			String tmp = str[i];
			for(int j=0; j<M; j++) {
				if(tmp.charAt(j) == '0')
					zeroNum++;
			}
			if(zeroNum%2 != oddEven) {
				continue;
			}
			int patern =1;
			for(int k=0; k<N; k++) {
				if(k!=i && tmp.equals(str[k])) {
					patern++;
				}
			}
			if(zeroNum<=K && patern > max) {
				max = patern;
				idx = i;
			}
		}
		if(idx!=-1) System.out.println(max);
        else System.out.println(0);
        
        br.close();
	}
}

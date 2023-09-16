import java.io.*;
import java.util.*;

public class Main { 
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
		});

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			int k = Integer.parseInt(st.nextToken());
			for (int j = 0; j < k; j++) {
				q.add(new int[] { Integer.parseInt(st.nextToken()), i });
			}
		}

		PriorityQueue<Integer> num = new PriorityQueue<>();
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < m; i++) {
			num.add(Integer.parseInt(st.nextToken()));
		}

		int result[] = new int[n];
		while (!num.isEmpty()) {
			if(q.isEmpty()) {
				break;
			}
			if (q.peek()[0] == num.peek()) {
				int temp[] = q.poll();
				num.poll();
				result[temp[1]] += 1;
			} else if (q.peek()[0] > num.peek()) {
				num.poll();
			} else {
				q.poll();
			}
		}

		for (int i = 0; i < n; i++) {
			bw.write(result[i] + " ");
		}
        
		bw.flush();
        bf.close();
	}
}
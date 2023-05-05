import java.util.*;

public class Main {
	static int N;	
	static int[] arr;
	static ArrayList<Integer> sum;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		N = scanner.nextInt();
		arr = new int[N];
		int answer = 0;
		
		for (int i = 0; i < N; i++) {
			arr[i] = scanner.nextInt();
		}
		
		sum = new ArrayList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sum.add(arr[i] + arr[j]);
			}
		}
		
		Arrays.sort(arr);
		Collections.sort(sum);
		
		for(int i=N-1; i>=0; i--) {
			for(int j=0; j<i; j++) {	
				int gap = arr[i] - arr[j];
                
				if(search(gap) && arr[i] > answer) answer = arr[i];
			}
		}
		System.out.println(answer);
	}
	
	static boolean search(int n) {
		int s = 0;
		int f = sum.size() - 1;
		int m;
		
		while(s<f) {
			m = (s+f)/2;
			
			if(sum.get(m) < n) s = m+1;
			else if(sum.get(m) > n) f = m-1;
			else if(sum.get(m) == n) return true;
		}
		
		return false;
	}

}
import java.io.*;

public class Main {
	static final int N = 1_000_001;
    static int[] arr = new int[N];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        
		solution();

        System.out.println(arr[number]);
        
        br.close();
    }
    
    static void solution() {
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;

		for(int i=3; i<N; i++) {
			arr[i] = (arr[i-1] + arr[i-2])%15746;
		}
    }
}

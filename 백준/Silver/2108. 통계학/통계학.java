import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
        int mode = 0; // 최빈값

		int[] arr = new int[N];
		int[] positive_arr = new int[4001];
		int[] negative_arr = new int[4001];

		double sum = 0;

		for(int i=0; i<N; i++) {
			int temp = Integer.parseInt(br.readLine());
			
			// 평균 계산을 위한 총합 계산
			sum += temp;
			
			// 중앙값 및 범위를 위한 배열에 삽입
			arr[i] = temp;

			// 최빈값을 구하기 위함
			if(temp>=0) positive_arr[temp]++;
			else negative_arr[Math.abs(temp)]++;
        }

		// 정렬
		Arrays.sort(arr);

        int max = 0;
        for(int i=0; i<positive_arr.length; i++) {
            max = Math.max(max, positive_arr[i]);
        }
        for(int i=0; i<negative_arr.length; i++) {
            max = Math.max(max, negative_arr[i]);
        }

        List<Integer> list = new ArrayList<>();
        for(int number: arr) {
            if(number<0) {
                if(negative_arr[Math.abs(number)] == max && !(list.contains(number))) list.add(number);
            } else {
                if(positive_arr[number] == max && !(list.contains(number))) list.add(number);
            }
        }

        if(list.size() >= 2) mode = list.get(1);
        else mode = list.get(0);

        System.out.println(Math.round(sum/N));
        System.out.println(arr[N/2]);
        System.out.println(mode);
        System.out.println(arr[N-1]-arr[0]);
	}
}
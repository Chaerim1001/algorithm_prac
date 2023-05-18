import java.util.*;

public class Main {
    static int N;
	static boolean[] c = new boolean[10]; 
	static char[] arr = new char[10];
	static ArrayList answer = new ArrayList<>();
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		for (int i=0; i<N; i++) {
			arr[i] = sc.next().toCharArray()[0];
		}

		go(0, "");
		Collections.sort(answer);

		System.out.println(answer.get(answer.size() - 1));
		System.out.println(answer.get(0));
	}
    
    	static void go(int index, String num) {
		if (index == N+1) {
			answer.add(num);
			return;
		}

		for (int i=0; i<=9; i++) {
			if (c[i])
				continue;
			if (index == 0 || check(num.charAt(index - 1), (char)(i + '0'), arr[index - 1])) {
				c[i] = true;
				go(index + 1, num + Integer.toString(i));
				c[i] = false;
			}
		}
	}
    
    static boolean check(char a, char b, char c) {
		if (c == '<') {
			if (a > b) return false;
		}
        
		if (c == '>') {
			if (a < b) return false;
		}
        
		return true;
	}

}
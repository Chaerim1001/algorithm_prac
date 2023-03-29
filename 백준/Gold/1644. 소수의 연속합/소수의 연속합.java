import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer> prime = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        getPrime();
        
        int start=0, end=0;
        int sum = 2;
        int answer = 0;
        while(start < prime.size() && end < prime.size()) {
            if(sum == N) {
                answer++;
                sum-= prime.get(start);
                start++;
            } else if(sum > N) {
                sum-= prime.get(start);
                start++;
            } else {
                end++;
                if(end >= prime.size()) break;
                sum += prime.get(end);
            }
        }
        
        System.out.println(answer);
        sc.close();
    }
    
    private static void getPrime() {
        int[] temp = new int[N+1];
        for(int i=2; i<=N; i++) {
            temp[i] = i;
        }
        
        for(int i=2; i<=Math.sqrt(N); i++) {
            for(int j=2*i; j<=N; j+=i) {
                temp[j] = 0;
            }
        }
        
        for(int i=2; i<=N; i++) {
            if(temp[i] != 0) prime.add(temp[i]);
        }
    }
}
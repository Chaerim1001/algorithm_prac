import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
        
        perm(1, 0);
        
        System.out.print(sb);   
    }
    
    static void perm(int s, int depth) {
        if(depth == M) {
            for(int i: arr) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }
        
        for(int i=s; i<=N; i++) {
            arr[depth] = i;
            perm(i+1, depth+1);
        }
    }
}
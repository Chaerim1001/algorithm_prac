import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] scores = new int[num];
        
        for(int i = 0; i < num; i++) {
            scores[i] = sc.nextInt();
        }
        
        sc.close();
        
        long sum = 0;
        long max_score = 0;
        
        for(int i = 0; i < num; i++) {
            if(scores[i] > max_score) {
                max_score = scores[i];
            }
            sum += scores[i];
        }
        
        System.out.println(sum * 100.0 / max_score / num);
    }
}
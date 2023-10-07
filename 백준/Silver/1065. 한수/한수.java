import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println(check(sc.nextInt()));
        sc.close();
    }
    
    private static int check(int num) {
        int count = 0;

        if(num<100) return num;
        else {
            count = 99; // 1~99는 무조건 한수
            for(int i=100; i<=num; i++) {
                int a = i/100; // 백의 자리
                int b = (i/10)%10; // 십의 자리
                int c = i%10; // 일의 자리

                if((a-b) == (b-c)) count++;
            }
        }
        return count;
    }         
}
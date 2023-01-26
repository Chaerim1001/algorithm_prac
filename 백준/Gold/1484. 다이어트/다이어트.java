import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int G = sc.nextInt();

        long before = 1;
        long current = 2;

        boolean flag = false;

        while(current < 100000) {
            long before_2 = before*before;
            long current_2 = current*current;
            if(current_2 - before_2 == G) {
                System.out.println(current);
                flag = true;
            }

            if(current_2 - before_2 > G) {
                before++;
            } else {
                current++;
            }
        }

        if(!flag) {
			System.out.println(-1);
		}
    }
}
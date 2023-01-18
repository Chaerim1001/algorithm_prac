import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr_size = sc.nextInt();
        int num = sc.nextInt();
        
        int[] sum_array = new int[arr_size];
        sum_array[0] = sc.nextInt();
        for(int i = 1; i < arr_size; i++) {
            sum_array[i] = sc.nextInt() + sum_array[i-1];
        }
        
        for(int i = 0; i < num; i++) {
            int startIndex = sc.nextInt();
            int endIndex = sc.nextInt();
            if(startIndex == 1) {
                System.out.println(sum_array[endIndex - 1]);
            } else {
                System.out.println(sum_array[endIndex - 1] - sum_array[startIndex - 2]);
            }
        }
    }
}
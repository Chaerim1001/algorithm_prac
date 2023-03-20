import java.util.*;

public class Main {
    public static void main(String[] args) {
        int max_length = 10000001;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[max_length];
        
        for(int i=2; i<max_length; i++) {
            arr[i] = i;
        }
        
        for(int i=2; i<Math.sqrt(max_length); i++) {
            if(arr[i] == 0) continue;
            for(int j=i+i; j<max_length; j+=i) {
                arr[j] = 0;
            }
        }
        int i = N;
        while(true) {
            if(arr[i] != 0) {
                int num = arr[i];
                if(isPalindrome(num)) {
                    System.out.println(arr[i]);
                    break;
                }
            }
            i++;
        }
    }
    
    private static boolean isPalindrome(int num) {
        String temp = num + "";
        char[] num_to_char = temp.toCharArray();
        int start = 0;
        int end = num_to_char.length - 1;
        while(start < end) {
            if(num_to_char[start] == num_to_char[end]) {
                start++;
                end--;
            } else return false;
        }
        return true;
    } 
}
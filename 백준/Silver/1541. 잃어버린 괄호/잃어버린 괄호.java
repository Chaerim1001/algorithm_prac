import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split("-"); // 55 , 50+40
        
        for(int i = 0; i < arr.length; i++) {
            String[] temp = arr[i].split("[+]");
            int sum = 0;
            if(temp.length > 1) {
                for(String num: temp) {
                    sum += Integer.parseInt(num);
                }
                arr[i] = sum + ""; 
            }    
        }
        
        int answer = Integer.parseInt(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            answer -= Integer.parseInt(arr[i]);
        }
        System.out.print(answer);   
    }
}
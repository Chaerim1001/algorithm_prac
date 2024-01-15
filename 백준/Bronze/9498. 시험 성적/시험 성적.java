import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        String result;
        
        switch(score/10) {
            case 10: result = "A";
                break;
            case 9: result = "A";
                break;
            case 8: result = "B";
                break;
            case 7:  result = "C";
                break;
            case 6: result = "D";
                break;
            default: result = "F";
                break;
        }
        
        System.out.println(result);
    }
}
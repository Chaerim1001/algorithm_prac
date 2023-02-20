import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String target = sc.next();
        int N = sc.nextInt();   
        String[] arr = new String[N];
        for(int i=0; i<N; i++) {
            arr[i] = sc.next();
        }
        
        for(int i=0; i<26; i++) {
            String temp = "";
            for(int j=0; j<target.length(); j++)
                temp += (char)((target.charAt(j) - 'a' + i) % 26 + 'a');
            
            for(int j=0; j<N; j++) {
                if(temp.contains(arr[j])){
                    System.out.print(temp);
                    return;
                }
            }
        }
    }
}
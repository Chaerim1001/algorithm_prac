import java.io.*;
import java.util.*;

public class Main {
    static String A, B;
    static int answer = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = st.nextToken();
        B = st.nextToken();
        
        find(A, 0);
        if(answer == Integer.MAX_VALUE) answer = -2;
        System.out.println(answer+1);
        br.close();
    }
    
    static void find(String number, int count) {
        if(number.equals(B)) {
            answer = Math.min(answer, count);
            return;
        }
        
        if(Long.parseLong(number) * 2 <= Long.parseLong(B)) {
            find(Long.parseLong(number) * 2 + "", count+1);
        }
        
        if(Long.parseLong(number + "1") <= Long.parseLong(B)) {
            find(number + "1" , count+1);
        }
    }
}
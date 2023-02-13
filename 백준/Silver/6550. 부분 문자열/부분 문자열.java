import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str;
        while((str = br.readLine()) != null) {
            st = new StringTokenizer(str);
            String s = st.nextToken();
            String t = st.nextToken();
            checkSubStr(s,t);
        }
    }
    
    static void checkSubStr(String s1, String s2) {
        Queue<Character> queue = new LinkedList<>();
        for(int i=0; i<s1.length(); i++) {
            queue.add(s1.charAt(i));
        }
        for(int i=0; i<s2.length(); i++) {
            if(queue.isEmpty()) break;
            if(queue.peek() == s2.charAt(i)) queue.poll();
        }
        
        if(queue.isEmpty()) System.out.println("Yes");
        else System.out.println("No");
    }
}
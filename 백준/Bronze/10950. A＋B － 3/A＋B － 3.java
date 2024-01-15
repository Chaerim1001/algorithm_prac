import java.io.*;
import java.util.*;
     
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        
        StringTokenizer st; 
        int n1, n2;
        for(int i=0; i<test; i++) {
            st = new StringTokenizer(br.readLine());
            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());
            System.out.println(n1+n2);
        }
        
        br.close();
    }
}

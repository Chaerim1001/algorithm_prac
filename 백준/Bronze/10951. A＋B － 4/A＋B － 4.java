import java.io.*;
import java.util.*;
     
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        StringTokenizer st; 
        int n1, n2;
        while((str=br.readLine())!=null) {
            st = new StringTokenizer(str);
            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());
            System.out.println(n1+n2);
        }
       
        br.close();
    }
}

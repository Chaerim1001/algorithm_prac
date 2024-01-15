import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        double n1 = Double.parseDouble(st.nextToken());
        double n2 = Double.parseDouble(st.nextToken());
        double result = n1/n2;
        
        System.out.println(result);
        
        br.close();
    }
}
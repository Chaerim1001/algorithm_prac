import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while(test-->0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            char[] arr = st.nextToken().toCharArray();

            String result = "";
            for(char c: arr) {
                for(int i=0; i<n; i++) {
                    result += c;
                }
            }
            System.out.println(result);
        }
        
        br.close();
    }
}

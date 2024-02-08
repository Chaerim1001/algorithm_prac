import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st;
        int[] numbers = new int[3];
        
        while(true) {
            String str = br.readLine();
            if(str.equals("0 0 0")) break;
            
            st = new StringTokenizer(str);
            for(int i=0; i<3; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }
            
            Arrays.sort(numbers);
            
            if((numbers[0] * numbers[0]) + (numbers[1] * numbers[1]) == (numbers[2] * numbers[2])) bw.write("right" + "\n");
            else bw.write("wrong" + "\n");
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}
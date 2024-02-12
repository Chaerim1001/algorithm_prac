import java.io.*;
import java.util.*;

public class Main {
    static final double percent = 0.15;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double result;
        int[] score = new int[N];
        
        if(N == 0) result = 0;
        else { 
            int p = (int) Math.round(N*percent);
            double sum = 0;
            for(int i=0; i<N; i++) {
                score[i] = Integer.parseInt(br.readLine()); 
                sum += score[i];
            }
            Arrays.sort(score);

            int count = 0;
            while(count<p) {
                sum -= score[count];
                sum -= score[score.length-1-count];
                count++;
            }

            result = Math.round(sum/(N-p-p));
        }

        System.out.println((int)result);
        br.close();
    }
}

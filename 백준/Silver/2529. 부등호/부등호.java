import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static String[] sign;
    static boolean[] check;
    static int[] numbers;
    static String minValue;
    static boolean minFinish = false;

    static String maxValue;
    static boolean maxFinish = false;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        sign = new String[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            sign[i] = st.nextToken();
        }
        
        numbers = new int[N+1];
        for(int i=9; i>=0; i--) {
            if(maxFinish) break;

            check = new boolean[10];
            check[i] = true;
            numbers[0] = i;
            findMax(1);
        }
        System.out.println(maxValue);

        for(int i=0; i<10; i++) {
            if(minFinish) break;

            check = new boolean[10];
            check[i] = true;
            numbers[0] = i;
            findMin(1);
        }
        System.out.println(minValue);
        
        br.close();
    }
    
    
    static void findMin(int depth) {
        if(minFinish) return;

        if(depth == N+1) {
            String min = "";
            for(int n: numbers) {
                min += n;
            }
            minValue = min;
            minFinish = true;
            return;
        }
        
        String s = sign[depth-1];
        int pre = numbers[depth-1];
        if(s.equals("<")){
            for(int i=pre+1; i<10; i++) {
                if(!check[i]) {
                    numbers[depth] = i;
                    check[i] = true;
                    findMin(depth+1);
                    check[i] = false;
                }
            }
        } else {
            for(int i=0; i<pre; i++) {
                if(!check[i]) {
                    numbers[depth] = i;
                    check[i] = true;
                    findMin(depth+1);
                    check[i] = false;
                }
            }
        }
    }

    static void findMax(int depth) {
        if(maxFinish) return;

        if(depth == N+1) {
            String max = "";
            for(int n: numbers) {
                max += n;
            }
            maxValue = max;
            maxFinish = true;
            return;
        }
        
        String s = sign[depth-1];
        int pre = numbers[depth-1];
        if(s.equals("<")){
            for(int i=9; i>pre; i--) {
                if(!check[i]) {
                    numbers[depth] = i;
                    check[i] = true;
                    findMax(depth+1);
                    check[i] = false;
                }
            }
        } else {
            for(int i=pre-1; i>=0; i--) {
                if(!check[i]) {
                    numbers[depth] = i;
                    check[i] = true;
                    findMax(depth+1);
                    check[i] = false;
                }
            }
        }
    }
}
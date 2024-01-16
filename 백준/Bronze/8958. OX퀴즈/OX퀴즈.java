import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        
        for(int i=0; i<test; i++) {
            String str = br.readLine();
            System.out.println(getScore(str));
        }

        br.close();
    }

    static int getScore(String str) {
        char[] arr = str.toCharArray();

        int score = 0;
        int sum = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == 'X') score = 0;
            else score += 1;

            sum += score;
        }

        return sum;
    }
}

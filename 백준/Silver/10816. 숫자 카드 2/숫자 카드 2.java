import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] cards = new int[20_000_001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) { 
            int card = Integer.parseInt(st.nextToken());
            cards[card + 10_000_000]++;
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(cards[target+10_000_000] + " ");
        }

        System.out.println(sb);
        br.close();
    }
}

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> cards = new LinkedList<>();
        for(int i=1; i<=n; i++) {
            cards.add(i);
        }

        while(cards.size() > 1) {
            cards.poll();
            int next = cards.poll();
            cards.add(next);
        }

        System.out.println(cards.poll());

        br.close();
    }
}

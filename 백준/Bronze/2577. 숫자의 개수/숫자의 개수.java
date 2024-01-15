import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        char[] result = ((A * B * C) + "").toCharArray();
        Map<Integer, Integer> map = new HashMap<>();

        
        for(char c: result) {
            if(map.containsKey(c-'0')) map.put(c-'0', map.get(c-'0')+1);
            else map.put(c-'0', 1);
        }

        for(int i=0; i<10; i++) {
            System.out.println(map.getOrDefault(i, 0));
        }

        br.close();
    }
}

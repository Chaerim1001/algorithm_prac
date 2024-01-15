import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toUpperCase().toCharArray();
        
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for(char c: str) {
            if(map.containsKey(c)) map.put(c, map.get(c)+1);
            else map.put(c, 1);

            if(max<map.get(c)) max = map.get(c);
        }
        
        String result = "";
        for(char key: map.keySet()) {
            if(map.get(key) == max) result += key;
        }
        if(result.length() != 1) result = "?";
        
        System.out.println(result);
        br.close();
    }
}

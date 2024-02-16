import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        List<Integer> numbers = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++) {
            numbers.add(arr[i] - '0');
        }
        
        Collections.sort(numbers, Collections.reverseOrder());

        for(int i: numbers) {
            System.out.print(i);
        }
        
        br.close();
    }
}
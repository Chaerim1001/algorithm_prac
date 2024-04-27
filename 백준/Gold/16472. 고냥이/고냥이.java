import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String string = br.readLine();
        
        int[] alphabet = new int[26];
        int count = 0;
        int result = 0;

        for(int start = 0, end = 0; end < string.length(); end++) {
            if(alphabet[string.charAt(end) - 'a']++ == 0) {
                count++;
            }
            
            while (N < count && start < end) {
                if (--alphabet[string.charAt(start++) - 'a'] == 0) count--;
            }
            result = Math.max(result, end - start + 1);
        }
        System.out.println(result);
    }
}
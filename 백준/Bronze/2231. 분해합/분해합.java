import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        
        boolean check = false;
        for(int i=1; i<target; i++) {
            String n = i + "";
            int count = 0;              
            for(char c: n.toCharArray()) {
                count += (c -'0');
            }

            count += i;
            if(count == target) {
                check = true;
                System.out.println(i);
                break;
            }
        }

        if(!check) System.out.println(0);
        
        br.close();
    }
}
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            char[] target = br.readLine().toCharArray();
            
            if(target[0] == '0') break;
                
            boolean result = true;
            for(int i=0; i<target.length/2; i++) {
                if(target[i] != target[target.length-1-i]) {
                    result = false;
                    break;
                }
            }
            
            if(result) System.out.println("yes");
            else System.out.println("no"); 
        }
        
        br.close();
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // 들어간 차
        List<String> in = new LinkedList<>();
        for(int i=0; i<N; i++) {
            in.add(br.readLine());
        }
        // 나온 차
        List<String> out = new LinkedList<>();
        for(int i=0; i<N; i++) {
            out.add(br.readLine());
        }
        
        int answer = 0;
        while(!out.isEmpty()) {
            if(!in.get(0).equals(out.get(0))) {
                answer++;
                in.remove(out.get(0));
            } else {
                in.remove(0);
            }
            out.remove(0);
        }
        
        System.out.println(answer);
        br.close();
    }
}
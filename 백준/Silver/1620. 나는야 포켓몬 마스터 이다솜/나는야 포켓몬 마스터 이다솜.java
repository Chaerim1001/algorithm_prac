import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, String> keyNumber = new HashMap<>();
        Map<String, Integer> keyName = new HashMap<>();
        
        for(int i=1; i<N+1; i++) {
            String name = br.readLine();
            keyNumber.put(i, name);
            keyName.put(name, i);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<M; i++) {
            String target = br.readLine();
            if(target.length() < 2) {
                bw.append(keyNumber.get(Integer.parseInt(target)));
            } else {
                if(65 <= target.charAt(0) && target.charAt(0) <= 90) bw.append(keyName.get(target) + "");
                else if(65 <= target.charAt(target.length()-1) && target.charAt(target.length()-1) <= 90) bw.append(keyName.get(target) + "");
                else bw.append(keyNumber.get(Integer.parseInt(target)));
            }

            bw.append("\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}

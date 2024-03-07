import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i=0; i<T; i++) {
            Map<String, Integer> clothes = new HashMap<>();
            int N = Integer.parseInt(br.readLine());

            for(int j=0; j<N; j++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String key = st.nextToken();

                clothes.put(key, clothes.getOrDefault(key, 0)+1);
            }

            int count = 1;
            for(Map.Entry<String, Integer> eMap : clothes.entrySet()) {   
                count *= (eMap.getValue()+1);
            }

            bw.append(count-1 + "\n");
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}

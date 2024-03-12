import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            map.put(br.readLine(), 1);
        }
        
        List<String> list = new ArrayList<>();
        int count = 0;
        for(int i=0; i<m; i++) {
            String name = br.readLine();
            if(map.containsKey(name)) {
                count++;
                list.add(name);
            }
        }
        
        Collections.sort(list);
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.append(count + "\n");
        
        for(String s: list) {
             bw.append(s + "\n");
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}
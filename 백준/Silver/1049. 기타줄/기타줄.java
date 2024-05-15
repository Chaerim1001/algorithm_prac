import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer> unit = new ArrayList<>();
        List<Integer> each = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            unit.add(Integer.parseInt(st.nextToken()));
            each.add(Integer.parseInt(st.nextToken()));
        }
        
        Collections.sort(unit);
        Collections.sort(each);
        
        // 모두 묶음으로
        if(N%6 == 0) {
            min = Math.min(min, (N/6)*unit.get(0));
        } else {
            min = Math.min(min, ((N/6)+1)*unit.get(0));
        }
        // 모두 낱개로
        min = Math.min(min, N*each.get(0));
        
        // 묶음 + 낱개
        min = Math.min(min, (N/6)*unit.get(0) + (N%6)*each.get(0));
        
        System.out.println(min);
        br.close();
    }
}
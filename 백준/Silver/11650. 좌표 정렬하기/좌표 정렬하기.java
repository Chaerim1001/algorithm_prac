import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            if(map.containsKey(x)) map.get(x).add(y);
            else {
                map.put(x, new ArrayList<>());
                map.get(x).add(y);
            }
        }

        List<Integer> x_list = new ArrayList<>(map.keySet());
        Collections.sort(x_list);

        for(int x: x_list) {
            List<Integer> y_list = map.get(x);
            Collections.sort(y_list);

            for(int y: y_list) {
                System.out.println(x + " " + y);
            }
        }
    }
}

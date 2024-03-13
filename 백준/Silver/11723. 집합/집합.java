import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(N-->0) {
            st = new StringTokenizer(br.readLine());
            String function = st.nextToken();
            int number = 0;
            switch(function) {
                case "add" : {
                    number = Integer.parseInt(st.nextToken());
                    set.add(number);
                    break;
                }
                case "remove" : {
                    number = Integer.parseInt(st.nextToken());
                    set.remove(number);
                    break;
                }
                case "check" : {
                    number = Integer.parseInt(st.nextToken());
                    if(set.contains(number)) {
                        bw.append(1 + "\n");
                    } else {
                        bw.append(0 + "\n");
                    }
                    break;
                }
                case "toggle" : {
                    number = Integer.parseInt(st.nextToken());
                    if(set.contains(number)) {
                        set.remove(number);
                    } else {
                        set.add(number);
                    }
                    break;
                }
                case "all" : {
                    set.clear();
                    for (int k = 0; k < 20; k++) {
                        set.add(k + 1);
                    }
                    break;
                }
                case "empty" : {
                   set.clear();
                   break;
                }
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
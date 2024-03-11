import java.io.*;
import java.util.*;

public class Main{
    static int n;
    static String[] people;
    static ArrayList<String> list;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        while(T-->0) {
            result = Integer.MAX_VALUE;
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            if(n>=33) {
                bw.append(0 + "\n");
                continue;
            }
            
            people = new String[n];
            list = new ArrayList<>();
            for(int i=0; i<n; i++) {
                people[i] = st.nextToken();
            }
            
            combination(0, 0);
            bw.append(result+"\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
    
    static void distance() {
        int sum = 0;
        sum += calculate(list.get(0), list.get(1));
        sum += calculate(list.get(0), list.get(2));
        sum += calculate(list.get(1), list.get(2));
        
        result = Math.min(result, sum);
    }
    
    static int calculate(String a, String b) {
        int count = 0;
        if(!a.equals(b)) {
            for(int i=0; i<4; i++) {
                if(a.charAt(i) != b.charAt(i)) count++;
            }
        }
        
        return count;
    }
    
    static void combination(int start, int count) {
        if(result == 0) return;
        
        if(count==3) {
            distance();
            return;
        }
        
        for(int i=start; i<n; i++) {
            list.add(people[i]);
            combination(i+1, count+1);
            list.remove(list.size()-1);
        }
    }
}

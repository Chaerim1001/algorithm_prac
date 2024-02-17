import java.io.*;
import java.util.*;

public class Main {
    static People[] p;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        p = new People[N];
        
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            p[i] = new People(weight, height);
        }
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<N; i++) {
            bw.append(calculate(i) + " ");
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
    
    static class People {
        int weight;
        int height;
        
        public People(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }
    
    static int calculate(int p_idx) {
        int count = 0;
        
        for(int i=0; i<p.length; i++) {
            if(i == p_idx) continue;
            else {
                if(p[p_idx].height < p[i].height && p[p_idx].weight < p[i].weight) count++;
            }
        }
        
        return count + 1;
    }
}

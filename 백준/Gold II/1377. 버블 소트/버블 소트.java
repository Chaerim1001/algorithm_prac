import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Data[] arr = new Data[N];
        
        for(int i=0; i<N; i++) {
            arr[i] = new Data(Integer.parseInt(br.readLine()), i);
        }
        
        Arrays.sort(arr);
        int gap = Integer.MIN_VALUE;
        for(int i=0; i<N; i++) {
            int n = arr[i].idx - i;
            gap = Math.max(gap, n);
        }
        
        System.out.println(gap+1);
        br.close();
    }
    
    static class Data implements Comparable<Data> {
        int value;
        int idx;
        
        public Data(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }
        
        @Override
        public int compareTo(Data d) {
            return this.value - d.value;
        }
    }
}

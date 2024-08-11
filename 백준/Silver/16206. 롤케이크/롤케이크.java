import java.io.*;
import java.util.*;

public class Main {
    static final int EDIBLE_SIZE = 10;
    
    static int cake, M;
    static int result = 0;
    static PriorityQueue<Integer> cakes;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int cake = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        cakes = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if(a%EDIBLE_SIZE == 0) {
                    if(b%EDIBLE_SIZE == 0) return a-b;
                    else return -1;
                } else if(b%EDIBLE_SIZE == 0) return 1;
                
                return a-b;
            }
        });
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<cake; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if(temp>EDIBLE_SIZE) cakes.add(temp);
            else if(temp==EDIBLE_SIZE) result++;
        }
        
        while(M>0 && cakes.size()>0) {
            int size = cakes.poll();

            size -= EDIBLE_SIZE;
            result++;

            if(size>EDIBLE_SIZE) cakes.add(size);
            else if(size==EDIBLE_SIZE) result++;

            M--;
        }
        
        System.out.println(result);
        br.close();
    }
}
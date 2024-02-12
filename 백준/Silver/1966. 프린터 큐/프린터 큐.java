import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        
        int[] arr;
        StringTokenizer st;
        int n, targetIdx;
        for(int i=0; i<testCase; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            targetIdx = Integer.parseInt(st.nextToken());
      
            arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            
            int result = solution(arr, targetIdx);
            System.out.println(result);
        }
        
        br.close();
    }
    
    static int solution(int[] arr, int targetIdx) {
        int count = 0;
        List<Integer> sorted_list = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++) {
            sorted_list.add(arr[i]);
        }
        Collections.sort(sorted_list);
        
        int idx = 0;
        while(sorted_list.size()>0) {
            if(sorted_list.get(sorted_list.size()-1) == arr[idx]) {
                if(idx == targetIdx) break;
                else {
                    arr[idx] = 0;
                    sorted_list.remove(sorted_list.size()-1);
                    count++;
                }
            } 
            idx++;
            if(idx == arr.length) idx = 0;
        }
        
        return count+1;
    }
}

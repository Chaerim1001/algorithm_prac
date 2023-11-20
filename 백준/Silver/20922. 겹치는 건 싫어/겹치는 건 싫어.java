import java.io.*;
import java.util.*; 
 
public class Main {
    static int n, k;
    static Map<String, Integer> map = new HashMap<>();
    static int[] arr;
    static int[] cnt;
    static int result;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
 
        st = new StringTokenizer(br.readLine());
 
        arr = new int[n];
        cnt = new int[100001];
 
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        solution();
        System.out.println(result);
        br.close();
    }
 
    private static void solution() {
        int left = 0;
        int right = 0;
 
        while(left<=right){
            if(right<=n-1 && cnt[arr[right]] < k){
                cnt[arr[right]]++;
                right++;
            } else if(cnt[arr[right]]==k){
                cnt[arr[left]]--;
                left++;
            }
            result = Math.max(right-left,result);
 
            if(right==n) return;
        }
    }
}
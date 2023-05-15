import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] card;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        card = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(card);
        
        for(int i=0; i<M; i++) {
            if(search(arr[i])) System.out.print("1 ");
            else System.out.print("0 ");
        }
    }
    
    static boolean search(int number) {
        int mid;
        int low = 0;
        int high = card.length - 1;
        
        while(low <= high) {
            mid = (low + high) / 2;
            
            if(card[mid] == number) return true;
            else if(card[mid] < number) low = mid + 1;
            else high = mid - 1;
        }
        
        return false;
    }
}
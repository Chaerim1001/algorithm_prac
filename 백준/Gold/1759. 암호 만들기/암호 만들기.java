import java.util.*;
import java.io.*;

public class Main {
    static int L, C;
    static char[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visited = new boolean[C];
        arr = new char[C];
        
        st = new StringTokenizer(br.readLine()); 
        for(int i=0; i<C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        
        Arrays.sort(arr);
        makeCode(0, 0);
        
        br.close();
    }
    
    static void makeCode(int start, int length) {
        if(length == L) {
            StringBuilder sb = new StringBuilder();
            int v = 0;
            int c = 0;
            
            for(int i=0; i<C; i++) {
                if(visited[i]) {
                    if(isVowel(arr[i])) v++;
                    else c++;
                    
                    sb.append(arr[i]);
                }
            }
            
            if(v>=1 && c>=2) System.out.println(sb);
            
        } else {
            for(int i=start; i<C; i++) {
                visited[i] = true;
                makeCode(i+1, length+1);
                visited[i] = false;
            }
        }
    }
    
    static boolean isVowel(char c) {
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u') return true;
        else return false;
    }
}
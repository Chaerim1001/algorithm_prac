import java.io.*;

public class Main {
    // a - 97
    // 알파벳 총 26개
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        answer = 0;
        
        for(int i=0; i<num; i++) {
            checkGroupWord(br.readLine());
        }
        
        System.out.println(answer);
        br.close();
    }
    
    private static void checkGroupWord(String word) {
        int[] a = new int[26];
        char before = word.charAt(0);
        a[before-97]++;
        for(int i=1; i<word.length(); i++) {
            char c = word.charAt(i);
            if(before!=c) {
                if(a[c-97]>0) return;
                else {
                    a[c-97]++;
                    before = c;
                }
            }else a[before-97]++;
        }
        answer++;
    }
}
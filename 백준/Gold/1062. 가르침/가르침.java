import java.util.*;
import java.io.*;

class Main{
    static boolean[] check = new boolean[26];
    static int result = Integer.MIN_VALUE;
    static int N, K;
    static String[] arr;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // a, n, t, i, c 는 무조건 가르쳐야 함
        if(K<5) {
            System.out.println(0);
            return;
        } else if(K==26) {
            System.out.println(N);
            return;
        }

        check['a'-'a'] = true;
        check['n'-'a'] = true;
        check['t'-'a'] = true;
        check['i'-'a'] = true;
        check['c'-'a'] = true;

        arr = new String[N];
        for(int i=0; i<N; i++) {
            String temp = br.readLine();
            arr[i] = temp.substring(4, temp.length()-4);
        }

        dfs(0, 0);
        System.out.println(result);
        br.close();
	}

    static void dfs(int alpha, int count) {
        if(count == (K-5)) {
            int max = 0;
            for(String s : arr) {
                boolean able = true;
                for(int i=0; i<s.length(); i++) {
                    if(!check[s.charAt(i)-'a']) {
                        able = false;
                        break;
                    }
                }
                if(able) max++;
            }
            result = Math.max(max, result);
            return;
        }

        for(int i=alpha; i<26; i++) {
            if(!check[i]) {
                check[i] = true;
                dfs(i+1, count+1);
                check[i] = false;
            }
        }
    }
}
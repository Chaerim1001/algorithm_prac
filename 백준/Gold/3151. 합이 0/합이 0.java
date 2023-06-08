import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long answer = 0L;
    static int[] coding_skills;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        coding_skills = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            coding_skills[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(coding_skills);
        
        for (int i = 0; i < N; i++) {
            if (coding_skills[i] > 0) break;
            
            int start = i + 1;
            int end = N - 1;

            while (start < end) {
                int s = 1;
                int e = 1;
                int now = coding_skills[i] + coding_skills[start] + coding_skills[end];
                if (now == 0) {
                    if (coding_skills[start] == coding_skills[end]) { 
                        answer += comb(end - start + 1);
                        break;
                    }

                    while (start + 1 < end && coding_skills[start] == coding_skills[start + 1]) {
                        s++;
                        start++;
                    }
  
                    while (start < end - 1 && coding_skills[end] == coding_skills[end - 1]) {
                        e++;
                        end--;
                    }

                    answer += s * e;
                }

                if (now > 0) end--;
                else start++;
            }
        }
        
        System.out.println(answer);
        br.close();
    }

    static int comb(int num) {
        return num * (num - 1) / 2;
    }
}
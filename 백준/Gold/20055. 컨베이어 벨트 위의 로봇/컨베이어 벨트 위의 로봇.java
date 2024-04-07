import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int answer = 0;
    static int[] belt; 
    static boolean[] robot;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        belt = new int[2*N];
        robot = new boolean[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<2*N; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }
        
        simulation();
        
        System.out.println(answer);
        br.close();
    }

    private static void simulation() {
        int count = 0;
        while(count<K) {
            answer++;
            // 1. 로봇과 함께 회전하기
            int temp = belt[2*N-1];
            for(int i=2*N-1; i>0; i--) {
                belt[i] = belt[i-1];
            }
            belt[0] = temp;
            
            for(int i=N-1; i>0; i--) {
                robot[i] = robot[i-1];
            }
            robot[0] = false;
            
            // 2. 로봇 옮기기
            if(robot[N-1]) robot[N-1] = false;
            for(int i=N-2; i>=0; i--) {
                if(robot[i]) {
                    if(!robot[i+1] && belt[i+1]>0) {
                        robot[i] = false;
                        robot[i+1] = true;
                        belt[i+1] -= 1;
                        if(belt[i+1] == 0) count++;
                    } 
                }
            }
            
            // 3. 로봇 올리기
            if(belt[0] > 0) {
                belt[0] -= 1;
                if(belt[0] == 0) count++;
                robot[0] = true;
            }
        }
    }
}
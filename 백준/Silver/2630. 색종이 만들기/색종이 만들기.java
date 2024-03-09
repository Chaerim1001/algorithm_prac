import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] paper;
    static int blue = 0;
    static int white = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(0, 0, N);
        
        System.out.println(white);
        System.out.println(blue);

        br.close();
    }

    static void solution(int x, int y, int size) {
        int result = sameColor(x, y, size);

        if(result == 1) {
            blue++;
            return;
        } else if(result == 0) {
            white++;
            return;
        }

        solution(x, y, size/2);
        solution(x+(size/2), y, size/2);
        solution(x, y+(size/2), size/2);
        solution(x+(size/2), y+(size/2), size/2);
    }

    /***
     * 
     * @param startX 왼쪽 최상단 x좌표
     * @param startY 왼쪽 최상단 y좌표
     * @param size 사각형 사이즈
     * @return 모두 같은 색상이면 color 반환, 다르면 -1 반환
     */
    static int sameColor(int startX, int startY, int size) {
        int color = paper[startX][startY];

        for(int i=startX; i<startX+size; i++) {
            for(int j=startY; j<startY+size; j++) {
                if(paper[i][j] != color) {
                    return -1;
                }
            }
        }
        return color;
    }
}

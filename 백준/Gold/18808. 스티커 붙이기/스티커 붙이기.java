import java.io.*;
import java.util.*;

public class Main{
    static int N, M, K;
    static int[][] notebook;
    static Queue<int[][]> stickers;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()); 
        
        notebook = new int[N][M];
        stickers = new LinkedList<int[][]>();
        
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int[][] stickerInput = new int[r][c];
            for(int j=0; j<r; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<c; k++) {
                    stickerInput[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            stickers.add(stickerInput);
        }

        while(!stickers.isEmpty()) {
            int[][] sticker = stickers.poll();
            int n = sticker.length;
            int m = sticker[0].length;
            boolean check = false;
            
            n = sticker.length;
            m = sticker[0].length;
            
            // 0도
            for(int i=0; i<N-n+1; i++) {
                for(int j=0; j<M-m+1; j++) {
                    if(putCheck(i, j, sticker)) {
                        putSticker(i, j, sticker);
                        check = true;
                        break;
                    }
                }
                if(check) break;
            }
            
            if(!check) {
                int idx = 0;
                while(idx<3) {
                    sticker = rotateSticker(sticker);
                    n = sticker.length;
                    m = sticker[0].length;

                    for(int i=0; i<N-n+1; i++) {
                        for(int j=0; j<M-m+1; j++) {
                            if(putCheck(i, j, sticker)) {
                                putSticker(i, j, sticker);
                                check = true;
                                break;
                            }
                        }
                        if(check) break;
                    }

                    if(check) break;
                    else idx++;
                }
            }  
        }
        
        System.out.println(findStickers());
        br.close();
    }
    
    /*
    ** 붙일 수 있는 자리인지 확인하는 함수
    */ 
    static boolean putCheck(int startN, int startM, int[][] sticker) {
        int n = 0;
        
        for(int i=startN; i<startN+sticker.length; i++) {
            int m = 0;
            for(int j=startM; j<startM+sticker[0].length; j++) {
                if(i>=N || j>=M || n>=N || m>=M) return false;
                if(notebook[i][j] == 1 && sticker[n][m] == 1) return false;
                m++;
            }
            n++;
        }
        return true;
    }

    /*
    ** 스티커 붙이기 함수
    */
    static void putSticker(int startN, int startM, int[][] sticker) {
        int n = 0;
        
        for(int i=startN; i<startN+sticker.length; i++) {
            int m = 0;
            for(int j=startM; j<startM+sticker[0].length; j++) {
                if(notebook[i][j] == 0 && sticker[n][m] == 1) notebook[i][j] = 1;
                m++;
            }
            n++;
        }
    }
    
    /*
    ** 스티커 90도 회전하는 함수
    */
    static int[][] rotateSticker(int[][] sticker) {
        int n = sticker.length;
        int m = sticker[0].length;
        int[][] rotatedSticker = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                rotatedSticker[i][j] = sticker[n-j-1][i];
            }
        }
        return rotatedSticker;
    }
    
    /*
    ** 스티커가 붙은 칸의 수를 찾는 함수
    */
    static int findStickers() {
        int count = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(notebook[i][j] == 1) count++;
            }
        }
        return count;
    }
}
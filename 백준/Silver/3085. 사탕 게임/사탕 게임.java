import java.util.*;
import java.io.*;

public class Main {
	public static char[][] board;
	public static int N;
	public static int max = 0;	
    
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new char[N][N];

		for(int i=0; i<N; i++) {
			String str = br.readLine();
            board[i] = str.toCharArray();
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N-1; j++) {
				char temp = board[i][j];
				board[i][j] = board[i][j+1];
				board[i][j+1] = temp;

				check();

				temp = board[i][j];
				board[i][j] = board[i][j+1];
				board[i][j+1] = temp;
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N-1; j++) {
				char temp = board[j][i];
				board[j][i] = board[j+1][i];
				board[j+1][i] = temp;
				
				check();

				temp = board[j][i];
				board[j][i] = board[j+1][i];
				board[j+1][i] = temp;
			}
		}
		
		System.out.println(max);
		br.close();
	}
	
	public static void check() {
		for(int i=0; i<N; i++) {
			int count = 1;
			for(int j=0; j<N-1; j++) {
				if(board[i][j] == board[i][j+1]) count++;
				else count = 1;
				
				max = Math.max(max, count);
			}
		}
		
		for(int i=0; i<N; i++) {
			int count = 1;
			for(int j=0; j<N-1; j++) {
				if(board[j][i] == board[j+1][i]) count++;
				else count = 1;
                
				max = Math.max(max, count);
			}
		}
	}
}
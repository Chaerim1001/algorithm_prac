import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i=0; i<n; i++) {
            int[] board = new int[n];
            Arrays.fill(board, -1);
            
            board[0] = i;
            answer += checkQueen(board, 1, n);
        }
        
        return answer;
    }
    
    public int checkQueen(int[] board, int row, int n) {
        if(row==n) return 1;
        
        int count = 0;
        for(int col=0; col<n; col++) {
            boolean check = true;
            for(int i=0; i<row; i++) {
                if(col == board[i] || row-i == Math.abs(col-board[i])) {
                    check = false;
                    break;
                }
            }
            if(check) {
                board[row] = col;
                count += checkQueen(board, row+1, n);
            }
        }
        return count;
    }
}
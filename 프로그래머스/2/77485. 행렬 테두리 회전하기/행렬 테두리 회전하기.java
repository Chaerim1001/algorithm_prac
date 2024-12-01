import java.util.*;

class Solution {
    static int[][] board;
    static List<Integer> minValueList = new ArrayList<>();
    
    public int[] solution(int rows, int columns, int[][] queries) {
        board = new int[rows+1][columns+1];
        int number = 1;
        for(int i=1; i<rows+1; i++) {
            for(int j=1; j<columns+1; j++) {
                board[i][j] = number++;
            }
        }
        
        for(int i=0; i<queries.length; i++) {
            move(new Point(queries[i][0], queries[i][1]), new Point(queries[i][2],queries[i][3]));
        }
        
        int[] answer = new int[minValueList.size()];
        for(int i=0; i<minValueList.size(); i++) {
            answer[i] = minValueList.get(i);
        }     
        return answer;
    }
    
    static void move(Point start, Point end) {
        PriorityQueue<Integer> movePoints = new PriorityQueue<>();
        
        int now = board[start.r][start.c];
        int next;
        
        // 위
        for(int i=start.c; i<end.c; i++) {
            movePoints.add(now);
            next = board[start.r][i+1];
            board[start.r][i+1] = now;
            now = next;
        }
        
        // 오른쪽
        for(int i=start.r; i<end.r; i++) {
            movePoints.add(now);
            next = board[i+1][end.c];
            board[i+1][end.c] = now;
            now = next;
        }
        // 아래
        for(int i=end.c; i>start.c; i--) {
            movePoints.add(now);
            next = board[end.r][i-1];
            board[end.r][i-1] = now;
            now = next;
        }
        
        // 왼쪽 
        for(int i=end.r; i>start.r; i--) {
            movePoints.add(now);
            next = board[i-1][start.c];
            board[i-1][start.c] = now;
            now = next;
        }
        
        // 이동한 값 중 최솟값 넣기
        minValueList.add(movePoints.remove());
    }
    
    static class Point {
        int r;
        int c;
        
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
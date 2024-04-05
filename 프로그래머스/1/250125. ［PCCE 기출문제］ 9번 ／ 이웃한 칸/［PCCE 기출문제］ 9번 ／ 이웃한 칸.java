class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(String[][] board, int h, int w) {
        int H = board.length;
        int W = board[0].length;
        String target = board[h][w];
        
        int count = 0;
        int nx, ny;
        for(int i=0; i<4; i++) {
            nx = h + dx[i];
            ny = w + dy[i];
            
            if(nx<0 || ny<0 || nx>=H || ny>=W) continue;
            if(board[nx][ny].equals(target)) count++;
        }
        
        return count;
    }
}
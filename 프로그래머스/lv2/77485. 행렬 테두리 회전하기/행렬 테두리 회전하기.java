import java.util.*;

class Solution {
    static int[][] map;
    static int[] answer;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        map = new int[rows+1][columns+1];
        answer = new int[queries.length];
        
        int num = 1;
        for(int x=1; x<rows+1; x++) {
            for(int y=1; y<columns+1; y++) {
                map[x][y] = num++;
            }
        }
        
        for(int i=0; i<queries.length; i++) {
            int min = rotateNumber(queries[i][0],queries[i][1],queries[i][2],queries[i][3]);
            answer[i] = min;
        }
        
        return answer;
    }
    
    static int rotateNumber(int x1, int y1, int x2, int y2) {
        List<Integer> move_nums = new ArrayList<>();
        // 오른쪽으로 이동
        int move = map[x1][y1];
        for(int y=y1; y<y2; y++) {
            int next_move = map[x1][y+1];
            map[x1][y+1] = move;
            move_nums.add(move);
            move = next_move;
        }
        // 아래로 이동
        for(int x=x1; x<x2; x++) {
            int next_move = map[x+1][y2];
            map[x+1][y2] = move;
            move_nums.add(move);
            move = next_move;
        }
        // 왼쪽으로 이동
        for(int y=y2; y>y1; y--) {
            int next_move = map[x2][y-1];
            map[x2][y-1] = move;
            move_nums.add(move);
            move = next_move;
        }
        // 위로 이동
        for(int x=x2; x>x1; x--) {
            int next_move = map[x-1][y1];
            map[x-1][y1] = move;
            move_nums.add(move);
            move = next_move;
        }
        
        Collections.sort(move_nums);
        return move_nums.get(0);
    }
}
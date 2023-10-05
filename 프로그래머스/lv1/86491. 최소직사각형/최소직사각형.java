import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        
        for(int[] size: sizes) {
            if(size[0] >= size[1]) {
                first.add(size[0]);
                second.add(size[1]);
      
            } else {
                first.add(size[1]);
                second.add(size[0]);
            }
        }

        Collections.sort(first, Collections.reverseOrder());
        Collections.sort(second, Collections.reverseOrder());
        return first.get(0) * second.get(0);
    }
}
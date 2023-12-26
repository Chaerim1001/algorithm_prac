import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

class Solution {
    static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
    static int[] dy = { 1, 1, 0, -1, -1, -1, 0, 1 };
    
    public static int solution(int[] arrows) {
        int cnt = 0;
        Pair pointHC = new Pair(0, 0);

        HashMap<Pair, ArrayList<Pair>> visitied = new HashMap<>();

        for (int arrow : arrows) {
            for (int i = 0; i <= 1; i++) { 
                Pair newPointHC = new Pair(pointHC.x + dx[arrow], pointHC.y + dy[arrow]);

                if (!visitied.containsKey(newPointHC)) {
                    visitied.put(newPointHC, makeEdgeList(pointHC));

                    if(visitied.get(pointHC) == null) visitied.put(pointHC, makeEdgeList(newPointHC));
                    else visitied.get(pointHC).add(newPointHC);
                } else if (visitied.containsKey(newPointHC) && !(visitied.get(newPointHC).contains(pointHC))) {
                    visitied.get(newPointHC).add(pointHC);
                    visitied.get(pointHC).add(newPointHC);
                    cnt++;
                }
                pointHC = newPointHC;
            }
        }

        return cnt;
    }

    public static ArrayList<Pair> makeEdgeList(Pair pointHC) {
        ArrayList<Pair> edge = new ArrayList<>();
        edge.add(pointHC);
        return edge;
    }
    
    static class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int hashCode() {
            return Objects.hash(x,y);
        }

        public boolean equals(Object o) {
            return this.x == ((Pair) o).x && this.y == ((Pair) o).y;
        }
    }
}
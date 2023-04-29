import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Assignment> list = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.add(new Assignment(day, weight));
            max = Math.max(max, day);
        }

        int total = 0;
        for (int i=max; i>0; i--) {
            total += getMaxScore(list, i);
        }

        bw.write(total + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getMaxScore(List<Assignment> list, int now) {
        int idx = -1;
        int result = 0;
        
        for (int i = 0; i<list.size(); i++) {
            if (list.get(i).day >= now && result < list.get(i).weight) {
                idx = i;
                result = list.get(i).weight;
            }
        }

        if (result == 0) {
            return 0;
        }

        list.remove(idx);
        return result;
    }
    
    static class Assignment {
        int day;
        int weight;

        Assignment(int day, int weight) {
            this.day = day;
            this.weight = weight;
        }
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());

        if(minute-45<0) {
            if(hour == 0) {
                hour = 23;
            } else {
                hour -= 1;
            }
            minute = 60 - 45 + minute;
        } else {
            minute -= 45;
        }

        System.out.println(hour + " " + minute);
        br.close();
    }
}

import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> list = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            if(st.countTokens() == 1) {
                String str = st.nextToken();
                if(str.equals("pop_front")) pop_front();
                else if(str.equals("pop_back")) pop_back();
                else if(str.equals("size")) size();
                else if(str.equals("empty")) empty();
                else if(str.equals("front")) front();
                else back();
            } else {
                String str = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                if(str.equals("push_front")) push_front(n);
                else push_back(n);
            }
        }
        
        br.close();     
    }

    private static void push_back(int number) {
        list.add(list.size(), number);
    }

    private static void push_front(int number) {
        list.add(0, number);
    }

    private static void pop_front() {
        if(list.isEmpty()) System.out.println(-1);
        else {
            System.out.println(list.get(0));
            list.remove(0);
        }
    }

    private static void pop_back() {
        if(list.isEmpty()) System.out.println(-1);
        else {
            System.out.println(list.get(list.size()-1));
            list.remove(list.size()-1);
        }
    }
    
    private static void size() {
        System.out.println(list.size());
    }

    private static void empty() {
        if(list.isEmpty()) System.out.println(1);
        else System.out.println(0);
    }

    private static void front() {
        if(list.isEmpty()) System.out.println(-1);
        else System.out.println(list.get(0));
    }

    private static void back() {
        if(list.isEmpty()) System.out.println(-1);
        else System.out.println(list.get(list.size()-1));
    }
}

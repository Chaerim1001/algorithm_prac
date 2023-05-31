import java.util.*;
 
public class Main {    
    static ArrayList<Long> list;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt();
        list = new ArrayList<>();
        
        if(N <= 10) System.out.println(N);
        else if(N > 1022) System.out.println("-1");
        else {
            for(int i = 0; i < 10; i++) {
                bp(i, 1);
            }
            Collections.sort(list);
 
            System.out.println(list.get(N));
        }
    }    
    
    static void bp(long num, int idx) {
        if(idx > 10) return;
        
        list.add(num);
        for(int i = 0; i < num % 10; i++) {
            bp((num * 10) + i, idx + 1);
        }
    }
}
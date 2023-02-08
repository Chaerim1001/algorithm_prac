import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        
        int zeroCount = 0;
        int oneCount = 0;
        for(int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if(num > 1) pq1.add(num);
            else if (num < 0) pq2.add(num);
            else if (num == 1) oneCount++; 
            else zeroCount++;
        }
        
        int sum = 0;
        int num1 = 0;
        int num2 = 0;
        while(pq1.size() > 1) {
            num1 = pq1.remove();
            num2 = pq1.remove();
            sum += (num1 * num2);
        }
        if(!pq1.isEmpty()) sum += pq1.remove();
        
        while(pq2.size() > 1) {
            num1 = pq2.remove();
            num2 = pq2.remove();
            sum += (num1 * num2);
        }   
        if(!pq2.isEmpty()) {
            if(zeroCount == 0) sum += pq2.remove();
        }
        
        sum += oneCount;
        System.out.print(sum);     
    }
}
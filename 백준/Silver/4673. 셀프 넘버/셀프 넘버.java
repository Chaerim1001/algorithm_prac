public class Main {
    public static void main(String[] args) {
        boolean[] arr = new boolean[10001];
   
        for(int i=1; i<10001; i++) {
            int n = d_function(i);
            
            if(n<10001) arr[n] = true;
        }
        
        for(int i=1; i<10001; i++) {
            if(!arr[i]) System.out.println(i);
        }   
    }
    
    static int d_function(int n) {
        int sum = n; 
        while(n!=0) {
            sum += (n%10);
            n = n/10;
        }
        
        return sum;
    }
}
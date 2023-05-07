import java.util.*;
import java.io.*;

class Main {
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String s = br.readLine().trim();
        
	    Stack<Integer> len = new Stack<>();
	    Stack<Integer> mul = new Stack<>();
	    
	    int count=0;
	    for(int i=0; i<s.length(); i++){
	        char c = s.charAt(i);
	        if(c == '(') {
	            count -= 1;
	            int num = s.charAt(i-1) - '0';
	            len.add(count);
	            mul.add(num);
	            count = 0;
	        } else if(c == ')') {
	            int val = mul.peek();
	            mul.pop();
	            val *= count;
	            int plus = len.peek();
	            len.pop();
	            count = plus + val;
	        } else  count++;
	    }
        
		System.out.print(count);
        br.close();
	}
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String target = br.readLine();  

        Stack<Character> st = new Stack<>();
        for(int i=0; i<str.length(); i++) {
			st.push(str.charAt(i));
			
			if(st.size()>= target.length()) {
				boolean flag = true;
				
				for(int j=0; j<target.length(); j++) {
					if(st.get(st.size()-target.length()+j) != target.charAt(j)) {
						flag = false;
						break;
					}
				}
				if(flag) {
					for(int j=0; j<target.length(); j++) {
						st.pop();
					}
				}
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		for(Character c : st) {
			sb.append(c);
		}
		System.out.println(sb.length()==0? "FRULA" : sb.toString());
        br.close();
    }
}
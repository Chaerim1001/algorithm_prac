import java.util.*;

class Solution {
    static List<Integer> result = new ArrayList<>();
    static boolean[] check;
    
    public int solution(String numbers) {
        int count = 0;
        check = new boolean[numbers.length()];
        char[] numberArr = numbers.toCharArray();
        for(int i=0; i<numbers.length(); i++) {
            dfs(numberArr, "", i+1);
        }
        
        for(int i: result) {
            if(isPrime(i)) count++;
        }
        
        return count;
    }
        
    static boolean isPrime(int num) {
        if(num<2) return false;
        
        for(int i=2; i*i<=num; i++) {
            if(num % i == 0) return false;
        }
        
        return true;
    }
    
    static void dfs(char[] arr, String output, int depth) {
        if(output.length() == depth) {
            int temp = Integer.parseInt(output);
            if(!result.contains(temp)) result.add(temp);
        }
        
        for(int i=0; i<arr.length; i++) {
            if(!check[i]) {
                check[i] = true;
                output += arr[i];
                dfs(arr,  output, depth);
                check[i] = false;
                output = output.substring(0, output.length()-1);
            }
        }
    }
}
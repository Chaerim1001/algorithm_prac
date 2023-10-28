import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        List<Integer> listA = divisors(Arrays.stream(arrayA).distinct().toArray());
        List<Integer> listB = divisors(Arrays.stream(arrayB).distinct().toArray());

        for(int i=listA.size()-1;i>=0;i--) {
            int a = listA.get(i);
            
            Boolean check = true;
            for(int b : arrayB) {
                if(b%a==0) {
                    check = false;
                    break;
                }
            }
            if(check) {
                answer = a;
                break;
            }
        }
        
        for(int j=listB.size()-1;j>=0;j--) {
            int b = listB.get(j);
            
            Boolean check = true;
            for(int a : arrayA) {
                if(a%b==0) {
                    check = false;
                    break;
                }
            }
        
            if(answer<b && check) {
                answer = b;
                break;
            }   
        }
        return answer;
    }

    public List<Integer> divisors(int[] array) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(array);
        int min = array[0];

        for(int i=2;i<=min;i++) {
            Boolean check = true;
            for(int num : array) {
                if(num%i!=0) {
                    check=false;
                    break;
                }
            }
            if(check) list.add(i);
        }

        return list;
    }
}
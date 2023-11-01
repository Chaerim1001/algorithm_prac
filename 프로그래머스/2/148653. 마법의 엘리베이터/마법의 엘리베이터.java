class Solution {
    public int solution(int storey) {
        char[] charArr = (storey + "").toCharArray();
        int[] intArr = new int[charArr.length];
        int answer = 0;
        
        for(int i=0; i<charArr.length; i++) {
            intArr[i] = Character.getNumericValue(charArr[i]);
        }
        
        for(int i=charArr.length-1; i>=0; i--) {
            int plus = 0;
            if(intArr[i]>5) {
                if(i==0) plus = 10-intArr[i]+1;
                else {
                    intArr[i-1] += 1;
                    plus = 10-intArr[i];
                }
            } else if(intArr[i]==5 && i!=0) {
                if(intArr[i-1]+1>5) intArr[i-1] += 1;
                plus = 5;
            } else {
                plus = intArr[i]; 
            }
            answer += plus;
        }
        
        return answer;
    }
}
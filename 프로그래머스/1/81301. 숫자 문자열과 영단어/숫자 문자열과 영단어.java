class Solution {
    public int solution(String s) {
        String answer = s;
        String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i=0; i<10; i++) {
            answer = answer.replace(arr[i], ""+i);
        }
        return Integer.parseInt(answer);
    }
}
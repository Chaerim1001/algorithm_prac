class Solution {
    public long solution(int w, int h) {
        int num = gcd(w, h);
        return ((long) w * h) - (((w / num) + (h / num) - 1) * num);
    }
    
    private int gcd(int n, int m) {
        while (m != 0) {
            int r = n % m;
            n = m;
            m = r;
        }
        return n;
    }
}

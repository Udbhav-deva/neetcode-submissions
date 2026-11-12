class Solution {
    public double myPow(double x, int n) {
        long binPow = n;
        if (binPow < 0) {
            x = 1 / x;
            binPow = -binPow;
        }
        return helper(x, binPow);
    }

    private double helper(double x, long n) {
        if (n == 0) return 1.0;
        double half = helper(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}

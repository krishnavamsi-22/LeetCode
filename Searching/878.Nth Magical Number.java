class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        long n1 = a;
        long n2 = b;
        long n3 = n;

        long lcm = lcm(n1, n2);
        long mod = (long) 1e9 + 7;

        long low = Math.min(n1, n2);
        long high = Math.max(n1, n2) * n;

        while (low < high) {
            long mid = low + (high - low) / 2;
            if (mid / n1 + mid / n2 - mid / lcm < n) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return (int) (low % mod);
    }

    long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

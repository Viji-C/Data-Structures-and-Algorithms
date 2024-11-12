/* A digit string is good if the digits (0-indexed) at even indices are even and the digits at odd indices are prime (2, 3, 5, or 7).

For example, "2582" is good because the digits (2 and 8) at even positions are even and the digits (5 and 2) at odd positions are prime. However, "3245" is not good because 3 is at an even index but is not even.
Given an integer n, return the total number of good digit strings of length n. Since the answer may be large, return it modulo 109 + 7.

A digit string is a string consisting of digits 0 through 9 that may contain leading zeros.

Example 1:

Input: n = 1
Output: 5
Explanation: The good numbers of length 1 are "0", "2", "4", "6", "8".
Example 2:

Input: n = 4
Output: 400
Example 3:

Input: n = 50
Output: 564908303 */

// Brutforce Approach 
class Solution {
    public int countGoodNumbers(long n) {
        int count = 0;
        for (long j = 0; j < Math.pow(10, n); j++) {
            if (isGoodNumber(j)) {
                count++;
            }
        }
        return count;
    }

    private boolean isGoodNumber(long n) {
        int numlen = (n == 0) ? 1 : (int) Math.log10(n) + 1;
        int[] ch = new int[numlen];
        for (int i = numlen - 1; i >= 0; i--) {
            ch[i] = (int) (n % 10);
            n /= 10;
        }

        for (int i = 0; i < numlen; i++) {
            if (i % 2 == 0) {
                if (ch[i] % 2 != 0) return false;
            } 
            else {
                if (!isPrime(ch[i])) return false;
            }
        }

        return true;
    }

    private boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2) 
        {
            if (num % i == 0) return false;
        }
        return true;
    }
}

// Optimal Sollution TC - (logN), SC - O(1)
class Solution {
    public static final long MOD = 1000000007;

    public int countGoodNumbers(long n) {
        long evenCount = (n + 1) / 2;
        long oddCount = n / 2;
        
        long evenChoices = modExponentiation(5, evenCount, MOD);
        long oddChoices = modExponentiation(4, oddCount, MOD);
        
        return (int) (evenChoices * oddChoices % MOD);
    }

    private long modExponentiation(long base, long exp, long mod) {
        long result = 1;
        base = base % mod;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp = exp / 2;
        }
        return result;
    }
}
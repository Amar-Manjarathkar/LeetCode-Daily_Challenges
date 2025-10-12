
import java.util.*;

class Solution {
    final long MOD = 1_000_000_007L;

    public int magicalSum(int m, int k, int[] nums) {
        int n = nums.length;

        // Edge quick checks
        if (m == 0) {
            // Only empty sequence (sum = 0 has popcount 0) and product is 1 by convention
            return (k == 0) ? 1 : 0;
        }

        // Precompute binomial coefficients C[a][b] for 0..m
        long[][] C = new long[m + 1][m + 1];
        for (int i = 0; i <= m; ++i) {
            C[i][0] = 1;
            for (int j = 1; j <= i; ++j) {
                C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]) % MOD;
            }
        }

        // Precompute powNum[j][t] = (nums[j]^t) % MOD for t=0..m
        long[][] powNum = new long[n][m + 1];
        for (int j = 0; j < n; ++j) {
            powNum[j][0] = 1;
            long base = ((nums[j] % MOD) + MOD) % MOD;
            for (int t = 1; t <= m; ++t) {
                powNum[j][t] = (powNum[j][t - 1] * base) % MOD;
            }
        }

        // DP state encoding: key = (rem << 40) | (carry << 20) | bits
        // rem and carry and bits are assumed <= 2^20 (~1,048,576). This is safe for usual constraints.
        // Map<stateKey, value>
        Map<Long, Long> cur = new HashMap<>();
        // initial: before processing any index, remaining picks = m, carry = 0, bitsSoFar = 0, value = 1
        long startKey = encode(m, 0, 0);
        cur.put(startKey, 1L);

        for (int pos = 0; pos < n; ++pos) {
            Map<Long, Long> next = new HashMap<>();

            for (Map.Entry<Long, Long> entry : cur.entrySet()) {
                long key = entry.getKey();
                long val = entry.getValue();
                int rem = (int) ((key >>> 40) & ((1L << 20) - 1));
                int carry = (int) ((key >>> 20) & ((1L << 20) - 1));
                int bitsSoFar = (int) (key & ((1L << 20) - 1));

                if (rem < 0) continue;

                // choose c occurrences of current index pos, c in [0..rem]
                for (int c = 0; c <= rem; ++c) {
                    // ways to choose which of the 'rem' positions are assigned to pos: C[rem][c]
                    long waysChoose = C[rem][c];

                    // contribution from product values: nums[pos]^c
                    long prodPow = powNum[pos][c];

                    // update rem
                    int rem2 = rem - c;

                    // compute bit and carry at this position
                    int sumAtPos = c + carry;
                    int bit = sumAtPos & 1;
                    int carryOut = sumAtPos >>> 1;

                    int bitsNew = bitsSoFar + bit;
                    if (bitsNew > k) {
                        // prune: we already exceeded required bits
                        continue;
                    }

                    long addVal = val;
                    addVal = (addVal * waysChoose) % MOD;
                    addVal = (addVal * prodPow) % MOD;

                    long newKey = encode(rem2, carryOut, bitsNew);
                    next.merge(newKey, addVal, (a, b) -> (a + b) % MOD);
                }
            }

            // move to next position
            cur = next;
        }

        // After processing n positions, there may be non-zero carry (bits beyond n).
        long ans = 0;
        for (Map.Entry<Long, Long> entry : cur.entrySet()) {
            long key = entry.getKey();
            long val = entry.getValue();
            int rem = (int) ((key >>> 40) & ((1L << 20) - 1));
            int carry = (int) ((key >>> 20) & ((1L << 20) - 1));
            int bitsSoFar = (int) (key & ((1L << 20) - 1));

            if (rem != 0) continue; // all picks must be used

            // consume carry: adding its binary set bits to bitsSoFar
            int extraBits = Integer.bitCount(carry);
            int totalBits = bitsSoFar + extraBits;

            if (totalBits == k) {
                ans = (ans + val) % MOD;
            }
        }

        return (int) ans;
    }

    // pack rem, carry, bits into a single long
    private long encode(int rem, int carry, int bits) {
        return (((long) rem) << 40) | (((long) carry) << 20) | (long) bits;
    }

    // For quick local testing (uncomment to run)
    /*
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 2, 3};
        // example: m = 2, choose pairs of indices from {0,1,2}, check binary sum popcount = k
        System.out.println(s.magicalSum(2, 1, nums)); // just to test
    }
    */
}

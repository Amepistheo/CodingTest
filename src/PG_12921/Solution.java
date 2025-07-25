// 12921번 소수 찾기
package PG_12921;

import java.util.*;

class Solution {
    public int solution(int n) {
        int count = 0;

        boolean[] isPrime = new boolean[n + 1];

        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i <= n; i++) {
            if(isPrime[i]) {
                count++;
            }

            for (int j = i * 2; j <= n; j += i) {
                isPrime[j] = false;
            }
        }

        return count;
    }
}
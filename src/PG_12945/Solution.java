// 12945번 피보나치 수
package PG_12945;

class Solution {
    public int solution(int n) {
        int[] arr = new int[n + 1];

        arr[0] = 0;
        arr[1] = 1;

        int i = 2;

        while (i <= n) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1234567;
            i++;
        }

        return arr[n];
    }
}
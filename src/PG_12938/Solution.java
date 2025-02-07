// 12938번 최고의 집합
package PG_12938;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];

        int num = s / n;
        int rest = s % n;

        if (num == 0) {
            return new int[]{-1};
        }

        for (int i = 0; i < n; i++) {
            answer[i] = num;
        }

        int point = n - 1;

        while (rest != 0) {
            answer[point]++;
            point--;
            rest--;
        }

        return answer;
    }
}
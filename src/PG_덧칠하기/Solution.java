// 연습문제 덧칠하기
package PG_덧칠하기;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int check = 0;

        for (int i = 0; i < section.length; i++) {
            if (section[i] <= check) {
                continue;
            }

            check = section[i] + (m-1);
            answer++;
        }

        return answer;
    }
}
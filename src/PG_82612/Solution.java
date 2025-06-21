// 82612번 부족한 금액 계산하기
package PG_82612;

class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;

        for (int i = 1; i <= count; i++) {
            answer += (price * i);
        }

        return answer - money > 0 ? answer - money : 0;
    }
}
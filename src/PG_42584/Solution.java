// 42584번 주식가격
package PG_42584;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                answer[i]++;

                if (prices[j] < prices[i]) {
                    break;
                }
            }
        }

        return answer;
    }
}
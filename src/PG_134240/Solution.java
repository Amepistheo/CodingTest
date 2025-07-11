// 134240번 푸드 파이트 대회
package PG_134240;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < food.length; i++) {
            for (int j = 0; j < food[i] / 2; j++) {
                sb.append(i);
            }
        }

        answer += (sb + "0");
        answer += sb.reverse();

        return answer;
    }
}
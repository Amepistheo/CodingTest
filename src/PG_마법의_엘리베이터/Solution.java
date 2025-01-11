// 연습문제 - 마법의 엘리베이터
package PG_마법의_엘리베이터;

class Solution {
    public int solution(int storey) {
        int answer = 0;

        String[] num = String.valueOf(storey).split("");

        for (int i = num.length - 1; i > 0; i--) {
            int current = Integer.parseInt(num[i]);
            int next = Integer.parseInt(num[i - 1]);

            if (current > 5) {
                answer += (10 - current);
                num[i - 1] = String.valueOf(next + 1);
            } else if (current < 5) {
                answer += current;
            } else {
                if (next >= 5) {
                    answer += (10 - current);
                    num[i - 1] = String.valueOf(next + 1);
                } else {
                    answer += current;
                }
            }
        }

        int last = Integer.parseInt(num[0]);

        if (last > 5) {
            answer += (10 - last) + 1;
        } else {
            answer += last;
        }

        return answer;
    }
}
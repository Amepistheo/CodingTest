// 118667번 두 큐 합 같게 만들기
package PG_118667;

import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        int answer = 0;

        long sum = 0;
        long total = 0;

        for (int i = 0; i < queue1.length; i++) {
            sum += queue1[i];
            total += queue1[i] + queue2[i];

            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }

        if ((total % 2) != 0) {
            return -1;
        }

        long target = (total / 2);

        while (true) {
            if (answer > (queue1.length + queue2.length) * 2) {
                return -1;
            }

            if (sum == target) {
                break;
            } else if (sum > target) {
                sum -= q1.peek();
                q2.offer(q1.poll());
            } else {
                sum += q2.peek();
                q1.offer(q2.poll());
            }

            answer++;
        }

        return answer;
    }
}
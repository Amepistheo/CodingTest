// 12927번 야근 지수
package PG_12927;

import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;

        Queue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int total = 0;

        for (int w : works) {
            q.offer(w);
            total += w;
        }

        if (n > total) {
            return 0;
        }

        while (n > 0) {
            q.offer(q.poll() - 1);
            n--;
        }

        while (!q.isEmpty()) {
            answer += Math.pow(q.poll(), 2);
        }

        return answer;
    }
}
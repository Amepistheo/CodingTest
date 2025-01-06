// 연습문제 - 숫자 변환하기
package PG_숫자_변환하기;

import java.io.*;
import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;

        Queue<Integer> q = new LinkedList<>();
        int[] count = new int[y + 1];
        boolean[] isVisit = new boolean[y + 1];

        Arrays.fill(count, Integer.MAX_VALUE);

        q.offer(y);
        count[y] = 0;

        while (!q.isEmpty()) {
            int poll = q.poll();

            if ((poll - n) == x) {
                count[x] = Math.min(count[x], count[poll] + 1);
            } else if ((poll - n) > x && !isVisit[poll - n]) {
                count[poll - n] = Math.min(count[poll - n], count[poll] + 1);
                isVisit[poll - n] = true;
                q.offer(poll - n);
            }

            if ((poll / 2) == x && (poll % 2) == 0) {
                count[x] = Math.min(count[x], count[poll] + 1);
            } else if ((poll / 2) > x && (poll % 2) == 0 && !isVisit[poll / 2]) {
                count[poll / 2] = Math.min(count[poll / 2], count[poll] + 1);
                isVisit[poll / 2] = true;
                q.offer(poll / 2);
            }

            if ((poll / 3) == x && (poll % 3) == 0) {
                count[x] = Math.min(count[x], count[poll] + 1);
            } else if ((poll / 3) > x && (poll % 3) == 0 && !isVisit[poll / 3]) {
                count[poll / 3] = Math.min(count[poll / 3], count[poll] + 1);
                isVisit[poll / 3] = true;
                q.offer(poll / 3);
            }
        }

        if (count[x] == Integer.MAX_VALUE) {
            answer = -1;
        } else {
            answer = count[x];
        }

        return answer;
    }
}
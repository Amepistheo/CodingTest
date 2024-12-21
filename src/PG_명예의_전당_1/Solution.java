// 연습문제 명예의 전당 (1)
package PG_명예의_전당_1;

import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        PriorityQueue<Integer> award = new PriorityQueue<>();

        for (int i = 0; i < score.length; i++) {
            if (i < k) {
                award.offer(score[i]);
            } else {
                if (award.peek() < score[i]) {
                    award.poll();
                    award.offer(score[i]);
                }
            }

            answer[i] = award.peek();
        }

        return answer;
    }
}
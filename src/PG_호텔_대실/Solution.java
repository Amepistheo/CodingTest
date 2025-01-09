// 연습문제 - 호텔 대실
package PG_호텔_대실;

import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        Queue<Integer> q = new PriorityQueue<>();
        int[][] room = new int[book_time.length][2];

        for (int i = 0; i < book_time.length; i++) {
            String[] start = book_time[i][0].split(":");
            room[i][0] = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);

            String[] end = book_time[i][1].split(":");
            room[i][1] = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]) + 10;
        }

        Arrays.sort(room, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }

            return o1[0] - o2[0];
        });

        q.offer(room[0][1]);

        for (int i = 1; i < book_time.length; i++) {
            if (q.peek() <= room[i][0]) {
                q.poll();
            }

            q.offer(room[i][1]);
        }

        return q.size();
    }
}
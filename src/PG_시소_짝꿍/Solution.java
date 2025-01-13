// 연습문제 - 시소 짝꿍
package PG_시소_짝꿍;

import java.io.*;
import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        int count = 0;

        Arrays.sort(weights);

        for (int i = 0; i < weights.length - 1; i++) {
            if (0 < i) {
                if (weights[i] == weights[i - 1]) {
                    count--;
                    answer += count;
                    continue;
                }
            }

            count = 0;

            for (int j = i + 1; j < weights.length; j++) {
                if (weights[i] == weights[j]) {
                    count++;
                    continue;
                }

                if (weights[i] * 2 == weights[j]) {
                    count++;
                    continue;
                }

                if (weights[i] * 3 == weights[j] * 2) {
                    count++;
                    continue;
                }

                if (weights[i] * 4 == weights[j] * 3) {
                    count++;
                    continue;
                }
            }

            answer += count;
        }

        return answer;
    }
}
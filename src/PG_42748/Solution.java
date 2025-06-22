// 42748번 K번째수
package PG_42748;

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        int idx = 0;

        for (int[] arr : commands) {
            int[] tmp = new int[arr[1] - arr[0] + 1];

            int index = 0;

            for (int i = arr[0] - 1; i < arr[1]; i++) {
                tmp[index] = array[i];
                index++;
            }

            Arrays.sort(tmp);

            answer[idx] = tmp[arr[2] - 1];
            idx++;
        }

        return answer;
    }
}
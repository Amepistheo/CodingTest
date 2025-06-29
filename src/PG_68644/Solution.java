// 68644번 두 개 뽑아서 더하기
package PG_68644;

import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        int[] answer = new int[set.size()];
        Iterator<Integer> iter = set.iterator();

        for (int i = 0; i < set.size(); i++) {
            answer[i] = iter.next();
        }

        Arrays.sort(answer);

        return answer;
    }
}
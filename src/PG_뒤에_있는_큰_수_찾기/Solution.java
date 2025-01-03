// 연습문제 - 뒤에 있는 큰 수 찾기
package PG_뒤에_있는_큰_수_찾기;

import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);

        Stack<Integer> s = new Stack<>();

        for (int i = numbers.length-1; i >= 0; i--) {
            while (!s.empty() && numbers[i] >= s.peek()) {
                s.pop();
            }

            if (!s.empty()) {
                answer[i] = s.peek();
            }

            s.push(numbers[i]);
        }

        return answer;
    }
}
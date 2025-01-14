// 탐욕법(Greedy) - 구명보트
package PG_구명보트;

import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
                answer++;
            } else {
                right--;
                answer++;
            }
        }

        return answer;
    }
}
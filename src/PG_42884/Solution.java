// 42884번 단속카메라
package PG_42884;

import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (int[] o1, int[] o2) -> o1[1] - o2[1]);
        
        int answer = 0;
        int camera = Integer.MIN_VALUE;
        
        for (int[] time : routes) {
            if (time[0] <= camera && camera <= time[1]) {
                continue;
            }
            
            camera = time[1];
            answer++;
        }
        
        return answer;
    }
}
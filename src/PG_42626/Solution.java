// 42626번 더 맵게
package PG_42626;

import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        Queue<Long> q = new PriorityQueue<>();
        
        for (long num : scoville) {            
            q.offer(num);
        }
        
        while (q.size() > 1 && q.peek() < K) {
            long mix = q.poll() + (q.poll() * 2);
            q.offer(mix);
            answer++;
        }
        
        if (q.size() <= 1 && q.peek() < K) {
            answer = -1;
        }
    
        return answer;
    }
}
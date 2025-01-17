// 17680번 [1차] 캐시
package PG_17680;

import java.io.*;
import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        Queue<String> q = new LinkedList<>();
        int answer = 0;
        
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        for (String s : cities) {
            String city = s.toLowerCase();
            
            if (q.contains(city)) {
                int size = q.size();
                
                for (int i = 0; i < size; i++) {
                    String poll = q.poll();
                    
                    if (poll.equals(city)) {
                        continue;
                    }
                    
                    q.offer(poll);
                }
                
                q.offer(city);
                answer += 1;
            } else {
                if (q.size() >= cacheSize) {
                    q.poll();
                }
                
                q.offer(city);
                answer += 5;
            }
        }
        
        return answer;
    }
}
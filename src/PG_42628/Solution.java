// 42628번 이중우선순위큐
package PG_42628;

import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        Queue<Integer> minPQ = new PriorityQueue<>();
        Queue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String s : operations) {
            String[] arr = s.split(" ");
            
            switch (arr[0]) {
                case "I" :
                    int num = Integer.parseInt(arr[1]);
                    
                    minPQ.offer(num);
                    maxPQ.offer(num);
                    break;
                case "D" :
                    if (arr[1].equals("-1") && !minPQ.isEmpty()) {
                        maxPQ.remove(minPQ.poll());
                    } else if (arr[1].equals("1") && !maxPQ.isEmpty()) {
                        minPQ.remove(maxPQ.poll());
                    }
                    
                    break;
            }
        }
        
        if (!minPQ.isEmpty() && !maxPQ.isEmpty()) {
            answer[0] = maxPQ.poll();
            answer[1] = minPQ.poll();
        }
        
        return answer;
    }
}
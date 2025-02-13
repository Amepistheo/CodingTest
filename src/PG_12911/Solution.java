// 12911번 다음 큰 숫자
package PG_12911;

class Solution {
    public int solution(int n) {
        int answer = n + 1;
        
        int count = Integer.bitCount(n);
        
        while (true) {            
            if (count == Integer.bitCount(answer)) {
                break;
            }
            
            answer++;
        }
        
        return answer;
    }
}
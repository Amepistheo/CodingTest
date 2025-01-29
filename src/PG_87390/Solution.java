// 87390번 n^2 배열 자르기
package PG_87390;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];
        
        int index = 0;
        
        for (long i = left; i <= right; i++) {
            long row = i / n;
            long col = i % n;
            
            answer[index++] = (int) Math.max(row, col) + 1;
        }
        
        return answer;
    }
}
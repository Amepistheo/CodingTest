// 12932번 자연수 뒤집어 배열로 만들기
package PG_12932;

class Solution {
    public int[] solution(long n) {
        String s = String.valueOf(n);

        String[] str = s.split("");
        int[] answer = new int[str.length];

        for (int i = 0; i < str.length; i++) {
            answer[i] = Integer.parseInt(str[str.length - 1 - i]);
        }

        return answer;
    }
}
// 연습문제 가장 가까운 같은 글자
package PG_가장_가까운_같은_글자;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            answer[i] = -1;
        }

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);

            for (int j = i-1; j >= 0; j--) {
                if (c == s.charAt(j)) {
                    answer[i] = i-j;
                    break;
                }
            }
        }

        return answer;
    }
}
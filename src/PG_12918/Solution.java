// 12918번 문자열 다루기 기본
package PG_12918;

class Solution {
    public boolean solution(String s) {
        boolean answer = false;

        if (s.length() == 4 || s.length() == 6) {
            answer = true;
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < '0' || '9' < s.charAt(i)) {
                answer = false;
                break;
            }
        }

        return answer;
    }
}
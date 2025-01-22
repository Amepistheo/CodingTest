// 12951번 JadenCase 문자열 만들기
package PG_12951;

class Solution {
    public String solution(String s) {
        String answer = "";

        answer += String.valueOf(s.charAt(0)).toUpperCase();

        for (int i = 1; i < s.length(); i++) {
            String last = String.valueOf(s.charAt(i - 1));
            String now = String.valueOf(s.charAt(i));

            if (last.equals(" ")) {
                answer += now.toUpperCase();
            } else {
                answer += now.toLowerCase();
            }
        }

        return answer;
    }
}
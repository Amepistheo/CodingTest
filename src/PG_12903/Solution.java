// 12903번 가운데 글자 가져오기
package PG_12903;

class Solution {
    public String solution(String s) {
        String answer = "";

        if (s.length() % 2 == 0) {
            answer += s.charAt(s.length() / 2 - 1);
            answer += s.charAt(s.length() / 2);
        } else {
            answer += s.charAt(s.length() / 2);
        }

        return answer;
    }
}
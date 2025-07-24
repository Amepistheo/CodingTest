// 12930번 이상한 문자 만들기
package PG_12930;

class Solution {
    public String solution(String s) {
        String answer = "";

        char[] list = s.toCharArray();
        int index = 0;

        for (char c : list) {
            if (c == ' ') {
                answer += " ";
                index = 0;
                continue;
            }

            if ((index % 2) == 0) {
                answer += Character.toUpperCase(c);
            } else {
                answer += Character.toLowerCase(c);
            }

            index++;
        }

        return answer;
    }
}
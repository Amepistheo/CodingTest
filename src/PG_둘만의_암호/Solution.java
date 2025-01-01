// 연습문제 둘만의 암호
package PG_둘만의_암호;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            for (int j = 0; j < index; j++) {
                while (true) {
                    c = (c == 'z') ? 'a' : (char) (c + 1);

                    if (!skip.contains(String.valueOf(c))) {
                        break;
                    }
                }
            }

            answer += c;
        }

        return answer;
    }
}
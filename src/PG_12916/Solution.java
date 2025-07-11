// 12916번 문자열 내 p와 y의 개수
package PG_12916;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int countP = 0;
        int countY = 0;

        String str = s.toUpperCase();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'P') {
                countP++;
            } else if (str.charAt(i) == 'Y') {
                countY++;
            }
        }

        if (countP != countY) {
            answer = false;
        }

        return answer;
    }
}
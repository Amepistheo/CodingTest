// 12919번 서울에서 김서방 찾기
package PG_12919;

class Solution {
    public String solution(String[] seoul) {
        int index = 0;

        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                index = i;
                break;
            }
        }

        return "김서방은 " + index + "에 있다";
    }
}
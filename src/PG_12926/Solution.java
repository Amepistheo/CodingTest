// 12926번 시저 번호
package PG_12926;

class Solution {
    public String solution(String s, int n) {
        String answer = "";

        char[] str = s.toCharArray();

        for (char c : str) {
            if (c == ' ') {
                answer += " ";
            } else {
                char cc = (char)(c + n);

                if ('a' <= c && c <= 'z') {
                    if (cc > 'z')  {
                        cc -= 26;
                    }
                } else if ('A' <= c && c <= 'Z') {
                    if (cc > 'Z')  {
                        cc -= 26;
                    }
                }

                answer += cc;
            }
        }

        return answer;
    }
}
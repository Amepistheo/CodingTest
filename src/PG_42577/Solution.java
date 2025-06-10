// 42577번 전화번호 목록
package PG_42577;

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        String[] book = phone_book;

        Arrays.sort(book);

        for (int i = 0; i < book.length - 1; i++) {
            if (book[i + 1].startsWith(book[i])) {
                answer = false;
                break;
            }
        }

        return answer;
    }
}
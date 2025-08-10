// 178871번 달리기 경주
package PG_178871;

import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = players;

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (String name : callings) {
            int rank = map.get(name);
            String tmp = answer[rank - 1];

            answer[rank - 1] = answer[rank];
            answer[rank] = tmp;

            map.put(answer[rank - 1], rank - 1);
            map.put(answer[rank], rank);
        }

        return answer;
    }
}
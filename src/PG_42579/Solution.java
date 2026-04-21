// 42579번 베스트앨범
package PG_42579;

import java.util.*;

class Solution {

    private static Map<String, Integer> map = new HashMap<>();
    private static Map<String, Integer> answerMap = new HashMap<>();
    private static Queue<Music> q;
    private static Queue<Integer> answerQ = new LinkedList<>();

    public int[] solution(String[] genres, int[] plays) {
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
            answerMap.put(genres[i], 0);
        }

        q = new PriorityQueue<>((o1, o2) -> {
            if (o1.genreCnt == o2.genreCnt) {
                if (o1.play == o2.play) {
                    return o1.index - o2.index;
                }

                return o2.play - o1.play;
            }

            return o2.genreCnt - o1.genreCnt;
        });

        for (int i = 0; i < genres.length; i++) {
            q.offer(new Music(i, genres[i], map.get(genres[i]), plays[i]));
        }

        while (!q.isEmpty()) {
            Music m = q.poll();

            if (answerMap.get(m.genre) >= 2) {
                continue;
            }

            answerMap.put(m.genre, answerMap.get(m.genre) + 1);
            answerQ.offer(m.index);
        }

        int size = answerQ.size();
        int[] answer = new int[answerQ.size()];

        for (int i = 0; i < size; i++) {
            answer[i] = answerQ.poll();
        }

        return answer;
    }
}

class Music {
    int index;
    String genre;
    int genreCnt;
    int play;

    public Music(int index, String genre, int genreCnt, int play) {
        this.index = index;
        this.genre = genre;
        this.genreCnt = genreCnt;
        this.play = play;
    }
}
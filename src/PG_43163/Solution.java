// 43163번 단어 변환
package PG_43163;

import java.util.*;

class Solution {

    static String[] wordList;
    static String targetWord;

    public int solution(String begin, String target, String[] words) {
        Queue<String> resultQ = new LinkedList<>();
        Queue<Integer> positionQ = new LinkedList<>();

        wordList = new String[words.length];
        targetWord = target;

        int answer = Integer.MAX_VALUE;
        boolean isExist = false;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                isExist = true;
            }

            wordList[i] = words[i];

            if (isOneCharDifferent(begin, words[i])) {
                resultQ.offer(words[i]);
                positionQ.offer(i);
            }
        }

        if (!isExist) {
            return 0;
        }

        while (!resultQ.isEmpty()) {
            int num = bfs(resultQ.poll(), positionQ.poll());
            answer = Math.min(answer, num);
        }

        return answer;
    }

    private int bfs(String word, int position) {
        boolean[] isVisit = new boolean[wordList.length];

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(word, 1));
        isVisit[position] = true;

        int total = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Node node = q.poll();

            String nodeWord = node.word;
            int nodeCount = node.count;

            if (targetWord.equals(nodeWord)) {
                total = nodeCount;
                break;
            }

            for (int i = 0; i < wordList.length; i++) {
                if (isVisit[i]) {
                    continue;
                }

                if (isOneCharDifferent(nodeWord, wordList[i])) {
                    q.offer(new Node(wordList[i], nodeCount + 1));
                    isVisit[i] = true;
                }
            }
        }

        return total;
    }

    private boolean isOneCharDifferent(String word1, String word2) {
        int diffCount = 0;

        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCount++;
            }
        }

        return diffCount == 1;
    }
}

class Node {
    String word;
    int count;

    public Node(String word, int count) {
        this.word = word;
        this.count = count;
    }
}
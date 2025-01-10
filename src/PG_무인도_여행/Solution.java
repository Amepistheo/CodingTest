// 연습문제 - 무인도 여행
package PG_무인도_여행;

import java.io.*;
import java.util.*;

class Solution {
    static String[][] map;
    static boolean[][] isVisit;

    static int[] dR = {-1, 1, 0, 0};
    static int[] dC = {0, 0, -1, 1};

    static Queue<Integer> resultQ = new PriorityQueue<>();
    static int[] answer;

    public int[] solution(String[] maps) {
        map = new String[maps.length][maps[0].length()];
        isVisit = new boolean[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            map[i] = maps[i].split("");
        }

        search();

        if (resultQ.isEmpty()) {
            answer = new int[1];
            answer[0] = -1;
        } else {
            int size = resultQ.size();
            answer = new int[size];

            for (int i = 0; i < size; i++) {
                answer[i] = resultQ.poll();
            }
        }

        return answer;
    }

    static void search() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j].equals("X")) {
                    continue;
                }

                if (isVisit[i][j]) {
                    continue;
                }

                isVisit[i][j] = true;
                resultQ.offer(bfs(i, j));
            }
        }
    }

    static int bfs(int row, int col) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(row, col));

        int sum = Integer.parseInt(map[row][col]);

        while (!q.isEmpty()) {
            Node vertex = q.poll();

            for (int i = 0; i < 4; i++) {
                int dr = vertex.row + dR[i];
                int dc = vertex.col + dC[i];

                if (dr < 0 || dr >= map.length || dc < 0 || dc >= map[0].length) {
                    continue;
                }

                if (map[dr][dc].equals("X")) {
                    continue;
                }

                if (isVisit[dr][dc]) {
                    continue;
                }

                q.offer(new Node(dr, dc));
                isVisit[dr][dc] = true;
                sum += Integer.parseInt(map[dr][dc]);
            }
        }

        return sum;
    }
}

class Node {
    int row;
    int col;

    public Node(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
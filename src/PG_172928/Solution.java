// 172928번 공원 산책
package PG_172928;

class Solution {

    private String[][] map;
    private int[] point = new int[2];

    public int[] solution(String[] park, String[] routes) {
        int H = park.length;
        int W = park[0].length();

        map = new String[H][W];

        for (int i = 0; i < H; i++) {
            map[i] = park[i].split("");

            for (int j = 0; j < W; j++) {
                if (map[i][j].equals("S")) {
                    point[0] = i;
                    point[1] = j;
                }
            }
        }

        for (String route : routes) {
            String[] cmd = route.split(" ");

            String dir = cmd[0];
            int dist = Integer.parseInt(cmd[1]);

            int[] tmp = new int[] { point[0], point[1] };
            boolean invalid = false;

            for (int i = 0; i < dist; i++) {
                int nr = tmp[0];
                int nc = tmp[1];

                switch (dir) {
                    case "N": nr--; break;
                    case "S": nr++; break;
                    case "W": nc--; break;
                    case "E": nc++; break;
                }

                if (nr < 0 || nr >= H || nc < 0 || nc >= W) {
                    invalid = true;
                    break;
                }

                if (map[nr][nc].equals("X")) {
                    invalid = true;
                    break;
                }

                tmp[0] = nr;
                tmp[1] = nc;
            }

            if (!invalid) {
                point = tmp;
            }
        }

        return point;
    }
}
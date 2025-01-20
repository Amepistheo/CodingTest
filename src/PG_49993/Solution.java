// 49993번 스킬트리
package PG_49993;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        String[] order = skill.split("");

        for (String s : skill_trees) {
            boolean isPossible = true;
            String str = "";

            for (int i = 0; i < s.length(); i++) {
                String sc = String.valueOf(s.charAt(i));

                if (!skill.contains(sc)) {
                    continue;
                }

                for (String c : order) {
                    if (sc.equals(c)) {
                        str += c;
                    }
                }
            }

            for (int i = 0; i < str.length(); i++) {
                if (!order[i].equals(String.valueOf(str.charAt(i)))) {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                answer++;
            }
        }

        return answer;
    }
}
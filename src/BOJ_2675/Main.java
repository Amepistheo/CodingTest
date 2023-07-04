// 2675번 문자열 반복
package BOJ_2675;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();         // String은 변경 불가능한 문자열 생성 but StringBuilder는 변경 가능한 문자열 만듦 -> String 합칠 때 유용
        StringTokenizer st;                             // String 입력값을 Token 형태로 자름

        int T = Integer.parseInt(br.readLine());        // T : 테스트 케이스의 개수
                                                        // 백준에서 제공하는 변수명 사용하기! & 변수는 가급적 적게 사용하기!(불필요한 변수 사용 X)
        for (int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());

            int R = Integer.parseInt(st.nextToken());   // R : 테스트 케이스 반복 횟수
            String[] S = st.nextToken().split("");  // S : 입력받은 문자열(한 문자씩 배열에 저장)

            for (int j=0; j<S.length; j++) {
                for (int k=0; k<R; k++) {
                    sb.append(S[j]);                    // StringBuilder에 값을 하나씩 append
                }
            }
            sb.append("\n");                            // 한 줄 append 완료시 \n로 열 분리
        }

        System.out.print(sb);                           // 넣어놓은 sb의 내용 출력
    }
}

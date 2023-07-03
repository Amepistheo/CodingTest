// 2741번 N 찍기
package BOJ_2741;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i=1; i<n+1; i++) {
            System.out.println(i);
        }
    }
}

/*import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();  // 버퍼에 한줄 입력 받겠다. return은 String 형태

        String[] inputArr = input.split(" ");  // 배열 형식으로 값을 받아오기 때문에 공백을 기준으로 나누겠다

        int a = Integer.parseInt(inputArr[0]);  // 정수 형태로 바꾸겠다

        //StringBuilder sb = new String Builder();
        StringBuffer sb = new StringBuffer();
        sb.append("123");
        System.out.println(sb);
    }
}*/

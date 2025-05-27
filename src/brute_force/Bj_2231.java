package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj_2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int inputNumber = Integer.parseInt(input);
        int limit = input.length() * 9;
        int result = 0;

        // 뒤에서 시작하는 아이디어가 진짜 좋다 실행 속도를 크게 개선시켰음
        for (int i = inputNumber - limit; i < inputNumber - 1; i++) {
            int quotient = i;
            int remainder = 0;

            do {
                remainder += quotient % 10;
                quotient = quotient / 10;

            } while (quotient != 0);

            int sum = i + remainder;

            if (sum == inputNumber) {
                result = i;

                break;
            }
        }

        System.out.print(result);
    }
}

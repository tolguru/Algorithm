import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BruteForce {
    public static void main(String[] args) throws IOException {
        bj_2231();
        bj_2309();
    }

    private static void bj_2231() throws IOException {
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

    private static void bj_2309() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] heights = new int[9];
        int totalHeight = 0;

        for (int i = 0; i < 9; i++) {
            int height = Integer.parseInt(br.readLine());

            heights[i] = height;
            totalHeight += height;
        }

        seekAndReplace(totalHeight, heights);
        Arrays.sort(heights);

        for (int i = 2; i < heights.length; i++) {
            System.out.println(heights[i]);
        }
    }

    private static void seekAndReplace(int totalHeight, int[] heights) {
        for (int i = 0; i < heights.length - 1; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                if (totalHeight - heights[i] - heights[j] == 100) {
                    heights[i] = -1;
                    heights[j] = -1;

                    return;
                }
            }
        }
    }
}
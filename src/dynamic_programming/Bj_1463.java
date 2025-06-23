package dynamic_programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bj_1463 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int input = Integer.parseInt(br.readLine());
        int operationCount = 0;

        while (input > 1) {
            System.out.println(input);
            float remainDivideThree = input / 3f;

            if (remainDivideThree == (int) remainDivideThree) {
                input = (int) remainDivideThree;
            } else {
                float remainDivideTwo = input / 4f;

                if (remainDivideTwo == (int) remainDivideTwo) {
                    input = (int) remainDivideTwo * 2;
                } else {
                    input--;
                }
            }

            operationCount++;
        }

        System.out.println(operationCount);
    }
}

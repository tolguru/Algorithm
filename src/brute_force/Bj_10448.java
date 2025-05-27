package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Bj_10448 {
    private static final int MAX_NUMBER = 1000;
    private static int[] triangularNumbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseCount = Integer.parseInt(br.readLine());
        int[] inputs = new int[caseCount];

        setTriangularNumbers();

        for (int i = 0; i < caseCount; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < caseCount; i++) {
            System.out.println(checkThree(inputs[i]));
        }
    }

    private static int checkThree(int targetNumber) {
        for (int i = 0; i < triangularNumbers.length; i++) {
            if (triangularNumbers[i] > targetNumber) {
                break;
            }

            for (int j = i; j < triangularNumbers.length; j++) {
                if (triangularNumbers[i] + triangularNumbers[j] > targetNumber) {
                    break;
                }

                for (int k = j; k < triangularNumbers.length; k++) {
                    int sum = triangularNumbers[i] + triangularNumbers[j] + triangularNumbers[k];

                    if (sum > targetNumber) {
                        break;
                    } else if (sum == targetNumber) {
                        return 1;
                    }
                }
            }
        }

        return 0;
    }

    private static void setTriangularNumbers() {
        ArrayList<Integer> triangularNumberList = new ArrayList<>();
        int count = 1;
        int triangularNumber = 1;

        do {
            triangularNumberList.add(triangularNumber);
            triangularNumber = ++count * (count + 1) / 2;
        }
        while (triangularNumber < MAX_NUMBER);

        triangularNumbers = new int[triangularNumberList.size()];

        for (int i = 0; i < triangularNumbers.length; i++) {
            triangularNumbers[i] = triangularNumberList.get(i);
        }
    }
}

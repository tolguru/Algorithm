package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj_3085 {
    private static char[][] candies;
    private static int boardSize;
    private static int maxCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boardSize = Integer.parseInt(br.readLine());
        maxCount = 0;
        candies = new char[boardSize][boardSize];

        for (int i = 0; i < boardSize; i++) {
            candies[i] = br.readLine().toCharArray();
        }

        setMax();

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize - 1; j++) {
                swap(i, j, i, j + 1);
                setMax();
                swap(i, j, i, j + 1);
                swap(j, i, j + 1, i);
                setMax();
                swap(j, i, j + 1, i);
            }
        }

        System.out.println(maxCount);
    }

    private static void setMax() {
        for (int i = 0; i < boardSize; i++) {
            int count = 1;

            for (int j = 0; j < boardSize - 1; j++) {
                if (candies[i][j] == candies[i][j + 1]) {
                    count++;
                } else {
                    maxCount = Math.max(maxCount, count);
                    count = 1;
                }
            }

            maxCount = Math.max(maxCount, count);
            count = 1;

            for (int j = 0; j < boardSize - 1; j++) {
                if (candies[j][i] == candies[j + 1][i]) {
                    count++;
                } else {
                    maxCount = Math.max(maxCount, count);
                    count = 1;
                }
            }

            maxCount = Math.max(maxCount, count);
        }
    }

    private static void swap(int beforeA, int beforeB, int afterA, int afterB) {
        char tmp = candies[beforeA][beforeB];
        candies[beforeA][beforeB] = candies[afterA][afterB];
        candies[afterA][afterB] = tmp;
    }
}
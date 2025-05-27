package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bj_2309 {
    public static void main(String[] args) throws IOException {
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

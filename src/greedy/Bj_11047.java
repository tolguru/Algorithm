package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj_11047 {
    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int coinCount = Integer.parseInt(st.nextToken());
        int goalMoney = Integer.parseInt(st.nextToken());
        int[] coins = new int[coinCount];

        for (int i = 0; i < coinCount; i++) {
            coins[i] = Integer.parseInt(bf.readLine());
        }

        int requiredCoins = 0;

        for (int i = coinCount - 1; i >= 0; i--) {
            if (coins[i] <= goalMoney) {
                requiredCoins += goalMoney / coins[i];
                goalMoney %= coins[i];
            }
        }

        System.out.println(requiredCoins);
    }
}
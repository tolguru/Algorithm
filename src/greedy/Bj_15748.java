package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Bj_15748 {
    public static void main(String[] args) throws Exception {
        readInt(); // L 버리기
        int N = readInt();
        int TF = readInt();
        int TB = readInt();

        RestPoint[] restPoints = new RestPoint[N];

        for (int i = 0; i < N; i++) {
            restPoints[i] = new RestPoint(readInt(), readInt());
        }

        // tastiness가 가장 높은 순으로 내림차순 정렬
        Arrays.sort(restPoints, new TastinessDescComparator());

        long tastiness = 0;
        long lastBessieArrivedTime = 0;
        long lastJohnArrivedTime = 0;
        int lastX = 0;

        // 휴식 지점이 멀리 있고 tastiness가 높을수록 최종 점수가 커진다.
        for (int i = 0; i < N; i++) {
            int x = restPoints[i].x;
            int c = restPoints[i].c;

            // 마지막 휴식 지점 위치보다 해당 휴식 지점이 더 멀리 있을 때만 계산
            if (lastX < x) {
                long johnArrivedTime = (long) TF * x;
                long bessieArrivedTime = (long) TB * x;
                long waitedSeconds = (johnArrivedTime - lastJohnArrivedTime) - (bessieArrivedTime - lastBessieArrivedTime);

                lastX = x;
                tastiness += waitedSeconds * c;
                lastJohnArrivedTime = johnArrivedTime;
                lastBessieArrivedTime = bessieArrivedTime;
            }
        }

        System.out.println(tastiness);
    }

    private static int readInt() throws Exception {
        int c;
        int n = System.in.read() & 15;

        while ((c = System.in.read()) >= 48) {
            n = (n * 10) + (c & 15);
        }

        return n;
    }

    private static class RestPoint {
        public int x;
        public int c;

        public RestPoint(int x, int c) {
            this.x = x;
            this.c = c;
        }
    }

    private static class TastinessDescComparator implements Comparator<RestPoint> {

        @Override
        public int compare(RestPoint o1, RestPoint o2) {
            return Integer.compare(o2.c, o1.c);
        }
    }
}
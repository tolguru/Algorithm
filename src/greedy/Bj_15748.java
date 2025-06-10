package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Bj_15748 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken(); // L 버리기
        int N = Integer.parseInt(st.nextToken());
        int TF = Integer.parseInt(st.nextToken());
        int TB = Integer.parseInt(st.nextToken());

        RestPoint[] restPoints = new RestPoint[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            restPoints[i] = new RestPoint(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // tastiness가 가장 높은 순으로 내림차순 정렬
        Arrays.sort(restPoints, new TastinessDescComparator());

        long tastiness = 0;
        long lastBessieArrivedTime = 0;
        long lastJohnArrivedTime = 0;
        int lastX = 0;

        /*
        휴식 지점이 멀리 있고 tastiness가 높을수록 최종 점수가 커진다.
         */
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
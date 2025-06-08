package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj_2212 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine()); // 센서 개수
        int K = Integer.parseInt(br.readLine()); // 집중국 개수

        // 집중국 개수가 센서 수보다 많으면 즉시 종료
        if (N <= K) {
            System.out.println(0);
            return;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sensors = new int[N];

        for (int i = 0; i < N; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }

        // 센서 순서 정렬
        Arrays.sort(sensors);

        int totalDistance = 0;
        int[] distances = new int[N - 1];

        // 센서별 거리 측정
        for (int i = 0; i < distances.length; i++) {
            int distance = sensors[i + 1] - sensors[i];
            distances[i] = distance;
            totalDistance += distance;
        }

        // 센서별 거리 정렬
        Arrays.sort(distances);

        int unitCount = 1;

        /*
        센서 묶음을 한 집합으로 보고 시작한 후 가장 사이가 먼 센서들의 연결을 제외해가며 집합 수를 늘린다.
        집합 수가 집중국 개수와 같아지면 종료된다.
         */
        while (unitCount < K) {
            totalDistance -= distances[distances.length - unitCount];
            unitCount++;
        }

        System.out.println(totalDistance);
    }
}

package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Bj_1700 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int holeCount = Integer.parseInt(st.nextToken());
        int usageCount = Integer.parseInt(st.nextToken());

        StringTokenizer devicesSt = new StringTokenizer(br.readLine());
        int[] usageSequence = new int[usageCount];

        for (int i = 0; i < usageCount; i++) {
            usageSequence[i] = Integer.parseInt(devicesSt.nextToken());
        }

        Device[] devices = new Device[usageCount];
        Map<Integer, Integer> lastIndexMap = new HashMap<>();

        // 각 Device 객체는 다음 Device까지의 거리를 가진다.
        for (int i = usageCount - 1; i >= 0; i--) {
            int deviceName = usageSequence[i];
            int lastIndex = lastIndexMap.getOrDefault(deviceName, i);
            int distance = lastIndex == i ? Integer.MAX_VALUE : lastIndex - i;

            devices[i] = new Device(deviceName, distance);

            lastIndexMap.put(deviceName, i);
        }

        // 다음 사용까지 거리가 가장 먼 객체를 root로 지정하는 우선순위 큐
        PriorityQueue<Device> deviceQueue = new PriorityQueue<>(new DistanceDescComparator());
        int swapCount = 0;

        for (int i = 0; i < usageCount; i++) {
            deviceQueue.forEach(device -> device.distance--);

            Device device = devices[i];

            // 큐에 동일한 Device가 있을 때 제거. equals 기준은 Device.deviceName
            deviceQueue.remove(device);

            // 다음 사용까지 거리가 가장 먼 객체 제거
            if (deviceQueue.size() >= holeCount) {
                deviceQueue.poll();
                swapCount++;
            }

            deviceQueue.offer(device);
        }

        System.out.println(swapCount);
    }

    static class Device {
        public int deviceName;
        public int distance;

        public Device(int deviceName, int distance) {
            this.deviceName = deviceName;
            this.distance = distance;
        }

        @Override
        public boolean equals(Object obj) {
            if (this.deviceName == ((Device) obj).deviceName) {
                return true;
            }

            return super.equals(obj);
        }
    }

    static class DistanceDescComparator implements Comparator<Device> {

        @Override
        public int compare(Device o1, Device o2) {
            return Integer.compare(o2.distance, o1.distance);
        }
    }
}
package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Bj_1700 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer devicesSt = new StringTokenizer(br.readLine());
        int holeCount = Integer.parseInt(st.nextToken());
        int usageCount = Integer.parseInt(st.nextToken());
//        int[] deviceUsage = new int[usageCount];
        Device[] devices = new Device[usageCount];
        Map<Integer, Integer> lastIndexMap = new HashMap<>();

        for (int i = usageCount - 1; i >= 0; i--) {
            int deviceName = Integer.parseInt(devicesSt.nextToken());

//            deviceUsage[i] = deviceName;

            int lastIndex = lastIndexMap.getOrDefault(deviceName, 0);
            devices[i] = new Device(deviceName, lastIndex == 0 ? 0 : lastIndex - i);

            lastIndexMap.put(deviceName, i);

//            if (device == null) {
//                devices.put(deviceName, new Device(deviceName, i));
//            } else {
//                device.lastIndex = i;
//            }
        }

        for (int i = 0; i < devices.length; i++) {
            System.out.println(devices[i].deviceName + " 거리 : " + devices[i].distance);
        }

        PriorityQueue<Device> queue = new PriorityQueue<>(new DistanceDescComparator());
        int swapCount = 0;

        for (int i = 0; i < usageCount; i++) {
//            Device device = devices.get(deviceUsage[i]);
            Device device = devices[i];

            if (queue.contains(device)) {
                continue;
            }

            if (queue.size() >= holeCount) {
                queue.poll();
                swapCount++;
            }

            queue.offer(device);
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
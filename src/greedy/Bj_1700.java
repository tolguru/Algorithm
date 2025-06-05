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

        st = new StringTokenizer(br.readLine());
        int[] usageSequence = new int[usageCount];

        for (int i = 0; i < usageCount; i++) {
            usageSequence[i] = Integer.parseInt(st.nextToken());
        }

        Device[] devices = new Device[usageCount];
        Map<Integer, Integer> lastIndexMap = new HashMap<>();

        // 각 Device 객체는 다음 Device까지의 거리를 가진다.
        for (int i = usageCount - 1; i >= 0; i--) {
            int deviceName = usageSequence[i];
            int lastIndex = lastIndexMap.getOrDefault(deviceName, i);
            int distance = lastIndex == i ? Integer.MAX_VALUE : lastIndex - i;

            devices[i] = new Device(i, deviceName, distance);

            lastIndexMap.put(deviceName, i);
        }

        Map<Integer, Device> multitap = new HashMap<>();
        int swapCount = 0;

        for (int i = 0; i < usageCount; i++) {
            Device device = devices[i];

            if (multitap.containsKey(device.deviceName) || multitap.size() < holeCount) {
                multitap.put(device.deviceName, device);
                continue;
            }

            int index = i;

            Optional<Device> max = multitap.values().stream().max(Comparator.comparingInt(o -> o.distance - (index - o.index)));
            multitap.remove(max.get().deviceName);
            multitap.put(device.deviceName, device);
            swapCount++;
        }

        System.out.println(swapCount);
    }

    static class Device {
        public int index;
        public int deviceName;
        public int distance;

        public Device(int index, int deviceName, int distance) {
            this.index = index;
            this.deviceName = deviceName;
            this.distance = distance;
        }
    }
}
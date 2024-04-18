package task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Map Lock:");
		Map<String, String> map = new MapLock<>();

		ArrayList<String> th1Keys = new ArrayList<>(Arrays.asList("th1_k1", "th1_k2", "th1_k3", "th1_k4", "th1_k5"));
		ArrayList<String> th1Values = new ArrayList<>(Arrays.asList("th1_v1", "th1_v2", "th1_v3", "th1_v4", "th1_v5"));

		ArrayList<String> th2Keys = new ArrayList<>(Arrays.asList("th2_k1", "th2_k2", "th2_k3", "th2_k4", "th2_k5"));
		ArrayList<String> th2Values = new ArrayList<>(Arrays.asList("th2_v1", "th2_v2", "th2_v3", "th2_v4", "th2_v5"));

		Thread MapLockTh1 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				map.put(th1Keys.get(i), th1Values.get(i));
			}
		});

		Thread MapLockTh2 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				map.put(th2Keys.get(i), th2Values.get(i));
			}
		});

		MapLockTh1.start();
		MapLockTh2.start();

		MapLockTh1.join();
		MapLockTh2.join();

		map.forEach((key, value) -> System.out.println(key + ": " + value));

		System.out.println("---------------------------------------");
		System.out.println("Set Synchronized:");

		ArrayList<String> th3Values = new ArrayList<>(Arrays.asList("th3_v1", "th3_v2", "th3_v3", "th3_v4", "th3_v5"));
		ArrayList<String> th4Values = new ArrayList<>(Arrays.asList("th4_v1", "th4_v2", "th4_v3", "th4_v4", "th4_v5"));

		Set<String> set = new SetSync<>();

		Thread SetSyncTh1 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				set.add(th3Values.get(i));
			}
		});

		Thread SetSyncTh2 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				set.add(th4Values.get(i));
			}
		});

		SetSyncTh1.start();
		SetSyncTh2.start();

		Thread.sleep(1000);

		set.forEach((value) -> System.out.print(value + " "));
	}
}

package Programmers;

import java.util.*;

public class ±Ö°í¸£±â {

	public static void main(String[] args) {
		int k = 6;
		int[] tangerine = { 1, 3, 2, 5, 4, 5, 2, 3 };

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < tangerine.length; i++) {
			if (!map.containsKey(tangerine[i])) {
				map.put(tangerine[i], 1);
			} else {
				map.put(tangerine[i], map.get(tangerine[i]) + 1);
			}
		}

		ArrayList<Integer> keySetList = new ArrayList<>(map.keySet());

		Collections.sort(keySetList, (o1, o2) -> (map.get(o1).compareTo(map.get(o2))));

		int mandarinCount = tangerine.length - k;

		while (mandarinCount > 0) {
			for (int i = 0; i < keySetList.size(); i++) {
				if (map.get(keySetList.get(i)) > mandarinCount) {
					mandarinCount -= map.get(keySetList.get(i));
				} else {
					mandarinCount -= map.get(keySetList.get(i));
					map.remove(keySetList.get(i));
				}
			}
		}

		System.out.println(map);

	}

}

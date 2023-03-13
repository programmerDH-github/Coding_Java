package Programmers;

import java.util.*;

public class 베스트앨범 {

	public static void main(String[] args) {
		String[] genres = { "classic", "pop", "classic", "classic", "pop" };
		int[] plays = { 500, 600, 150, 800, 2500 };
		
		// 장르 별 재생 합계
		HashMap<String, Integer> map = new HashMap<>();		
		for (int i = 0; i < genres.length; i++) {
			if (!map.containsKey(genres[i])) {
				map.put(genres[i], plays[i]);
			} else {
				map.put(genres[i], map.get(genres[i]) + plays[i]);
			}
		}
		
		// 재생 합계가 많은 순서로 Key값 정렬
		ArrayList<String> genres_order = new ArrayList<>();
		while (map.size() != 0) {
			int max = -1;
			String max_key = "";
			for (String Key : map.keySet()) {
				int temp = map.get(Key);
				if (temp > max) {
					max = temp;
					max_key = Key;
				}
			}
			genres_order.add(max_key);
			map.remove(max_key);
		}
		
		//장르 내에서 재생 횟수대로 최대 2곡의 고유번호 저장
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < genres_order.size(); i++) {
			int first_num = 0;
			int second_num = 0;
			int first_idx = -1;
			int second_idx = -1;
			for (int j = 0; j < genres.length; j++) {
				if (genres_order.get(i).equals(genres[j])) {
					if (first_num == 0) {
						first_idx = j;
						first_num = plays[j];
					} 
					else if (second_num == 0) {
						if (first_num < plays[j]) {
							second_idx = first_idx;
							second_num = first_num;
							first_idx = j;
							first_num = plays[j];
						} 
						else {
							second_idx = j;
							second_num = plays[j];
						}
					} 
					else {
						if (first_num < plays[j]) {
							if(second_num <= first_num) {
								second_idx = first_idx;
								second_num = first_num;
								first_idx = j;
								first_num = plays[j];
							}
							else {
								first_idx = j;
								first_num = plays[j];
							}
						}
						else if(second_num < plays[j]) {
							second_idx = j;
							second_num = plays[j];
						}
					}

				}
			}

			if (first_idx != -1) result.add(first_idx);
			if (second_idx != -1) result.add(second_idx);
		}
		//결과
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
            System.out.print(answer[i]+" ");
        }
		
	}

}

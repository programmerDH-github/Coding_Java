package Programmers;

import java.util.*;

public class KAKAO_BLIND_RECRUITMENT_2018_3Â÷_¾ÐÃà {

	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<>();
		ArrayList<Integer> arraylist = new ArrayList<>();
		String msg = "KAKAO";
		for (int i = 1; i < 27; i++) {
			map.put(i, ((char) (i + 64)) + "");
		}
        
        if(msg.length() == 1) {
            int[] answer = {1};
            System.out.println(1);
            return;
        }

		int last_number = 27;
		String new_str = "";
		String str = "";
		for (int i = 0; i < msg.length(); i++) {
			str += msg.charAt(i);
			new_str = str;
			for (int j = i + 1; j < msg.length(); j++) {
				new_str += msg.charAt(j);
				if (map.containsValue(new_str)) {
					if (j == msg.length() - 1) {
						for (Integer key : map.keySet()) {
							String value = map.get(key);
							if (value.equals(new_str)) {
								arraylist.add(key);
								break;
							}
						}
						i = j - 1;
						break;
					}
					str = new_str;
					continue;
				} else {
					for (Integer key : map.keySet()) {
						String value = map.get(key);
						if (value.equals(str)) {
							arraylist.add(key);
							str = "";
							break;
						}

					}

					if (j >= msg.length() - 1) {
						for (Integer key : map.keySet()) {
							String value = map.get(key);
							if (value.equals(msg.charAt(j)+"")) {
								arraylist.add(key);
								break;
							}
						}
						i = j - 1;
						break;
					}
					if (str.equals("")) {
						i = j - 1;
						break;
					}
				}
			}

			map.put(last_number, new_str);
			last_number++;
		}
        
        
        
        int[] answer = new int[arraylist.size()];
        
        for(int i = 0; i < arraylist.size(); i++) answer[i] = arraylist.get(i);
       
        System.out.println(arraylist);

	}

}

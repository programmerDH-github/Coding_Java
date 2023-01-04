package Programmers;
import java.util.*;

public class 주차요금계산 {

	public static void main(String[] args) {
		int[] fee = {180, 5000, 10, 600};
		String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
		int max_time = 23 * 60 + 59;
		HashMap<String,String> car_map = new HashMap<>();
		HashMap<Integer,Integer> fee_map = new HashMap<>();
		
		for(int i = 0; i < records.length; i++) {
			String[] record = records[i].split(" ");
			if(!fee_map.containsKey(Integer.parseInt(record[1]))) {
				fee_map.put(Integer.parseInt(record[1]),0);
			}
			if(car_map.containsKey(record[1]) && record[2].equals("OUT")) {
				String[] in_time = car_map.get(record[1]).split(":");
				String[] out_time = record[0].split(":");
				
				int in_time_min = Integer.parseInt(in_time[0]) * 60 + Integer.parseInt(in_time[1]);
				int out_time_min = Integer.parseInt(out_time[0]) * 60 + Integer.parseInt(out_time[1]);
					
				fee_map.put(Integer.parseInt(record[1]),out_time_min-in_time_min);
				
				car_map.remove(record[1]);
				
			}
			else {
				car_map.put(record[1], record[0]);
			}
		}
		
		for(String key : car_map.keySet()) {
			String[] in_time = car_map.get(key).split(":");
			
			int in_time_min = Integer.parseInt(in_time[0]) * 60 + Integer.parseInt(in_time[1]);
			
			if(fee_map.containsKey(Integer.parseInt(key))) {
				fee_map.put(Integer.parseInt(key),fee_map.get(Integer.parseInt(key))+max_time-in_time_min);
			}
			else {
				fee_map.put(Integer.parseInt(key),max_time-in_time_min);
			}
			
		}
		
		ArrayList<Integer> arraylist = new ArrayList<>(fee_map.keySet());
		System.out.println(arraylist);
		Collections.sort(arraylist);
		
		int[] answer = new int[arraylist.size()];
		for(int i = 0; i < arraylist.size(); i++) {
			if(fee_map.get(arraylist.get(i)) - fee[0] <= 0) answer[i] = fee[1];
			else answer[i] = fee[1] + (int)Math.ceil((fee_map.get(arraylist.get(i)) - fee[0]) / (double)fee[2]) * fee[3];
			System.out.println(answer[i]);
		}

	}

}

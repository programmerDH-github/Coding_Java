package Test;

import java.util.ArrayList;
import java.util.Arrays;

public class 카카오_2022_신입공채_1차_3번 {

	public static void main(String[] args) {
		int[] fees = {180, 5000, 10, 600};
		String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", 
				"07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", 
				"23:00 5961 OUT"};
		int[] answer;
        ArrayList<Integer> arraylistFees= new ArrayList<>();
        
        for(int i = 0; i < records.length; i++) {
            String[] s = records[i].split(" ");
            records[i] = s[1] + " " + records[i];
        }
        
        Arrays.sort(records);
        
        int sum = 0;
        int inTime = 0;
        int endTime = 23*60 + 59;
        for(int i = 0; i < records.length; i++) {
        	String[] record = records[i].split(" ");
        	String[] time = record[1].split(":");
        	
        	if(i == 0) {
        		inTime = Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
        		continue;
        	}
        	if(i == records.length-1) {
        		if(record[3].equals("IN")) {
        			inTime = Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
        			sum += endTime - inTime;
        			arraylistFees.add(sum);
        			break;
        		}
        		else {
        			int outTime = Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
            		sum += outTime - inTime;
            		arraylistFees.add(sum);
            		break;
        		}
        	}
        	if(record[3].equals("IN")) {
        		String[] pastRecord = records[i-1].split(" ");
        		String[] pastTime = pastRecord[1].split(":");
        		inTime = Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
        		
        		if(!record[0].equals(pastRecord[0]) && pastRecord[3].equals("IN")) {
        			int pastInTime = Integer.parseInt(pastTime[0])*60 + Integer.parseInt(pastTime[1]);
        			sum += endTime - pastInTime;
        			arraylistFees.add(sum);
        			sum = 0;
        		}
        		else if(!record[0].equals(pastRecord[0]) && pastRecord[3].equals("OUT")){
        			arraylistFees.add(sum);
        			sum = 0;
        		}
        	}
        	else {
        		int outTime = Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
        		sum += outTime - inTime;
        		
        	}
        	
        }
        
        answer = new int[arraylistFees.size()];
        
        for(int i = 0; i < arraylistFees.size(); i++) {
        	System.out.println(arraylistFees.get(i));
        	if(fees[0] >= arraylistFees.get(i)) {
        		answer[i] = fees[1];
        	}
        	else {
        		answer[i] = fees[1] + (int)Math.ceil((((arraylistFees.get(i) - fees[0])*1.0) / fees[2])) * fees[3];
        	}
        	System.out.println(answer[i]);
        }

	}

}

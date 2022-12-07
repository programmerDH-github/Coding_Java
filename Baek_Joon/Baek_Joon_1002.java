package Baek_Joon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek_Joon_1002 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			String[] location = br.readLine().split(" ");
			
			int x1 = Integer.parseInt(location[0]);
			int y1 = Integer.parseInt(location[1]);
			int r1 = Integer.parseInt(location[2]);
			
			int x2 = Integer.parseInt(location[3]);
			int y2 = Integer.parseInt(location[4]);
			int r2 = Integer.parseInt(location[5]);
			
			double distance = Math.sqrt(Math.pow((x1-x2),2) + Math.pow((y1-y2),2));
			int sum = r1 + r2;
			int sub = Math.abs(r1-r2);
			
			if(distance == 0 && r1 == r2) System.out.println("-1");				//원이 정확히 일치할 때
			else if(distance < sub) System.out.println("0");					//원이 내부에 있으며 만나지 않을 때
			else if(distance > sum) System.out.println("0");					//원이 내부에 없으며 만나지 않을 때
			else if(distance == sub) System.out.println("1");					//원이 내접할 때
			else if(distance == sum) System.out.println("1");					//원이 외접할 때
			else if(distance < sum && distance > sub) System.out.println("2");	//원이 서로 다른 두 점에서 만날 때
		}
		
		return;
	}
}
package Baek_Joon;

import java.io.*;

public class Baek_Joon_1063 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String[] chess = br.readLine().split(" ");
		int N = Integer.parseInt(chess[2]);
		
		String[][] location = new String[8][8];
		
		for(int i = 0; i < location.length; i++) {
			for(int j = 0; j < location.length; j++) {
				location[i][j] = (char)(j+65) +""+ (location.length-i);
			}
		}
		
		int king_x = 0;
		int king_y = 0;
		int rock_x = 0;
		int rock_y = 0;
		
		for(int i = 0; i < location.length; i++) {
			for(int j = 0; j < location[i].length; j++) {
				if(chess[0].equals(location[i][j])) {
					king_x = i;
					king_y = j;
				}
				
				if(chess[1].equals(location[i][j])) {
					rock_x = i;
					rock_y = j;
				}
				
			}
		}
		
		for(int i = 0; i < N; i++) {
			String direct = br.readLine();
			
			if(direct.equals("R")) {		//한 칸 오른쪽으로
				if(king_y+1 < location.length) {
					if(king_x == rock_x && king_y+1 == rock_y) {
						if(rock_y+1 < location.length) {
							king_y++;
							rock_y++;
						}
					}
					else {
						king_y++;
					}
				}
			}
			else if(direct.equals("L")) {	//한 칸 왼쪽으로
				if(king_y-1 >= 0) {
					if(king_x == rock_x && king_y-1 == rock_y) {
						if(rock_y-1 >= 0) {
							king_y--;
							rock_y--;
						}
					}
					else {
						king_y--;
					}
				}				
			}
			else if(direct.equals("B")) {	//한 칸 아래로
				if(king_x+1 < location.length) {					
					if(king_x+1 == rock_x && king_y == rock_y) {
						if(rock_x+1 < location.length) {
							king_x++;
							rock_x++;
						}
					}
					else {
						king_x++;
					}
				}				
			}
			else if(direct.equals("T")) {	//한 칸 위로
				if(king_x-1 >= 0) {					
					if(king_x-1 == rock_x && king_y == rock_y) {
						if(rock_x-1 >= 0) {
							king_x--;
							rock_x--;
						}
					}
					else {
						king_x--;
					}
				}				
			}
			else if(direct.equals("RT")) { 	//오른쪽 위 대각선으로
				if(king_x-1 >= 0 && king_y+1 < location.length) {
					if(king_x-1 == rock_x && king_y+1 == rock_y) {
						if(rock_x-1 >= 0 && rock_y+1 < location.length) {
							king_x--;
							king_y++;
							rock_x--;
							rock_y++;
						}
					}
					else {
						king_x--;
						king_y++;
					}
				}			
			}
			else if(direct.equals("LT")) {	//왼쪽 위 대각선으로
				if(king_x-1 >= 0 && king_y-1 >= 0) {
					if(king_x-1 == rock_x && king_y-1 == rock_y) {
						if(rock_x-1 >= 0 && rock_y-1 >= 0) {
							king_x--;
							king_y--;
							rock_x--;
							rock_y--;
						}
					}
					else {
						king_x--;
						king_y--;
					}
				}				
			}
			else if(direct.equals("RB")) {	//오른쪽 아래 대각선으로
				if(king_x+1 == rock_x && king_y+1 == rock_y) {
					if(king_x+1 < location.length && king_y+1 < location.length 
							&& rock_x+1 < location.length && rock_y+1 < location.length) {
						king_x++;
						king_y++;
						rock_x++;
						rock_y++;
					}
				}
				else {
					if(king_x+1 < location.length && king_y+1 < location.length) {
						king_x++;
						king_y++;
					}
				}							
			}
			else if(direct.equals("LB")) {	//왼쪽 아래 대각선으로
				if(king_x+1 < location.length && king_y-1 >= 0) {					
					if(king_x+1 == rock_x && king_y-1 == rock_y) {
						if(rock_x+1 < location.length && rock_y-1 >= 0) {
							king_x++;
							king_y--;
							rock_x++;
							rock_y--;
						}
					}
					else {
						king_x++;
						king_y--;
					}
				}	
			}
			
		}
		
		System.out.println(location[king_x][king_y]);
		System.out.print(location[rock_x][rock_y]);
	}

}

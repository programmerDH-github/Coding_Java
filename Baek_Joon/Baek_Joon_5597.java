package Baek_Joon;

import java.io.*;
import java.util.*;

public class Baek_Joon_5597 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> arraylist = new ArrayList<>();
		
		for(int i = 1; i <= 30; i++) arraylist.add(i+"");
		
		for(int i = 0; i < 28; i++) {
			arraylist.remove(br.readLine());
		}
		
		for(int i = 0; i < arraylist.size(); i++) System.out.println(arraylist.get(i));
	}

}

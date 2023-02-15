package Softeer;

import java.util.*;
import java.io.*;

public class 근무_시간 {
	public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        for(int i = 0; i < 5; i++) {
            String[] time = br.readLine().split(" ");
            String[] start = time[0].split(":");
            String[] end = time[1].split(":");

            answer += Integer.parseInt(end[0])*60 + Integer.parseInt(end[1]);
            answer -= Integer.parseInt(start[0])*60 + Integer.parseInt(start[1]);
        }
        System.out.println(answer);
    }
}

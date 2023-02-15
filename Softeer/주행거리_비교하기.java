package Softeer;

import java.util.*;
import java.io.*;

public class 주행거리_비교하기 {
	public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] drive = br.readLine().split(" ");

        String answer = "";
        
        if(Integer.parseInt(drive[0]) > Integer.parseInt(drive[1])) answer = "A";
        else if(Integer.parseInt(drive[0]) == Integer.parseInt(drive[1])) answer = "same";
        else answer = "B";

        System.out.println(answer);
    }
}

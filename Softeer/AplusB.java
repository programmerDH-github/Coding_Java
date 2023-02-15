package Softeer;

import java.util.*;
import java.io.*;

public class AplusB {
	public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            String[] number = br.readLine().split(" ");
            int sum = Integer.parseInt(number[0])+Integer.parseInt(number[1]);
            System.out.println("Case #"+(i+1)+": "+sum);
        }
        
    }
}

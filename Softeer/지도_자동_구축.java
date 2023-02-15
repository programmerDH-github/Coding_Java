package Softeer;

import java.util.*;
import java.io.*;

public class 지도_자동_구축 {
	public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
                      
        int answer = (int)Math.pow(2,N) + 1;
        System.out.println((int)Math.pow(answer,2));
    }
}

package Softeer;

import java.util.*;
import java.io.*;

public class ����Ÿ�_���ϱ� {
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

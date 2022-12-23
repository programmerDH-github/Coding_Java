package Baek_Joon;
import java.io.*;

public class Baek_Joon_26264 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		String security = "security";
		String bigdata = "bigdata";
		
		int str_length = str.length();
		
		str = str.replace(security,"");
		
		int security_count = (str_length - str.length()) / security.length();
		int bigdata_count = str.length() / bigdata.length();
		
		if(bigdata_count > security_count) System.out.println("bigdata?");
		else if(bigdata_count == security_count) System.out.println("bigdata? security!");
		else System.out.println("security!");
	}

}

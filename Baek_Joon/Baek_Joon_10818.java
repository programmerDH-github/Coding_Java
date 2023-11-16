import java.io.*;
/**
 * Baek_Joon_10818
 */
public class Baek_Joon_10818 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] num = br.readLine().split(" ");
        
        int max = -1000000;
        int min = 1000000;
        for(int i = 0; i < N; i++) {
            int number = Integer.parseInt(num[i]);

            if(max < number) max = number;
            if(min > number) min = number;
        }
        System.out.println(min+" "+max);
    }    
}
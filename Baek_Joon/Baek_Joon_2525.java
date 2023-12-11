import java.io.*;

public class Baek_Joon_2525 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] time = br.readLine().split(" ");
        int h = Integer.parseInt(time[0]);
        int m = Integer.parseInt(time[1]);

        int cook = Integer.parseInt(br.readLine());

        m += cook;
        h += m / 60;
        m = m % 60;
        if(h == 24) h = 0;
        else if(h > 24) h = h % 24;
        
        System.out.println(h+" "+m);
    }
}

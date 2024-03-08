import java.io.*;
import java.util.*;

public class Baek_Joon_1436 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        String six = "666";
        int num = 666;
        while(list.size() < N) {            
            String str = num + "";
            if(str.contains(six)) list.add(Integer.parseInt(str));
            num++;
        }

        System.out.println(list.get(list.size()-1));
        
    }
}

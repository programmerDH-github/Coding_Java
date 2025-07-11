import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Baek_Joon_3107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] IPv6 = br.readLine().split(":");
        
        String[] answer = new String[8];
        Arrays.fill(answer, "");

        ArrayList<Integer> arraylist = new ArrayList<>();
        int targetIndex = Integer.MAX_VALUE;
        for(int i = 0; i < IPv6.length; i++) {
            if(!IPv6[i].equals("")) arraylist.add(i);
            else targetIndex = i;
        }
        
        for(int i = 0; i < arraylist.size(); i++) {
            int idx = arraylist.get(i);
            if(targetIndex < arraylist.get(i)) idx = arraylist.get(i)+(8-IPv6.length);
            answer[idx] = IPv6[arraylist.get(i)];
        }
 

        for(int i = 0; i < 8; i++) {
            answer[i] = String.format("%4s", answer[i]).replace(" ", "0");
        }

        for(int i = 0; i < answer.length; i++) {
            if(i == answer.length-1) sb.append(answer[i]);
            else sb.append(answer[i]).append(":");
        }

        System.out.println(sb);

    }
}

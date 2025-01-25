import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baek_Joon_9536 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");
            ArrayList<String> arraylist = new ArrayList<>();
            for(String crying : input) arraylist.add(crying);

            ArrayList crying = new ArrayList<>();
            while(true) {
                String[] sound = br.readLine().split(" ");

                if(sound.length > 3) {
                    for(int j = 0; j < arraylist.size(); j++) {
                        if(!crying.contains(arraylist.get(j))) sb.append(arraylist.get(j)+" ");
                    }
                    break;
                }

                crying.add(sound[2]);

                
            }
        }

        System.out.println(sb);

    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baek_Joon_31836 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();          

        while(N >= 3) {
            first.add(N-2);
            first.add(N-1);
            second.add(N);
            N -= 3;
        }

        if(N == 2) {
            first.add(1);
            second.add(2);
        }

        sb.append(first.size()).append("\n");
        for(int i = 0; i < first.size(); i++) sb.append(first.get(i)).append(" ");        

        sb.append("\n").append(second.size()).append("\n");
        for(int i = 0; i < second.size(); i++) sb.append(second.get(i)).append(" ");
        
        System.out.println(sb);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Baek_Joon_10814 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] customer = new String[N][2];

        for(int i = 0; i < N; i++) {
            String[] info = br.readLine().split(" ");
            customer[i][0] = info[0];
            customer[i][1] = info[1];
        }

        Arrays.sort(customer, new Comparator<String[]>(){
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
            }
        });

        for(int i = 0; i < N; i++) {
            System.out.println(customer[i][0] +" "+ customer[i][1]);
        }
    }
}

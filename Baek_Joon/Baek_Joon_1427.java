import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Baek_Joon_1427 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] N = br.readLine().split("");

        Arrays.sort(N, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        for(int i = 0; i < N.length; i++) {
            sb.append(N[i]);
        }
        System.out.println(sb);
    }
}

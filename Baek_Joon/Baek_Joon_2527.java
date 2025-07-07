import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_2527 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < 4; i++) {
            String[] input = br.readLine().split(" ");
            int firstX1 = Integer.parseInt(input[0]);
            int firstY1 = Integer.parseInt(input[1]);
            int firstX2 = Integer.parseInt(input[2]);
            int firstY2 = Integer.parseInt(input[3]);

            int secondX1 = Integer.parseInt(input[4]);
            int secondY1 = Integer.parseInt(input[5]);
            int secondX2 = Integer.parseInt(input[6]);
            int secondY2 = Integer.parseInt(input[7]);

            if(firstX2 < secondX1 || firstX1 > secondX2 || firstY2 < secondY1 || firstY1 > secondY2) sb.append("d").append("\n");
            else if((firstX1 == secondX2 && firstY2 == secondY1) || (firstX2 == secondX1 && firstY2 == secondY1) 
            || (firstX2 == secondX1 && firstY1 == secondY2) || (firstX1 == secondX2 && firstY1 == secondY2)) sb.append("c").append("\n");
            else if(firstX1 == secondX2 || firstY1 == secondY2 || firstX2 == secondX1 || firstY2 == secondY1) sb.append("b").append("\n");
            else sb.append("a").append("\n");

        }

        System.out.println(sb);

    }
}
